package it.unibo.goffo.fag.score.view;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.score.controller.ScoreController;
import it.unibo.goffo.fag.score.controller.ScoreControllerImpl;
import it.unibo.goffo.fag.score.model.ScoreModelImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * View Controller for view binding component.
 */
public class ScoresViewController {

    @FXML private Button backButton;
    @FXML private TableView<JsonScoreWrapper> scoreTableView;
    @FXML private TableColumn<JsonScoreWrapper, String> usernameColumn;
    @FXML private TableColumn<JsonScoreWrapper, Integer> scoreColumn;
    private ScoreView scoreView;

    public ScoresViewController() {
        ScoreController scoreController = new ScoreControllerImpl(new ScoreModelImpl());
        scoreView = new ScoreViewImpl(scoreController);
    }

    @FXML
    private void initialize() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        scoreTableView.setItems(scoreView.convertList());
        scoreTableView.getColumns().clear();
        scoreTableView.getColumns().add(scoreColumn);
        scoreTableView.getColumns().add(usernameColumn);

    }

    @FXML
    private void goBackHandler() {
        // Handler
    }

}
