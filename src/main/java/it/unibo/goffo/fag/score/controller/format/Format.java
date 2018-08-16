package it.unibo.goffo.fag.score.controller.format;

import it.unibo.goffo.fag.score.Score;

import java.util.List;

/**
 * Interface for creating an object to handle object formatting for serialization.
 * @param <T> Formatted format.
 */
public interface Format<T, U, S> {
    /**
     * Method for formatting a collection into his format.
     * The format is defined on the implementation of this class.
     * @param collection the collection to be formatted.
     * @return the formatted collection.
     */
    T formatter(List<? extends Score<U, S>> collection);

    /**
     * Method for restore a formatted collection into his original type.
     * @param formatted the formatted object.
     * @return the restored collection.
     */
    List<? extends Score<U, S>> restore(T formatted);
}
