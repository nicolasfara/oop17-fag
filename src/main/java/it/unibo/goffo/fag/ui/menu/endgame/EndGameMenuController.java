package it.unibo.goffo.fag.ui.menu.endgame;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.ui.menu.AbsMenuController;
import it.unibo.goffo.fag.ui.menu.FAGMenuFactory;
import javafx.fxml.FXML;

/**
 * End Game Menu Controller.
 * Manages actions taken by user by clicking on menu entries: restart, main menu, scores, exit.
 */
@SuppressWarnings("PMD.UnusedPrivateMethod") // Bound with FXML.
public class EndGameMenuController extends AbsMenuController {

    @FXML
    private void restartGame() {
        FXGL.getApp().getMenuListener().onNewGame();
    }

    @FXML
    private void backToMainMenu() {
        FXGL.getApp().getMenuListener().onExitToMainMenu();
    }

    @FXML
    private void showScores() {
        ((FAGMenuFactory) (FXGL.getApp().getSettings().getSceneFactory())).newScoresMenu(FXGL.getApp());
    }

    @FXML
    private void exit() {
        FXGL.getApp().getMenuListener().onExit();
    }
}
