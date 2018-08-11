package it.unibo.goffo.fag.score.controller.serialize;

import java.io.FileNotFoundException;

/**
 * Load and store json formatted object.
 */
public class JsonLoadStore extends LoadStoreManager<String> {
    /**
     * {@inheritDoc}
     */
    @Override
    public void saveToFile(final String fileName, final String payload, final Class<String> classType) throws FileNotFoundException {
        super.saveToFile(fileName, payload, classType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String loadFromFile(final String fileName, final Class<String> classType) throws FileNotFoundException {
        return super.loadFromFile(fileName, classType);
    }
}
