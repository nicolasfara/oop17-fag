package it.unibo.goffo.fag;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.extra.ai.pathfinding.AStarGrid;
import com.almasb.fxgl.parser.tiled.TiledMap;
import com.almasb.fxgl.settings.GameSettings;
import it.unibo.goffo.fag.animation.PlayerAnimationImpl;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.movement.EntityMovement;
import it.unibo.goffo.fag.movement.MoveDirection;
import it.unibo.goffo.fag.spawn.controller.SpawnControllerImpl;
import it.unibo.goffo.fag.spawn.view.SpawnView;
import it.unibo.goffo.fag.spawn.view.SpawnViewImpl;

import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;

import static it.unibo.goffo.fag.FagUtils.*;

/**
 * Main class, used to launch FXGL.
 */
public class FightAvengeGuerrillaApp extends GameApplication {


    private AStarGrid grid;
    private Entity player;


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
        settings.setWidth(WIDTH_SCREEN);
        settings.setHeight(HEIGHT_SCREEN);
        settings.setTitle(APPLICATION_NAME);
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
                player.getComponent(PlayerAnimationImpl.class).playWalkAnimation(MoveDirection.RIGHT);
            }

            @Override
            protected void onAction() {
                player.getComponent(EntityMovement.class).moveRight();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(PlayerAnimationImpl.class).playIdleAnimation(MoveDirection.RIGHT);
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onActionBegin() {
                player.getComponent(PlayerAnimationImpl.class).playWalkAnimation(MoveDirection.LEFT);
            }

            @Override
            protected void onAction() {
                player.getComponent(EntityMovement.class).moveLeft();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(PlayerAnimationImpl.class).playIdleAnimation(MoveDirection.LEFT);
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onActionBegin() {
                player.getComponent(PlayerAnimationImpl.class).playWalkAnimation(MoveDirection.UP);
            }

            @Override
            protected void onAction() {
                player.getComponent(EntityMovement.class).moveUp();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(PlayerAnimationImpl.class).playIdleAnimation(MoveDirection.UP);
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onActionBegin() {
                player.getComponent(PlayerAnimationImpl.class).playWalkAnimation(MoveDirection.DOWN);
            }

            @Override
            protected void onAction() {
                player.getComponent(EntityMovement.class).moveDown();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(PlayerAnimationImpl.class).playIdleAnimation(MoveDirection.DOWN);
            }
        }, KeyCode.S);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initGame() {
        grid = new AStarGrid(MAP_SIZE, MAP_SIZE);
        SpawnView spawnView = new SpawnViewImpl(SpawnControllerImpl.getInstance());
        spawnView.subscribeHandler(e -> Platform.runLater(() -> FXGL.getApp().getGameWorld().addEntity(e)));

        getGameWorld().addEntityFactory(new LevelFactory());
        TiledMap map = getAssetLoader().loadJSON("level0.json", TiledMap.class);
        getGameWorld().setLevelFromMap(map);

        player = Entities.builder()
                .type(FagType.PLAYER)
                .at(200,100)
                .with(new EntityMovement(1))
                .with(new PlayerAnimationImpl())
                .buildAndAttach(getGameWorld());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initPhysics() {
        super.initPhysics();
    }
}
