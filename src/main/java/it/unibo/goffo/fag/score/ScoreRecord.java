package it.unibo.goffo.fag.score;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Class used for a record in the {@code Score} class.
 * @param <N> username of the player.
 * @param <S> score of the player.
 */
public class ScoreRecord<N, S> {

    private N name;
    private S score;

    /**
     * Require two generic objects, the first the username, the second the score.
     * @param name username's player.
     * @param score score's player.
     */
    public ScoreRecord(final N name, final S score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Get the username's player.
     * @return username's player.
     */
    public N getName() {
        return name;
    }

    /**
     * Get the score's player.
     * @return the score'e player.
     */
    public S getScore() {
        return score;
    }

    /**
     * Set the new score for the user.
     * @param score the new score.
     */
    public void setScore(final S score) {
        this.score = score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScoreRecord<?, ?> that = (ScoreRecord<?, ?>) o;
        return Objects.equal(name, that.name)
                && Objects.equal(score, that.score);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(name, score);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("score", score)
                .toString();
    }
}
