package it.unibo.goffo.fag.score;

import java.time.LocalDate;

/**
 * Interface useful for create score in the game.
 * @param <U> username's type.
 * @param <S> score's type.
 */
public interface Score<U, S> {
    /**
     * Get the username by the score.
     * @return the username.
     */
    U getUsername();

    /**
     * Set the username for the score.
     * @param username the new username.
     */
    void setUsername(U username);

    /**
     * Return the score.
     * @return the score.
     */
    S getScore();

    /**
     * Set the score.
     * @param score the new score.
     */
    void setScore(S score);

    /**
     * Get the date of score.
     * @return the score's date.
     */
    LocalDate getDate();

    /**
     * Update the new date.
     * @param date new date.
     */
    void setDate(LocalDate date);
}
