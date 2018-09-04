package it.unibo.goffo.fag;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.settings.GameSettings;
import com.almasb.fxgl.ui.UI;
import it.unibo.goffo.fag.life.controller.LifeController;
import it.unibo.goffo.fag.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.ui.hud.HUDController;

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

    private LifeController lifeController;

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
        this.lifeController = new LifeControllerImpl();
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
        /*lifeController.bindLife();*/
        this.getGameState().setValue("playerLife", 1.0);
    }

    /**
     * {@inheritDoc}Math.abs
     */
    @Override
    protected void initPhysics() {
        super.initPhysics();
    }

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
