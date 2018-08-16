package it.unibo.goffo.fag.score.view;

import it.unibo.goffo.fag.score.controller.ScoreController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Concrete class for the view.
 */
public class ScoreViewImpl implements ScoreView {

    private ScoreController scoreController;

    /**
     * Accept a controller to get information on the score status.
     * @param scoreController score controller.
     */
    public ScoreViewImpl(final ScoreController scoreController) {
        this.scoreController = scoreController;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObservableList<JsonScoreWrapper> convertList() {
        ObservableList<JsonScoreWrapper> scoreWrappers = FXCollections.observableArrayList();
        scoreController.loadScoreFromFile().forEach(score -> {
            JsonScoreWrapper tmp = new JsonScoreWrapper(score.getUsername(), score.getScore());
            tmp.setDate(score.getDate());
            scoreWrappers.add(tmp);
        });
        return scoreWrappers;
    }
}
