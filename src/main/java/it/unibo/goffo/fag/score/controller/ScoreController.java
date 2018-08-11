package it.unibo.goffo.fag.score.controller;

import it.unibo.goffo.fag.score.Score;

import java.util.List;

/**
 * Controller for the score.
 */
public interface ScoreController {
    /**
     * This method is used to save all score to file.
     * Other class or entities must not know the name of the file.
     * @param scoreList the score list to save.
     */
    void saveScoreToFile(List<? extends Score> scoreList);

    /**
     * This method is used to restore all saved score into the file.
     * Other class or entities must not know the name of the file.
     * @return a list with al scores.
     */
    List<? extends Score> loadScoreFromFile();

    /**
     * This method return the list contains all scores.
     * NB: this method must be called after {@link #loadScoreFromFile() loadScoreFromFile}, otherwise an exception will be thrown.
     * @return the scores list.
     */
    List<? extends Score> getScoreList();
}
