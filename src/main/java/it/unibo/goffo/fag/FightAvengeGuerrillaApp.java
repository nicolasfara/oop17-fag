package it.unibo.goffo.fag;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.extra.ai.pathfinding.AStarGrid;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.parser.tiled.TiledMap;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.settings.GameSettings;
import com.almasb.fxgl.ui.UI;
import it.unibo.goffo.fag.animation.PlayerAnimationImpl;
import it.unibo.goffo.fag.collision.BulletZombieCollision;
import it.unibo.goffo.fag.collision.PlayerZombieCollision;
import it.unibo.goffo.fag.entities.Bullet;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.entities.Player;
import it.unibo.goffo.fag.entities.Zombie;
import it.unibo.goffo.fag.entities.builders.BulletFactory;
import it.unibo.goffo.fag.entities.builders.FagEntities;
import it.unibo.goffo.fag.exceptions.GameOverException;
import it.unibo.goffo.fag.life.controller.LifeController;
import it.unibo.goffo.fag.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.movement.EntityMovement;
import it.unibo.goffo.fag.movement.MoveDirection;
import it.unibo.goffo.fag.spawn.controller.SpawnControllerImpl;
import it.unibo.goffo.fag.spawn.view.SpawnView;
import it.unibo.goffo.fag.spawn.view.SpawnViewImpl;
import it.unibo.goffo.fag.ui.hud.HUDController;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

import static it.unibo.goffo.fag.FagUtils.*;

import static it.unibo.goffo.fag.FagUtils.PLAYER_SIZE_X;
import static it.unibo.goffo.fag.FagUtils.PLAYER_SIZE_Y;
/**
 * Main class, used to launch FXGL.
 */
public class FightAvengeGuerrillaApp extends GameApplication {

    private AStarGrid grid;
    private Player player;
    private LifeController lifeController;

    private PlayerZombieCollision pzCollision = new PlayerZombieCollision();
    private BulletZombieCollision bzCollision = new BulletZombieCollision();

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
        settings.setWidth(MAP_WIDTH * TILE_SIZE);
        settings.setHeight(MAP_HEIGHT * TILE_SIZE);
        settings.setTitle(APPLICATION_NAME);
        this.lifeController = new LifeControllerImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initInput() {
        Input input = getInput();

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
                player.playWalkAnimation(MoveDirection.LEFT);
            }

            @Override
            protected void onAction() {
                BulletFactory.createBullet(new Point2D(-1,0));
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.LEFT);
            }
        }, KeyCode.LEFT);

        input.addAction(new UserAction("Rotate Right") {

            @Override
            protected void onActionBegin() {
                player.playWalkAnimation(MoveDirection.RIGHT);
            }

            @Override
            protected void onAction() {
                BulletFactory.createBullet(new Point2D(1,0));
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.RIGHT);
            }
        }, KeyCode.RIGHT);

        input.addAction(new UserAction("Rotate Up") {
            @Override
            protected void onActionBegin() {
                player.playWalkAnimation(MoveDirection.UP);
            }

            @Override
            protected void onAction() {
                BulletFactory.createBullet(new Point2D(0,-1));
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.UP);
            }
        }, KeyCode.UP);

        input.addAction(new UserAction("Rotate Down") {
            @Override
            protected void onActionBegin() {
                player.playWalkAnimation(MoveDirection.DOWN);
            }

            @Override
            protected void onAction() {
                BulletFactory.createBullet(new Point2D(0,1));
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.DOWN);
            }
        }, KeyCode.DOWN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initGame() {
        grid = new AStarGrid(AI_WIDTH, AI_HEIGHT);
        SpawnView spawnView = new SpawnViewImpl(SpawnControllerImpl.getInstance());
        spawnView.subscribeHandler(e -> Platform.runLater(() -> FXGL.getApp().getGameWorld().addEntity(e)));

        getGameWorld().addEntityFactory(new LevelFactory());
        TiledMap map = getAssetLoader().loadJSON("800x600.json", TiledMap.class);
        getGameWorld().setLevelFromMap(map);

        player = (Player) FagEntities.builder(Player.class)
                .type(FagType.PLAYER)
                .at(200, 200)
                .with(new EntityMovement(1))
                .with(new LifeControllerImpl(1))
                .with(new PlayerAnimationImpl())
                .bbox(new HitBox(BoundingShape.box(PLAYER_SIZE_X, PLAYER_SIZE_Y)))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());
        player.setScaleX(0.5);
        player.setScaleY(0.5);
        /*lifeController.bindLife();*/
        this.getGameState().setValue("playerLife", 1.0);
    }

    /**
     * {@inheritDoc}Math.abs
     */
    @Override
    protected void initPhysics() {
        super.initPhysics();
        getPhysicsWorld().addCollisionHandler(
        new CollisionHandler(FagType.PLAYER, FagType.SIMPLE_ZOMBIE) {
                    @Override
                    protected void onCollisionBegin(final Entity player, final Entity zombie) {
                        try {
                            pzCollision.onCollision((Player) player, (Zombie) zombie);
                        } catch (GameOverException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(FagType.PLAYER, FagType.ADVANCE_ZOMBIE) {
                    @Override
                    protected void onCollisionBegin(final Entity player, final Entity zombie) {
                        try {
                            pzCollision.onCollision((Player) player, (Zombie) zombie);
                        } catch (GameOverException e2) {
                            e2.printStackTrace();
                        }
                    }
                });

        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(FagType.BULLET, FagType.SIMPLE_ZOMBIE) {
                    @Override
                    protected void onCollisionBegin(final Entity bullet, final Entity zombie) {
                        bzCollision.onCollision((Bullet) bullet, (Zombie) zombie);
                    }
                });

        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(FagType.BULLET, FagType.ADVANCE_ZOMBIE) {
                    @Override
                    protected void onCollisionBegin(final Entity bullet, final Entity zombie) {
                        bzCollision.onCollision((Bullet) bullet, (Zombie) zombie);
                    }
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initUI() {
        /*
         * No need to use FXMLLoader. FXGL's AssetLoader does the job.
         * Remember to not use 'fx:controller' attribute in your fxml file.
         */
        final HUDController hudController = new HUDController(getGameScene(), getGameState());
        final UI hud = getAssetLoader().loadUI("hud.fxml", hudController);

        /* NOT WORKING
        hudController.getPlayerLife().progressProperty().bind(this.absLifeController.getLifeProperty());
        */

        hudController.getPlayerLife().progressProperty().bind(
                this.getGameState().doubleProperty("playerLife"));
        getGameScene().addUI(hud);
    }
}
