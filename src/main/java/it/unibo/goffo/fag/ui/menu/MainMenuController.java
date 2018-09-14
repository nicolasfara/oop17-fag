package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import javafx.fxml.FXML;

public class MainMenuController {

    @FXML
    private void startGame() {
        FXGL.getApp().getMenuListener().onNewGame();
    }

    @FXML
    private void showScores() {
        // WORKING
        /*
        final Parent scene = FXMLLoader.load(getClass().getResource("/assets/ui/fxml/ScoresView.fxml"));
        final Stage newStage = new Stage();
        newStage.setScene(new Scene(scene));
        newStage.show();
        */

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
