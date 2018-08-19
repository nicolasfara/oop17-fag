package it.unibo.goffo.fag.score.view;

import com.google.common.base.Objects;
import it.unibo.goffo.fag.score.JsonScore;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Wrapper used for view the score into the view with JavaFX.
 */
public class JsonScoreWrapper extends JsonScore {

    private final StringProperty username;
    private final IntegerProperty score;

    /**
     * Constructor wrap the {@link #JsonScore JsonScore}. Refer to it for detail.
     * @param username the username of the player.
     * @param score the score to save.
     */
    public JsonScoreWrapper(final String username, final Integer score) {
        super(username, score);
        this.username = new SimpleStringProperty(username);
        this.score = new SimpleIntegerProperty(score);
    }

    /**
     * Default constructor.
     */
    public JsonScoreWrapper() {
        super();
        this.username = new SimpleStringProperty("");
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
        final JsonScoreWrapper that = (JsonScoreWrapper) o;
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
