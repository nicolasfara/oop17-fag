package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.ui.UIController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class MainMenuController implements UIController {

    @FXML
    private Button btnStartGame;

    @FXML
    private Button btnScores;

    @FXML Button btnExit;

    @FXML
    private void startGame() {
    }

    @FXML
    private void showScores() {

    }

    @FXML
    private void onExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Exit?");

        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> Platform.exit());

/*        FXGL.getApp().getDisplay().showConfirmationBox("Exit?", yes -> {
            if (yes) {
                Platform.exit();
            }
        });*/
    }

    @Override
    public void init() { }
}
