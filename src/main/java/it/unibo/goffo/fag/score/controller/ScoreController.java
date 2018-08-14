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
     * Note: when using this method is a good thing wrap the list to a {@code unmodifiableList}.
     * @param usernameClass username class.
     * @param scoreClass score class.
     * @param <U> username class' type.
     * @param <S> score class' type.
     * @return return a list with the saved scores.
     */
    <U, S> List<? extends Score<U, S>> loadScoreFromFile(Class<U> usernameClass, Class<S> scoreClass);

}
