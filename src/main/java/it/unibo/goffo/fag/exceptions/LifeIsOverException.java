package it.unibo.goffo.fag.exceptions;

/**
 * Thrown when life is over.
 * This is logically decoupled with CharacterDiesException, because it's based on game/player conditions.
 */
public class LifeIsOverException extends Exception {
    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return "Life value reached minimum value.";
    }
}
