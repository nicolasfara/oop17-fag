package it.unibo.goffo.fag.score.model;

import it.unibo.goffo.fag.score.Score;

import java.util.List;

/**
 * Business logic for the scoring.
 */
public interface ScoreModel {
    /**
     * Return a list with all update score.
     * @return update list score.
     */
    List<Score<String, Integer>> updatedScoreList();

    /**
     * Initialize the score with the given list.
     * @param firsScore the list contains all read scores.
     */
    void initializeScore(List<Score<String, Integer>> firsScore);
}
