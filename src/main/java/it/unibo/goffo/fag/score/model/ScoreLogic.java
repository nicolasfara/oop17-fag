package it.unibo.goffo.fag.score.model;

import it.unibo.goffo.fag.score.model.datatype.ScoreRecord;

import java.util.stream.Stream;

/**
 * Interface for business logic for scoring.
 */
public interface ScoreLogic {
    /**
     * Return all record stored.
     * @return a stream of {@code ScoreRecord}.
     */
    Stream<ScoreRecord<String, Integer>> getAllRecords();

    /**
     * Get all scores passed by controller.
     * NB: for performance purpose, this methoc can be called oly once.
     * @param scores stream of scores.
     */
    void getScoresFromController(Stream<ScoreRecord<String, Integer>> scores);

    /**
     * Return true if the BasicScore is empty, false otherwise.
     * @return false if there are at least a record, true otherwise.
     */
    boolean isEmpty();
}
