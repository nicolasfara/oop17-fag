package it.unibo.goffo.fag.score.controller.serialize;

import java.io.FileNotFoundException;

public interface LoadStore<T> {
    void saveToFile(String fileName, T payload, Class<T> classType) throws FileNotFoundException;
    T loadFromFile(String fileName, Class<T> classType) throws FileNotFoundException;
}
