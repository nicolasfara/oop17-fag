package it.unibo.goffo.fag.score.model.datatype;

import it.unibo.goffo.fag.exceptions.UserNotFoundExceptions;

import java.util.stream.Stream;

/**
 * Interface modelling a score.
 */
public interface Score {
    /**
     * Add new record to the scores.
     * @param newScore the new record score.
     */
    void addNewScore(ScoreRecord<String, Integer> newScore);

    /**
     * Increment a score by the given points.
     * @param username the username to increment the points.
     * @param points the point that must be added to te previous points.
     * @throws UserNotFoundExceptions exception thrown if the usern could not be found.
     */
    void incrementScore(String username, int points) throws UserNotFoundExceptions;

    /**
     * Return all the record on stream format.
     * @return the result' stream.
     */
    Stream<ScoreRecord<String, Integer>> getAllScore();
}
