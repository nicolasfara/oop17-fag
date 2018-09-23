package it.unibo.goffo.fag.exceptions;

/**
 * Thrown when game is over (likely when Player character dies).
 */
public class GameOverException extends Exception {
    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return "Game Over.";
    }
}
