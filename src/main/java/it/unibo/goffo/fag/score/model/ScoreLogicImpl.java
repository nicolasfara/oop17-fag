package it.unibo.goffo.fag.score.model;

import it.unibo.goffo.fag.score.model.datatype.BasicScore;
import it.unibo.goffo.fag.score.model.datatype.Score;
import it.unibo.goffo.fag.score.model.datatype.ScoreRecord;

import java.util.stream.Stream;

/**
 * Concrete class for business logic for scoring.
 */
public class ScoreLogicImpl implements ScoreLogic {

    private final Score score = BasicScore.getInstance();
    private boolean executeOnce = false;

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
    public void getScoresFromController(final Stream<ScoreRecord<String, Integer>> scores) {
        if (executeOnce) {
            throw new IllegalStateException("This method can be called only once");
        }
        scores.forEach(score::addNewScore);
    }
}
