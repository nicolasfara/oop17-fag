package it.unibo.goffo.fag.score.model;

import it.unibo.goffo.fag.score.model.datatype.BasicScore;
import it.unibo.goffo.fag.score.model.datatype.Score;
import it.unibo.goffo.fag.score.model.datatype.ScoreRecord;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Concrete class for business logic for scoring.
 */
public class ScoreLogicImpl implements ScoreLogic {

    private final Score score = BasicScore.getInstance();
    private boolean executeOnce;

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<ScoreRecord<String, Integer>> getAllRecords() {
        return score.getAllScore();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return score.getAllScore().collect(Collectors.toList()).isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getScoresFromController(final Stream<ScoreRecord<String, Integer>> scores) {
        if (executeOnce) {
            throw new IllegalStateException("This method can be called only once");
        }
        executeOnce = true;
        scores.forEach(score::addNewScore);
    }
}
