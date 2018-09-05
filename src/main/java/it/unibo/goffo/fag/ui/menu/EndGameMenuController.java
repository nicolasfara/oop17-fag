package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.SubState;
import com.almasb.fxgl.ui.UIController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.checkerframework.checker.units.qual.A;

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
    private void onExit() {
        FXGL.getApp().getMenuListener().onExit();
    }
}
