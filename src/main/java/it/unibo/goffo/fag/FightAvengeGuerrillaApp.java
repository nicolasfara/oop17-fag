package it.unibo.goffo.fag;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.text.Text;

/**
 * Main class, used to launch FXGL.
 */
public class FightAvengeGuerrillaApp extends GameApplication {

    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;

    /*
        HUD-specific settings.
        The view is fixed in the visible viewport and its coordinate system is always within 0,0 to width,height.
        https://github.com/AlmasB/FXGL/wiki/Game-Scene#scene-graph---ui-view
     */
    private static final int HUD_START_X = 0;
    private static final int HUD_START_Y = 0;
    private static final int HUD_OFFSET_X = 50;
    private static final int HUD_OFFSET_Y = 100;
    private static final int HUD_LIFE_POS_X = HUD_START_X + HUD_OFFSET_X;
    private static final int HUD_LIFE_POS_Y = HUD_START_Y + HUD_OFFSET_Y;
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

    @Override
    protected void initUI() {
        Text textPixels = new Text();
        textPixels.setText("TEXT");
        textPixels.setTranslateX(HUD_LIFE_POS_X); // x = 50
        textPixels.setTranslateY(HUD_LIFE_POS_Y); // y = 100

        getGameScene().addUINode(textPixels); // add to the scene graph
    }

}
