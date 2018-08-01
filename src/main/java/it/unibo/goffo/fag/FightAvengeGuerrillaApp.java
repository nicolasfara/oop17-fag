package it.unibo.goffo.fag;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.extra.ai.pathfinding.AStarGrid;
import com.almasb.fxgl.settings.GameSettings;

import static it.unibo.goffo.fag.FagUtils.APPLICATION_NAME;
import static it.unibo.goffo.fag.FagUtils.HEIGHT_SCREEN;
import static it.unibo.goffo.fag.FagUtils.WIDTH_SCREEN;

/**
 * Main class, used to launch FXGL.
 */
public class FightAvengeGuerrillaApp extends GameApplication {


    private AStarGrid grid;

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
        super.initInput();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initGame() {
        super.initGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initPhysics() {
        super.initPhysics();
    }
}
