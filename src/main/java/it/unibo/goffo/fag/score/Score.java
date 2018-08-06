package it.unibo.goffo.fag.score;

import it.unibo.goffo.fag.exceptions.UserNotFoundExceptions;

import java.util.stream.Stream;

/**
 * Interface modelling a score.
 */
public interface Score {

    void addNewScore(ScoreRecord<String, Integer> newScore);

    void incrementScore(String username, int points) throws UserNotFoundExceptions;

    Stream<ScoreRecord<String, Integer>> getAllScore();
}
