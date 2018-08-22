package it.unibo.goffo.fag.score.model;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.score.Score;
import it.unibo.goffo.fag.score.builder.JsonScoreBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.almasb.fxgl.app.DSLKt.geti;

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
    public List<Score<String, Integer>> updatedScoreList() {
        final Integer userScore = geti(PROPERTY_NAME);
        final String username = FXGL.getSystemConfig().getProfileName();
        final Optional<Score<String, Integer>> optionalScore = scoreList.stream()
                .filter(score -> score.getUsername().equals(username))
                .findFirst();

        //Using >Java9 all this line can be replaced with method ifPresentOrElse() directly into the stream
        if (optionalScore.isPresent()) {
            if (optionalScore.get().getScore() < userScore) {
                optionalScore.get().setScore(userScore);
                optionalScore.get().setDate(LocalDate.now());
            }
        } else {
            final Score<String, Integer> score = new JsonScoreBuilder()
                    .setUsername(username)
                    .setScore(userScore)
                    .setDate(LocalDate.now())
                    .build();
            scoreList.add(score);
        }
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
