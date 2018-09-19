package it.unibo.goffo.fag;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.extra.ai.pathfinding.AStarGrid;
import com.almasb.fxgl.extra.ai.pathfinding.NodeState;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.InputMapping;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.parser.tiled.TiledMap;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.settings.GameSettings;
import com.almasb.fxgl.ui.FXGLTextFlow;
import com.almasb.fxgl.ui.UI;
import it.unibo.goffo.fag.collision.BulletZombieCollision;
import it.unibo.goffo.fag.collision.PlayerZombieCollision;
import it.unibo.goffo.fag.entities.Bullet;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.entities.Player;
import it.unibo.goffo.fag.entities.Zombie;
import it.unibo.goffo.fag.entities.builders.BulletFactory;
import it.unibo.goffo.fag.entities.builders.PlayerFactory;
import it.unibo.goffo.fag.entities.movement.MoveDirection;
import it.unibo.goffo.fag.spawn.controller.SpawnController;
import it.unibo.goffo.fag.spawn.controller.SpawnControllerImpl;
import it.unibo.goffo.fag.spawn.view.SpawnView;
import it.unibo.goffo.fag.spawn.view.SpawnViewImpl;
import it.unibo.goffo.fag.exceptions.GameOverException;
import it.unibo.goffo.fag.ui.hud.HUDController;
import it.unibo.goffo.fag.ui.menu.FAGMenuFactory;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Main class, used to launch FXGL.
 */
public class FightAvengeGuerrillaApp extends GameApplication {

    private AStarGrid grid;
    private Player player;

    private final PlayerZombieCollision pzCollision = new PlayerZombieCollision();
    private final BulletZombieCollision bzCollision = new BulletZombieCollision();
    private SpawnController spawnController = new SpawnControllerImpl();

    /**
     * Main method launch the game engine.
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        launch(args);
    }

    /**
     * Return the grid used in the game.
     * @return the game's grid.
     */
    public AStarGrid getGrid() {
        return this.grid;
    }

    /**
     * Method that return the player in the game.
     * @return Return the player.
     */
    public Entity getPlayer() {
        return getGameWorld().getSingleton(FagType.PLAYER).get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSettings(final GameSettings settings) {
        settings.setWidth(FagUtils.MAP_WIDTH * FagUtils.TILE_SIZE);
        settings.setHeight(FagUtils.MAP_HEIGHT * FagUtils.TILE_SIZE);
        settings.setTitle(FagUtils.APPLICATION_NAME);
        settings.setMenuEnabled(true);
        settings.setSceneFactory(new FAGMenuFactory());
//        settings.setApplicationMode(ApplicationMode.RELEASE);

        /*
         * Trying to disable sound
         */
        getAudioPlayer().setGlobalMusicVolume(0.0);
        getAudioPlayer().setGlobalSoundVolume(0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initInput() {
        final Input input = getInput();

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onActionBegin() {
                player.playWalkAnimation(MoveDirection.RIGHT);
            }

            @Override
            protected void onAction() {
                player.moveRight();
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.RIGHT);
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onActionBegin() {
                player.playWalkAnimation(MoveDirection.LEFT);
            }

            @Override
            protected void onAction() {
                player.moveLeft();
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.LEFT);
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onActionBegin() {
                player.playWalkAnimation(MoveDirection.UP);
            }

            @Override
            protected void onAction() {
                player.moveUp();
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.UP);
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onActionBegin() {
                player.playWalkAnimation(MoveDirection.DOWN);
            }

            @Override
            protected void onAction() {
                player.moveDown();
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.DOWN);
            }
        }, KeyCode.S);

        input.addAction(new UserAction("Rotate Left") {
            @Override
            protected void onActionBegin() {
                BulletFactory.createBullet(new Point2D(-1, 0));
                player.playWalkAnimation(MoveDirection.LEFT);
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.LEFT);
            }
        }, KeyCode.LEFT);

