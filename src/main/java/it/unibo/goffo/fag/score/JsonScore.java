package it.unibo.goffo.fag.score;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Strings;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Implementation of the Score.
 */
public class JsonScore implements Score<String, Integer>, Serializable {

    public static final long serialVersionUID = 49228374;
    private String username;
    private Integer score;
    private LocalDate date;

    /**
     * Accept two argument username and score.
     * @param username the username.
     * @param score the score.
     */
    public JsonScore(final String username, final Integer score) {
        this.username = username;
        this.score = score;
    }

    /**
     * Default constructor.
     */
    public JsonScore() {
        this.username = Strings.nullToEmpty(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getScore() {
        return score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setScore(final Integer score) {
        this.score = score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate getDate() {
        return date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDate(final LocalDate date) {
        this.date = date;
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
        final JsonScore score1 = (JsonScore) o;
        return Objects.equal(username, score1.username)
                && Objects.equal(score, score1.score)
                && Objects.equal(date, score1.date);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(username, score, date);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("username", username)
                .add("score", score)
                .add("date", date)
                .toString();
    }
}
