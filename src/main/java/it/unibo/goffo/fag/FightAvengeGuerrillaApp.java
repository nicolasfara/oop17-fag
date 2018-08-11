package it.unibo.goffo.fag;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.extra.ai.pathfinding.AStarGrid;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.settings.GameSettings;
import it.unibo.goffo.fag.animation.FagControl;
import it.unibo.goffo.fag.entities.FagType;
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
                player.getComponent(FagControl.class).moveRight();
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.getComponent(FagControl.class).moveLeft();
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                player.getComponent(FagControl.class).moveUp();
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                player.getComponent(FagControl.class).moveDown();
            }
        }, KeyCode.S);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initGame() {

        getGameWorld().addEntityFactory(new LevelFactory());
        getGameWorld().setLevelFromMap("level0.json");

        player = getPlayer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(FagType.PLAYER, FagType.WALL){
            @Override
            protected void onCollisionBegin(Entity collector, Entity collectible) {
                //player.getComponent(FagControl.class).stop();
                getDisplay().showMessageBox("collision");
                System.out.println("collision");
            }
        });
    }
}
