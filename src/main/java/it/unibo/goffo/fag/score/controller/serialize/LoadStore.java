package it.unibo.goffo.fag.score.controller.serialize;

import java.io.IOException;

/**
 * Interface to load and store from file a generic object.
 * @param <T> The type of the object must be serialize.
 */
public interface LoadStore<T> {
    /**
     * Save the object to file.
     * @param fileName the path where the object must be saved.
     * @param payload the object to be serialized.
     * @param classType the type of the object to be serialized.
     * @throws IOException exception if there are errors on write the object.
     */
    void saveToFile(String fileName, T payload, Class<T> classType) throws IOException;

    /**
     * Load the object from file.
     * @param fileName the path where the object was serialized.
     * @param classType the class of the restored object.
     * @return the object restored.
     * @throws IOException exception if there are errors on read the object.
     */
    T loadFromFile(String fileName, Class<T> classType) throws IOException;
}
