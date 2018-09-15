package it.unibo.goffo.fag.ui.menu.endgame;

import com.almasb.fxgl.app.FXGL;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EndGameMenuController {

    @FXML private Button btnRestart;
    @FXML private Button btnMainMenu;
    @FXML private Button btnExit;

    public void initialize() {
        bindDefaultButtonProperty(this.btnRestart);
        bindDefaultButtonProperty(this.btnMainMenu);
        bindDefaultButtonProperty(this.btnExit);
    }

    private void bindDefaultButtonProperty(final Button btn) {
        btn.defaultButtonProperty().bind(btn.focusedProperty());
    }

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
