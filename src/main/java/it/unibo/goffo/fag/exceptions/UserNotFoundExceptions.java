package it.unibo.goffo.fag.exceptions;

/**
 * Exception used in {@code BasicScore}.
 */
public class UserNotFoundExceptions extends RuntimeException {
    /**
     * Default constructor.
     */
    public UserNotFoundExceptions() {
        super();
    }

    /**
     * Constructor with message.
     * @param s the message for the user.
     */
    public UserNotFoundExceptions(final String s) {
        super(s);
    }
}
