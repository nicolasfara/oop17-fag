package it.unibo.goffo.fag.score.view;

import it.unibo.goffo.fag.score.Score;
import it.unibo.goffo.fag.score.ScoreComparator;
import it.unibo.goffo.fag.score.controller.ScoreController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Concrete class for the view.
 */
public class ScoreViewImpl implements ScoreView {

    private final ScoreController scoreController;

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
        final ObservableList<JsonScoreWrapper> scoreWrappers = FXCollections.observableArrayList();
        final List<Score<String, Integer>> tmpList = scoreController.loadScoreFromFile();
        tmpList.sort(new ScoreComparator());
        tmpList.forEach(score -> {
            final JsonScoreWrapper tmp = new JsonScoreWrapper(score.getUsername(), score.getScore());
            tmp.setDate(score.getDate());
            scoreWrappers.add(tmp);
        });
        return scoreWrappers;
    }
}
