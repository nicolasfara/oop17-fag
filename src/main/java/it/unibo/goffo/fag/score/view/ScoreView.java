package it.unibo.goffo.fag.score.view;

import javafx.collections.ObservableList;

/**
 * Interface to handle the scores for the view.
 */
public interface ScoreView {
    /**
     * This method convert a list of Score to an ObservableList of JsonScoreWrapper, used into the gui.
     * @return the list converted into an ObservableList.
     */
    ObservableList<JsonScoreWrapper> convertList();
}
