package it.unibo.goffo.fag.exceptions;

/**
 * Exception used in {@code BasicScore}.
 */
public class UserNotFoundExceptions extends RuntimeException {

    public UserNotFoundExceptions() {
        super();
    }

    public UserNotFoundExceptions(final String s) {
        super(s);
    }
}
