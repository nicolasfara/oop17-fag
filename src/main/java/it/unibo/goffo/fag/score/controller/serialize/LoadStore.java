package it.unibo.goffo.fag.score.controller.serialize;

import java.io.FileNotFoundException;
import java.io.IOException;

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
    void saveToFile(String fileName, T payload, Class<T> classType) throws IOException;

    /**
     *
     * @param fileName
     * @param classType
     * @return
     * @throws IOException
     */
    T loadFromFile(String fileName, Class<T> classType) throws IOException;
}
