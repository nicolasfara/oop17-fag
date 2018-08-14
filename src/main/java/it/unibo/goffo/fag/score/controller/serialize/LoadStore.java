package it.unibo.goffo.fag.score.controller.serialize;

import java.io.FileNotFoundException;

/**
 *
 * @param <T>
 */
public interface LoadStore<T> {
    /**
     *
     * @param fileName
     * @param payload
     * @param classType
     * @throws FileNotFoundException
     */
    void saveToFile(String fileName, T payload, Class<T> classType) throws FileNotFoundException;

    /**
     *
     * @param fileName
     * @param classType
     * @return
     * @throws FileNotFoundException
     */
    T loadFromFile(String fileName, Class<T> classType) throws FileNotFoundException;
}
