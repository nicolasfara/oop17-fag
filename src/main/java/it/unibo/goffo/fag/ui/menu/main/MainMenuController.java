package it.unibo.goffo.fag.ui.menu.main;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.ui.menu.AbsMenuController;
import it.unibo.goffo.fag.ui.menu.FAGMenuFactory;
import javafx.fxml.FXML;

public class MainMenuController extends AbsMenuController {
    @FXML
    private void startGame() {
            FXGL.getApp().getMenuListener().onNewGame();
/*        FXGL.getApp().getMenuListener().getSaveLoadManager().loadLastModifiedSaveFileTask().onSuccess(() ->
                )*/
    }

    @FXML
    private void showScores() {
        FAGMenuFactory.newScoresMenu(FXGL.getApp());
    }

    @FXML
    private void showCredits() {
    }

    @FXML
    private void onExit() {
        FXGL.getApp().getMenuListener().onExit();
    }
}
