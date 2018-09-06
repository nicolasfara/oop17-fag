package it.unibo.goffo.fag;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.input.ActionType;
import com.almasb.fxgl.input.InputMapping;
import com.almasb.fxgl.input.OnUserAction;
import com.almasb.fxgl.settings.GameSettings;
import com.almasb.fxgl.ui.UI;
import it.unibo.goffo.fag.life.controller.LifeController;
import it.unibo.goffo.fag.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.ui.hud.HUDController;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import com.almasb.fxgl.ui.FXGLTextFlow;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Main class, used to launch FXGL.
 */
public class FightAvengeGuerrillaApp extends GameApplication {

    private static final int WIDTH_SCREEN = 800;
    private static final int HEIGHT_SCREEN = 600;
    private static final String APPLICATION_NAME = "Final Avenge Guerrilla";

    private static final Color TUTORIAL_TEXT_COLOR = Color.BLACK;
    private static final Color TUTORIAL_KEYCODE_COLOR = Color.RED;
    private static final int TUTORIAL_TEXT_SIZE = 18;
    private static final int TUTORIAL_KEYCODE_SIZE = 16;

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
        getInput().addInputMapping(new InputMapping("Show Notification", KeyCode.F));
    }

    @OnUserAction(name = "Show Notification", type = ActionType.ON_ACTION_BEGIN)
    public void showNotification() {
        // 1. get notification service and push a message
        getNotificationService().pushNotification("Some Message! Tick: " + getTick());
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

        FXGLTextFlow flow = FXGL.getUIFactory().newTextFlow()
                .append("Press ", TUTORIAL_TEXT_COLOR, TUTORIAL_TEXT_SIZE)
                .append(KeyCode.W, TUTORIAL_KEYCODE_COLOR, TUTORIAL_KEYCODE_SIZE)
                .append(KeyCode.A, TUTORIAL_KEYCODE_COLOR, TUTORIAL_TEXT_SIZE)
                .append(KeyCode.S, TUTORIAL_KEYCODE_COLOR, TUTORIAL_TEXT_SIZE)
                .append(KeyCode.D, TUTORIAL_KEYCODE_COLOR, TUTORIAL_TEXT_SIZE)
                .append(" to move\n", TUTORIAL_TEXT_COLOR, TUTORIAL_TEXT_SIZE)
                .append("Press ", TUTORIAL_TEXT_COLOR, TUTORIAL_TEXT_SIZE)
                .append(KeyCode.LEFT, TUTORIAL_KEYCODE_COLOR, TUTORIAL_KEYCODE_SIZE)
                .append(KeyCode.UP, TUTORIAL_KEYCODE_COLOR, TUTORIAL_KEYCODE_SIZE)
                .append(KeyCode.RIGHT, TUTORIAL_KEYCODE_COLOR, TUTORIAL_KEYCODE_SIZE)
                .append(KeyCode.DOWN, TUTORIAL_KEYCODE_COLOR, TUTORIAL_KEYCODE_SIZE)
                .append(" to shoot\n", TUTORIAL_TEXT_COLOR, TUTORIAL_TEXT_SIZE)
                .append("Press ", TUTORIAL_TEXT_COLOR, TUTORIAL_TEXT_SIZE)
                .append("ESC", TUTORIAL_KEYCODE_COLOR, TUTORIAL_KEYCODE_SIZE)
                .append(" to pause game", TUTORIAL_TEXT_COLOR, TUTORIAL_TEXT_SIZE);

        flow.setTranslateX(getWidth() - flow.getBoundsInLocal().getWidth() - 20);
        flow.setTranslateY(20);

        /*
            TODO: do not use a Rectangle Object
            TODO: DISAPPEAR AFTER X time
         */
        Rectangle bgTutorial = new Rectangle();
        bgTutorial.setFill(new Color(0.41, 0.41, 0.41, 0.3));
        bgTutorial.setWidth(flow.getBoundsInLocal().getWidth() + 40);
        bgTutorial.setHeight(flow.getBoundsInLocal().getHeight() + 40);
        bgTutorial.setTranslateX(getWidth() - bgTutorial.getBoundsInLocal().getWidth());
        bgTutorial.setTranslateY(0);

        getGameScene().addUINode(flow);
        getGameScene().addUINode(bgTutorial);

    }
}
