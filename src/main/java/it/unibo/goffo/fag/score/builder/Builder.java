package it.unibo.goffo.fag.score.builder;

/**
 * Interface for creating a builder.
 * @param <T> Object to build.
 */
public interface Builder<T> {
    /**
     * Method to build the object.
     * @return the built object.
     */
    T build();
}
