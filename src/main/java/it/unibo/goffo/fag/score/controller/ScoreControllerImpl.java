package it.unibo.goffo.fag.score.controller;

import com.almasb.fxgl.core.logging.Logger;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.goffo.fag.score.Score;
import it.unibo.goffo.fag.score.controller.format.Formatter;
import it.unibo.goffo.fag.score.controller.format.JsonFormatter;
import it.unibo.goffo.fag.score.controller.serialize.LoadStore;
import it.unibo.goffo.fag.score.controller.serialize.LoadStoreManager;
import it.unibo.goffo.fag.score.model.ScoreModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of controller for saving score.
 */
@SuppressFBWarnings(value = "PATH_TRAVERSAL_IN", justification = "Tha path cannot be controlled by the user")
public class ScoreControllerImpl implements ScoreController {

    private final Formatter<String, String, Integer> formatManager = new JsonFormatter();
    private final LoadStore<String> loadStore = new LoadStoreManager<>();
    private static final Logger LOGGER = Logger.get(ScoreControllerImpl.class);
    private final Path path = Paths.get(System.getProperty("user.home"), ".fag");
    private final Path filePath = Paths.get(path.toString(), "score");
    private final ScoreModel scoreModel;

    /**
     * Default constructor, check if exist the saving directory. If not exist the controller create it.
     * @param scoreModel the score model.
     */
    public ScoreControllerImpl(final ScoreModel scoreModel) {
        this.scoreModel = scoreModel;
        if (Files.notExists(path)) {
            LOGGER.warning("Unable to find directory: " + path);
            LOGGER.info("Create the directory");
            try {
                Files.createDirectory(path);
            } catch (IOException ex) {
                LOGGER.fatal("Unable to create directory", ex);
            }
        }

        if (Files.notExists(filePath)) {
            LOGGER.info("Creating score files");
            try {
                Files.createFile(filePath);
            } catch (IOException ex) {
                LOGGER.fatal("Unable to create the file", ex);
            }
        }
        scoreModel.initializeScore(loadScoreFromFile());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveScoreToFile() {
        final String jsonString = formatManager.formatter(scoreModel.updatedScoreList());
        try {
            loadStore.saveToFile(filePath.toString(), jsonString, String.class);
        } catch (IOException ex) {
            LOGGER.fatal("Unable to find the file", ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Score<String, Integer>> loadScoreFromFile() {
        try {
            if (fileIsEmpty(filePath.toString())) {
                return Collections.emptyList();
            }
            final String loadJson = loadStore.loadFromFile(filePath.toString(), String.class);
            return formatManager.restore(loadJson);

        } catch (IOException ex) {
            LOGGER.fatal("Unable to find the file", ex);
        }
        //If there is an error on try/catch return an empty list
        return Collections.emptyList();
    }

    private boolean fileIsEmpty(final String path) {
        return new File(path).length() <= 0;
    }
}
