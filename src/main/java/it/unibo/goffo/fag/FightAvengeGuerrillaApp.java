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
import it.unibo.goffo.fag.exceptions.GameOverException;
import it.unibo.goffo.fag.spawn.controller.SpawnController;
import it.unibo.goffo.fag.spawn.controller.SpawnControllerImpl;
import it.unibo.goffo.fag.spawn.view.SpawnView;
import it.unibo.goffo.fag.spawn.view.SpawnViewImpl;
import it.unibo.goffo.fag.ui.hud.HUDController;
import it.unibo.goffo.fag.ui.menu.FAGMenuFactory;
import it.unibo.goffo.fag.ui.tutorial.TutorialController;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
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
         * No need to use FXMLLoader. FXGL's AssetLoader does the job.
         * Remember to not use 'fx:controller' attribute in your fxml file.
         */
        final HUDController hudController = new HUDController();
        final UI hud = getAssetLoader().loadUI("fxml/hud.fxml", hudController);
        getGameScene().addUI(hud);

        // Binding FXGL GameState properties with GUI properties
        hudController.getLifeProgressProperty().bind(
                this.getGameState().doubleProperty("playerLife"));
        hudController.getRoundProperty().bind(
                this.getGameState().intProperty("round").asString());
        hudController.getPointsProperty().bind(
                this.getGameState().intProperty("score").asString());

        hud.getRoot().setTranslateY(hud.getRoot().getBoundsInLocal().getWidth());

        // Adding tutorial
        final UI tutorial = getAssetLoader().loadUI("fxml/tutorial.fxml", new TutorialController());
        getGameScene().addUI(tutorial);
        tutorial.getRoot().setTranslateX(getWidth() - 220);
        tutorial.getRoot().setTranslateY(10);
        // Removing tutorial
        getMasterTimer().runOnceAfter(() -> getGameScene().removeUI(tutorial), Duration.seconds(FagUtils.TUTORIAL_DURATION));
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
        ((FAGMenuFactory) getSettings().getSceneFactory()).newEndGameMenu(FXGL.getApp());
    }
}
