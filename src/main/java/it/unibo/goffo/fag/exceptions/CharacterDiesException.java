package it.unibo.goffo.fag.exceptions;

/**
 * Thrown when a character dies.
 */
public class CharacterDiesException extends Exception {
    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return "Character died.";
    }
}
