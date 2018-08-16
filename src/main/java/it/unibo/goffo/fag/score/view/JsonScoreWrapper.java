package it.unibo.goffo.fag.score.view;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import it.unibo.goffo.fag.score.JsonScore;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Wrapper used for view the score into the view with JavaFX.
 */
public class JsonScoreWrapper extends JsonScore {

    private StringProperty username;
    private IntegerProperty score;

    /**
     * Constructor wrap the {@link #JsonScore JsonScore}. Refer to it for detail.
     * @param username the username of the player.
     * @param score the score to save.
     */
    public JsonScoreWrapper(final String username, final Integer score) {
        this.username = new SimpleStringProperty(username);
        this.score = new SimpleIntegerProperty(score);
    }

    /**
     * Default constructor.
     */
    public JsonScoreWrapper() {
        this.username = new SimpleStringProperty(Strings.nullToEmpty(null));
        this.score = new SimpleIntegerProperty(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return username.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUsername(final String username) {
        this.username.setValue(username);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getScore() {
        return score.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setScore(final Integer score) {
        this.score.setValue(score);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate getDate() {
        return super.getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDate(final LocalDate date) {
        super.setDate(date);
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
        if (!super.equals(o)) {
            return false;
        }
        JsonScoreWrapper that = (JsonScoreWrapper) o;
        return Objects.equal(username, that.username)
                && Objects.equal(score, that.score);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), username, score);
    }
}
