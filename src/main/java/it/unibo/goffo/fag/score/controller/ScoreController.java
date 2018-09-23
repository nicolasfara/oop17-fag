package it.unibo.goffo.fag.score.controller;

import it.unibo.goffo.fag.score.Score;

import java.util.List;

/**
 * Controller for the score.
 */
public interface ScoreController {
    /**
     * This method store the list (from model) to file.
     */
    void saveScoreToFile();

    /**
     * This method is used to restore the saving from file to a list.
     * Since the saving collection is generic, you must specify the class type of the username and for the score.
     * @return return a list with the saved scores.
     */
    List<Score<String, Integer>> loadScoreFromFile();
}
