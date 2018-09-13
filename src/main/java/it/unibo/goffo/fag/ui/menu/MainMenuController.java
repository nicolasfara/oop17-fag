package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.ui.UI;
import com.almasb.fxgl.ui.UIController;
import it.unibo.goffo.fag.score.view.ScoresViewController;
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

    private FAGMenu mainMenu;

    @FXML
    private void startGame() {
/*        mainMenu = newImpl FAGMenu(FXGL.getApp(), MenuType.MAIN_MENU);
        this.mainMenu.newGame();*/
        FXGL.getApp().getMenuListener().onNewGame();
    }

    @FXML
    private void showScores(final ActionEvent event) throws IOException {
/*        final UI scoresUI = FXGL.getAssetLoader().loadUI("fxml/ScoresView.fxml", new ScoresViewController());
        FXGL.getApp().getGameScene().getContentRoot().getChildren().add(scoresUI.getRoot());*/

//        final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
////        final Parent scene = FXMLLoader.load(getClass().getResource("/assets/ui/fxml/ScoresView.fxml"));
//        final ScoresViewController sc = new ScoresViewController();
//        final UI uis = FXGL.getAssetLoader().loadUI("fxml/ScoresView.fxml", sc);
//        FXGL.getApp().getGameScene().getRoot().getChildren().remove(this);
//        FXGL.getApp().getGameScene().addUI(uisA);

//        FXGL.getApp().getGameScene().addUI(FXGL.getAssetLoader().loadUI("fxml/ScoresView.fxml", new ScoresViewController()));
//        FXGL.getApp().getGameScene().addUINode(FXMLLoader.load(getClass().getResource("/assets/ui/fxml/ScoresView.fxml")));

//        new FAGMenuFactory().newScoresMenu(FXGL.getApp());


//        final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        final Parent scene = FXMLLoader.load(getClass().getResource("/assets/ui/fxml/ScoresView.fxml"));
//        stage.setScene(new Scene(scene, 800, 600));

        final Parent scene = FXMLLoader.load(getClass().getResource("/assets/ui/fxml/ScoresView.fxml"));
        final Stage newStage = new Stage();
        newStage.setScene(new Scene(scene, 800, 600));
        newStage.show();

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
