package it.unibo.goffo.fag;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.settings.GameSettings;

/**
 * Main class, used to launch FXGL.
 */
public class FightAvengeGuerrillaApp extends GameApplication {

    private static final int WIDTH_SCREEN = 50;
    private static final int HEIGHT_SCREEN = 30;
    private static final int TILE_SIZE = 64;
    private static final String APPLICATION_NAME = "Final Avenge Guerrilla";

    /**
     * Main method launch the game engine.
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        launch(args);
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
        super.initInput();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initGame() {
        getGameWorld().setLevelFromMap("level0.json");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initPhysics() {
        super.initPhysics();
    }
}
