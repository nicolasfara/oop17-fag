package it.unibo.goffo.fag;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.settings.GameSettings;
import com.almasb.fxgl.ui.UI;
import it.unibo.goffo.fag.ui.menu.MainMenuController;

/**
 * Main class, used to launch FXGL.
 */
public class FightAvengeGuerrillaApp extends GameApplication {

    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;
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
        // 1. create a controller class that implements UIController
        MainMenuController controller = new MainMenuController();

        // 2. place fxml file in "assets/ui" and load it
        UI fxmlUI = getAssetLoader().loadUI("mainMenu.fxml", controller);

        // 3. controller instance now has its @FXML fields injected
        /* controller.getLabelCount().textProperty().bind(count.asString("Count: [%d]")); */

        // 4. add UI to game scene
        getGameScene().addUI(fxmlUI);
    }

}
