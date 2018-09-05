package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class MainMenuController {

    @FXML private Text menuTitle;
    @FXML private Button btnStartGame;
    @FXML private Button btnScores;
    @FXML private Button btnCredits;
    @FXML private Button btnExit;

    private FAGMenu mainMenu;

    @FXML
    private void startGame() {
/*        mainMenu = newImpl FAGMenu(FXGL.getApp(), MenuType.MAIN_MENU);
        this.mainMenu.newGame();*/
        FXGL.getApp().getMenuListener().onNewGame();
    }

    @FXML
    private void showScores(final ActionEvent event) throws IOException {
        final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        final Parent scene = FXMLLoader.load(getClass().getResource("/assets/ui/fxml/ScoresView.fxml"));
        stage.setScene(new Scene(scene, 800, 600));
    }

    @FXML
    private void showCredits() {
    }

    @FXML
    private void onExit() {
/*        MenuApplication menuApplication = newImpl MenuApplication();
        Alert alert = newImpl Alert(Alert.AlertType.CONFIRMATION, "Exit?");

        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> menuApplication.exitGame());*/

        FXGL.getApp().getMenuListener().onExit();
    }
}
