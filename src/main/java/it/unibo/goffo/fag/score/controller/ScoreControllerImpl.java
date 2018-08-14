package it.unibo.goffo.fag.score.controller;

import com.almasb.fxgl.core.logging.Logger;
import com.google.common.collect.ImmutableList;
import it.unibo.goffo.fag.score.Score;
import it.unibo.goffo.fag.score.controller.format.Format;
import it.unibo.goffo.fag.score.controller.format.JsonFormatter;
import it.unibo.goffo.fag.score.controller.serialize.LoadStore;
import it.unibo.goffo.fag.score.controller.serialize.LoadStoreManager;
import it.unibo.goffo.fag.score.model.ScoreModel;
import it.unibo.goffo.fag.score.model.ScoreModelImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of controller for saving score.
 */
public class ScoreControllerImpl implements ScoreController {

    private final Format<String> formatManager = new JsonFormatter();
    private final LoadStore<String> loadStore = new LoadStoreManager<>();
    private static final Logger LOGGER = Logger.get(ScoreModelImpl.class);
    private final Path path = Paths.get(System.getProperty("user.home"), ".fag");
    private final Path filePath = Paths.get(path.toString(), "score");
    private final ScoreModel scoreModel;

    /**
     * Default constructor, check if exist the saving directory. If not exist the controller create it.
     * @param propertyName the property name for the score.
     */
    public ScoreControllerImpl(final String propertyName) {
        if (!Files.exists(path)) {
            LOGGER.warning("Unable to find directory: " + path);
            LOGGER.info("Create the directory");
            try {
                Files.createDirectory(path);
            } catch (IOException ex) {
                LOGGER.fatal("Unable to create directory", ex);
            }
        }
        scoreModel = new ScoreModelImpl(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveScoreToFile() {
        final String jsonString = formatManager.formatter(scoreModel.sendUpdatedScoreList());
        try {
            loadStore.saveToFile(filePath.toString(), jsonString, String.class);
        } catch (FileNotFoundException ex) {
            LOGGER.fatal("Unable to find the file", ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <U, S> List<? extends Score<U, S>> loadScoreFromFile(final Class<U> usernameClass, final Class<S> scoreClass) {
        try {
            final String loadJson = loadStore.loadFromFile(filePath.toString(), String.class);
            return ImmutableList.copyOf(formatManager.restore(loadJson, usernameClass, scoreClass));
        } catch (FileNotFoundException ex) {
            LOGGER.fatal("Unable to find the file", ex);
        }
        //If there is an error on try/catch return an empty list
        return Collections.emptyList();
    }
}
