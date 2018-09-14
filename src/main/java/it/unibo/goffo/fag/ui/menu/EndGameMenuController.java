package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import javafx.fxml.FXML;

public class EndGameMenuController {

    @FXML
    private void restartGame() {
        FXGL.getApp().getMenuListener().onNewGame();
    }

    @FXML
    private void backToMainMenu() {
        FXGL.getApp().getMenuListener().onExitToMainMenu();
    }

    @FXML
    private void btnExit() {
        FXGL.getApp().getMenuListener().onExit();
    }
}
