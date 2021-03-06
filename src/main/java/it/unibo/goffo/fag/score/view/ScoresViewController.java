package it.unibo.goffo.fag.score.view;

import it.unibo.goffo.fag.score.controller.ScoreController;
import it.unibo.goffo.fag.score.controller.ScoreControllerImpl;
import it.unibo.goffo.fag.score.model.ScoreModelImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * View Controller for view binding component.
 */
public class ScoresViewController {

    @FXML private TableView<JsonScoreWrapper> scoreTableView;
    @FXML private TableColumn<JsonScoreWrapper, String> usernameColumn;
    @FXML private TableColumn<JsonScoreWrapper, Integer> scoreColumn;
    private final ScoreView scoreView;

    /**
     * Initialize the Gui controller with model and controller from score.
     */
    public ScoresViewController() {
        final ScoreController scoreController = ScoreControllerImpl.getInstance(new ScoreModelImpl());
        scoreView = new ScoreViewImpl(scoreController);
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod") //This method is bind with FXML annotation to his handler
    @FXML
    private void initialize() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        scoreTableView.setItems(scoreView.convertList());
        scoreTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        scoreTableView.getColumns().clear();
        scoreTableView.getColumns().add(usernameColumn);
        scoreTableView.getColumns().add(scoreColumn);
        columnGraphicalSetup(usernameColumn);
        columnGraphicalSetup(scoreColumn);
        tableViewGraphicalSetup(scoreTableView);
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod") //This method is bind with FXML annotation to his handler
    @FXML
    private void goBackHandler(final ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    private void tableViewGraphicalSetup(final TableView<?> tableView) {
        tableView.setDisable(true);
    }

    private void columnGraphicalSetup(final TableColumn<?, ?> column) {
        column.setSortable(false);
    }
}
