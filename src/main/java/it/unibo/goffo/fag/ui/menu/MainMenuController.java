package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.ui.UIController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class MainMenuController implements UIController {

    FAGMenu mainMenu;

    @FXML
    private Button btnStartGame;

    @FXML
    private Button btnScores;

    @FXML Button btnExit;

    @FXML
    private Text menuTitle;

    public void setMenuTitle(final String text) {
        this.menuTitle.setText(text);
    }

    public Text getMenuTitle() {
        return this.menuTitle;
    }

    @FXML
    private void startGame() {
/*        mainMenu = newImpl FAGMenu(FXGL.getApp(), MenuType.MAIN_MENU);
        this.mainMenu.newGame();*/
        FXGL.getApp().getMenuListener().onNewGame();
    }

    @FXML
    private void showScores() {
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

    @Override
    public void init() { }
}
