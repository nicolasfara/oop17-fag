package it.unibo.goffo.fag;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.extra.ai.pathfinding.AStarGrid;
import com.almasb.fxgl.settings.GameSettings;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.movement.EntityMovement;
import it.unibo.goffo.fag.spawn.controller.SpawnControllerImpl;
import it.unibo.goffo.fag.spawn.view.SpawnView;
import it.unibo.goffo.fag.spawn.view.SpawnViewImpl;

import static it.unibo.goffo.fag.FagUtils.*;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;

import static it.unibo.goffo.fag.FagUtils.APPLICATION_NAME;
import static it.unibo.goffo.fag.FagUtils.HEIGHT_SCREEN;
import static it.unibo.goffo.fag.FagUtils.WIDTH_SCREEN;
import static it.unibo.goffo.fag.FagUtils.TILE_SIZE;

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
        settings.setWidth(WIDTH_SCREEN * TILE_SIZE);
        settings.setHeight(HEIGHT_SCREEN * TILE_SIZE);
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
            protected void onAction() {
                player.getComponent(EntityMovement.class).moveRight();
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.getComponent(EntityMovement.class).moveLeft();
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                player.getComponent(EntityMovement.class).moveUp();
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                player.getComponent(EntityMovement.class).moveDown();
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
        spawnView.subscribeHandler(FXGL.getApp().getGameWorld()::addEntity);

        getGameWorld().addEntityFactory(new LevelFactory());
        getGameWorld().setLevelFromMap("level0.json");

        /*player = Entities.builder()
                .type(FagType.PLAYER)
                .at(400,300)
                .with(new FagControl())
                .buildAndAttach(getGameWorld());*/
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initPhysics() {
        super.initPhysics();
    }
}
