package it.unibo.goffo.fag.score.model;

import it.unibo.goffo.fag.score.Score;
import it.unibo.goffo.fag.score.builder.JsonScoreBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.almasb.fxgl.app.DSLKt.geti;
import static com.almasb.fxgl.app.DSLKt.gets;

/**
 * Implementation of the business logic for score.
 */
public class ScoreModelImpl implements ScoreModel {

    private final List<Score<String, Integer>> scoreList = new ArrayList<>();
    private static final String PROPERTY_NAME = "score";

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Score<String, Integer>> insertNewScore() {
        final Integer userScore = geti(PROPERTY_NAME);
        final String username = gets("profileName");
        final Score<String, Integer> score = new JsonScoreBuilder()
                .setUsername(username)
                .setScore(userScore)
                .setDate(LocalDate.now())
                .build();
        scoreList.add(score);
        return scoreList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initializeScore(final List<Score<String, Integer>> firsScore) {
        scoreList.clear();
        scoreList.addAll(firsScore);
    }
}