        input.addAction(new UserAction("Rotate Right") {

            @Override
            protected void onActionBegin() {
                BulletFactory.createBullet(new Point2D(1, 0));
                player.playWalkAnimation(MoveDirection.RIGHT);
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.RIGHT);
            }
        }, KeyCode.RIGHT);

        input.addAction(new UserAction("Rotate Up") {
            @Override
            protected void onActionBegin() {
                BulletFactory.createBullet(new Point2D(0, -1));
                player.playWalkAnimation(MoveDirection.UP);
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.UP);
            }
        }, KeyCode.UP);

        input.addAction(new UserAction("Rotate Down") {
            @Override
            protected void onActionBegin() {
                BulletFactory.createBullet(new Point2D(0, 1));
                player.playWalkAnimation(MoveDirection.DOWN);
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.DOWN);
            }
        }, KeyCode.DOWN);
        getInput().addInputMapping(new InputMapping("Show Notification", KeyCode.F));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initGame() {
        grid = new AStarGrid(FagUtils.MAP_WIDTH, FagUtils.MAP_HEIGHT);
        spawnController = new SpawnControllerImpl();
        spawnController.reset();
        spawnController.startSpawn();
        final SpawnView spawnView = new SpawnViewImpl(spawnController);
        spawnView.subscribeHandler(e -> Platform.runLater(() -> FXGL.getApp().getGameWorld().addEntity(e)));

        getGameWorld().addEntityFactory(new LevelFactory());
        final TiledMap map = getAssetLoader().loadJSON("level1.json", TiledMap.class);
        getGameWorld().setLevelFromMap(map);

        getGameWorld().getEntitiesByType(FagType.WALL)
                .stream()
                .map(Entity::getPosition)
                .forEach(point -> {
                    final int x = (int) point.getX() / FagUtils.TILE_SIZE;
                    final int y = (int) point.getY() / FagUtils.TILE_SIZE;

                    grid.setNodeState(x, y, NodeState.NOT_WALKABLE);
                });

        player = PlayerFactory.createPlayer();
        this.getGameState().setValue("playerLife", 1.0);
        this.getGameState().setValue("round", 0);
        this.getGameState().setValue("score", 0);
        this.getGameState().setValue("profileName", getMenuListener().profileNameProperty().getValue());
    }

    /**
     * {@inheritDoc}Math.abs
     */
    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(FagType.PLAYER, FagType.SIMPLE_ZOMBIE) {
            @Override
            protected void onCollisionBegin(final Entity player, final Entity zombie) {
                try {
                    pzCollision.onCollision((Player) player, (Zombie) zombie);
                } catch (GameOverException e) {
                    onEndGame();
                }
            }
        });

        getPhysicsWorld().addCollisionHandler(new CollisionHandler(FagType.PLAYER, FagType.ADVANCE_ZOMBIE) {
            @Override
            protected void onCollisionBegin(final Entity player, final Entity zombie) {
                try {
                    pzCollision.onCollision((Player) player, (Zombie) zombie);
                } catch (GameOverException e) {
                    onEndGame();
                }
            }
        });

        getPhysicsWorld().addCollisionHandler(new CollisionHandler(FagType.BULLET, FagType.SIMPLE_ZOMBIE) {
            @Override
            protected void onCollisionBegin(final Entity bullet, final Entity zombie) {
                bzCollision.onCollision((Bullet) bullet, (Zombie) zombie);
            }
        });

        getPhysicsWorld().addCollisionHandler(new CollisionHandler(FagType.BULLET, FagType.ADVANCE_ZOMBIE) {
            @Override
            protected void onCollisionBegin(final Entity bullet, final Entity zombie) {
                bzCollision.onCollision((Bullet) bullet, (Zombie) zombie);
            }
        });

        getPhysicsWorld().addCollisionHandler(new CollisionHandler(FagType.BULLET, FagType.BORDER) {
            @Override
            protected void onCollisionBegin(final Entity bullet, final Entity border) {
                bullet.removeFromWorld();
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initUI() {
        /*
         * Adding HUD.
         */
        final HUDController hudController = new HUDController();
        final UI hud = getAssetLoader().loadUI("fxml/hud.fxml", hudController);
        getGameScene().addUI(hud);

        /*
         * Adding life bar.
         * No need to use FXMLLoader. FXGL's AssetLoader does the job.
         * Remember to not use 'fx:controller' attribute in your fxml file.
         * NOT WORKING
               hudController.getPlayerLife().progressProperty().bind(this.absLifeController.getLifeProperty());
         */
        hudController.getProgressProperty().bind(
                this.getGameState().doubleProperty("playerLife"));
        hudController.getRoundProperty().bind(
                this.getGameState().intProperty("round").asString());
        hudController.getPointsProperty().bind(
                this.getGameState().intProperty("score").asString());

        /*
         * Adding tutorial.
         */

/*        Node tutorial = null;
        try {
            tutorial = FXMLLoader.load(getClass().getResource("/assets/ui/fxml/tutorial.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        tutorial.setTranslateX(150);
        tutorial.setTranslateY(150);
        getGameScene().addUINode(tutorial);*/

        FXGLTextFlow flow = FXGL.getUIFactory().newTextFlow()
                .append("Press ", FagUtils.TUTORIAL_TEXT_COLOR, FagUtils.TUTORIAL_TEXT_SIZE)
                .append(KeyCode.W, FagUtils.TUTORIAL_KEYCODE_COLOR, FagUtils.TUTORIAL_KEYCODE_SIZE)
                .append(KeyCode.A, FagUtils.TUTORIAL_KEYCODE_COLOR, FagUtils.TUTORIAL_TEXT_SIZE)
                .append(KeyCode.S, FagUtils.TUTORIAL_KEYCODE_COLOR, FagUtils.TUTORIAL_TEXT_SIZE)
                .append(KeyCode.D, FagUtils.TUTORIAL_KEYCODE_COLOR, FagUtils.TUTORIAL_TEXT_SIZE)
                .append(" to move\n", FagUtils.TUTORIAL_TEXT_COLOR, FagUtils.TUTORIAL_TEXT_SIZE)
                .append("Press ", FagUtils.TUTORIAL_TEXT_COLOR, FagUtils.TUTORIAL_TEXT_SIZE)
                .append(KeyCode.LEFT, FagUtils.TUTORIAL_KEYCODE_COLOR, FagUtils.TUTORIAL_KEYCODE_SIZE)
                .append(KeyCode.UP, FagUtils.TUTORIAL_KEYCODE_COLOR, FagUtils.TUTORIAL_KEYCODE_SIZE)
                .append(KeyCode.RIGHT, FagUtils.TUTORIAL_KEYCODE_COLOR, FagUtils.TUTORIAL_KEYCODE_SIZE)
                .append(KeyCode.DOWN, FagUtils.TUTORIAL_KEYCODE_COLOR, FagUtils.TUTORIAL_KEYCODE_SIZE)
                .append(" to shoot\n", FagUtils.TUTORIAL_TEXT_COLOR, FagUtils.TUTORIAL_TEXT_SIZE)
                .append("Press ", FagUtils.TUTORIAL_TEXT_COLOR, FagUtils.TUTORIAL_TEXT_SIZE)
                .append("ESC", FagUtils.TUTORIAL_KEYCODE_COLOR, FagUtils.TUTORIAL_KEYCODE_SIZE)
                .append(" to pause game", FagUtils.TUTORIAL_TEXT_COLOR, FagUtils.TUTORIAL_TEXT_SIZE);

        flow.setTranslateX(getWidth() - flow.getBoundsInLocal().getWidth() - 20);
        flow.setTranslateY(20);

        /*
            TODO: do not use a Rectangle Object
            TODO: DISAPPEAR AFTER X time
            TODO: increment round
         */
        Rectangle bgTutorial = new Rectangle();
        bgTutorial.setFill(new Color(0.41, 0.41, 0.41, 0.3));
        bgTutorial.setWidth(flow.getBoundsInLocal().getWidth() + 30);
        bgTutorial.setHeight(flow.getBoundsInLocal().getHeight() + 20);
        bgTutorial.setTranslateX(getWidth() - bgTutorial.getBoundsInLocal().getWidth() - 10);
        bgTutorial.setTranslateY(10);

        getGameScene().addUINode(flow);
        getGameScene().addUINode(bgTutorial);

        getMasterTimer().runOnceAfter(() -> {
            getGameScene().removeUINode(flow);
            getGameScene().removeUINode(bgTutorial);
        }, Duration.seconds(15));
    }

    /**
     * Called when game is over.
     * <ul>
     *     <li>Stop zombie spawn</li>
     *     <li>Remove zombies from map</li>
     *     <li>Open score view</li>
     *     <li>Open end game menu</li>
     * </ul>
     */
    private void onEndGame() {
        spawnController.stopSpawn();
        FXGL.getApp().getGameWorld().getEntitiesByType(FagType.SIMPLE_ZOMBIE).forEach(Entity::removeFromWorld);
        FXGL.getApp().getGameWorld().getEntitiesByType(FagType.ADVANCE_ZOMBIE).forEach(Entity::removeFromWorld);
        FAGMenuFactory.newEndGameMenu(FXGL.getApp());
    }
}
