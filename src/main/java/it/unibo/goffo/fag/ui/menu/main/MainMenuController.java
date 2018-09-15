package it.unibo.goffo.fag.ui.menu.main;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.ui.menu.AbsMenuController;
import it.unibo.goffo.fag.ui.menu.FAGMenuFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

import java.util.List;
import java.util.stream.Collectors;

public class MainMenuController {

/*    @FXML private Button btnStartGame;
    @FXML private Button btnScores;
    @FXML private Button btnExit;*/

    @FXML
    private TilePane buttons;

    private List<Button> btns;

    public void initialize() {
        this.btns = buttons.getChildren().stream()
                .filter(b -> b instanceof Button)
                .map(b -> (Button)b)
                .peek(this::bindDefaultButtonProperty)
                .collect(Collectors.toList());
    }

    private void bindDefaultButtonProperty(final Button btn) {
        btn.defaultButtonProperty().bind(btn.focusedProperty());
    }

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
