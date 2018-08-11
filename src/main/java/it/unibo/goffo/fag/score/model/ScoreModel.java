package it.unibo.goffo.fag.score.model;

import it.unibo.goffo.fag.score.Score;

import java.util.List;

/**
 * Business logic for the scoring.
 */
public interface ScoreModel {
    /**
     * Get a score list.
     * @param scoreList the score list.
     */
    void getAllScore(List<Score<String, Integer>> scoreList);

    /**
     * Return a list with all update score.
     * @return update list score.
     */
    List<Score<String, Integer>> sendUpdatedScoreList();
}
