package it.unibo.goffo.fag.ui.menu.main;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.ui.menu.AbsMenuController;
import it.unibo.goffo.fag.ui.menu.FAGMenuFactory;
import javafx.fxml.FXML;

/**
 * Main Menu Controller.
 * Manages actions taken by user by clicking on menu entries: start game, scores, exit.
 */
public class MainMenuController extends AbsMenuController {
    @FXML
    private void startGame() {
            FXGL.getApp().getMenuListener().onNewGame();
    }

    @FXML
    private void showScores() {
        ((FAGMenuFactory) FXGL.getApp().getSettings().getSceneFactory()).newScoresMenu(FXGL.getApp());
    }

    @FXML
    private void onExit() {
        FXGL.getApp().getMenuListener().onExit();
    }
}
