package it.unibo.goffo.fag.ui.menu.endgame;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.ui.menu.AbsMenuController;
import it.unibo.goffo.fag.ui.menu.FAGMenuFactory;
import javafx.fxml.FXML;

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
        FAGMenuFactory.newScoresMenu(FXGL.getApp());
    }

    @FXML
    private void btnExit() {
        FXGL.getApp().getMenuListener().onExit();
    }
}
