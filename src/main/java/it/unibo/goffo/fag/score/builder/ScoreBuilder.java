package it.unibo.goffo.fag.score.builder;

import it.unibo.goffo.fag.score.JsonScore;
import it.unibo.goffo.fag.score.Score;

import java.time.LocalDate;

/**
 * Builder that build a score object.
 */
public class ScoreBuilder implements Builder<Score<String, Integer>> {

    private final Score<String, Integer> score;

    /**
     * Default constructor.
     */
    public ScoreBuilder() {
        score = new JsonScore();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Score<String, Integer> build() {
        return score;
    }

    /**
     * Set the username to the object.
     * @param username the username to set.
     * @return this class.
     */
    public ScoreBuilder setUsername(final String username) {
        score.setUsername(username);
        return this;
    }

    /**
     * Set the score to the object.
     * @param score the score.
     * @return this class.
     */
    public ScoreBuilder setScore(final Integer score) {
        this.score.setScore(score);
        return this;
    }

    /**
     * Set the date to the object.
     * @param date the date.
     * @return this class.
     */
    public ScoreBuilder setDate(final LocalDate date) {
        score.setDate(date);
        return this;
    }
}
