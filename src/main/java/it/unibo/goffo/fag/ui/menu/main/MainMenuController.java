package it.unibo.goffo.fag.ui.menu.main;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.ui.menu.FAGMenuFactory;
import javafx.fxml.FXML;

public class MainMenuController {

    @FXML
    private void startGame() {
        FXGL.getApp().getMenuListener().onNewGame();
/*        FXGL.getApp().getMenuListener().getSaveLoadManager().loadLastModifiedSaveFileTask().onSuccess(() ->
                )*/
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
