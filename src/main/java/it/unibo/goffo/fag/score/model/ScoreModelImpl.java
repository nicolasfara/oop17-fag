package it.unibo.goffo.fag.score.model;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.score.Score;
import it.unibo.goffo.fag.score.builder.ScoreBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the business logic for scoring.
 */
public class ScoreModelImpl implements ScoreModel {

    private final List<Score<String, Integer>> scoreList = new ArrayList<>();
    private Integer userScore;

    /**
     * Constructor accept a string that match the property name for the score.
     * @param propertyName property's name;
     */
    public ScoreModelImpl(final String propertyName) {
        userScore = FXGL.getApp().getGameState().getInt(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getAllScore(final List<Score<String, Integer>> scoreList) {
        this.scoreList.clear();
        this.scoreList.addAll(scoreList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Score<String, Integer>> sendUpdatedScoreList() {
        String username = FXGL.getSystemConfig().getProfileName();
        Optional<Score<String, Integer>> optionalScore = scoreList.stream()
                .filter(score -> score.getUsername().equals(username))
                .findFirst();

        //Using >Java9 all this line can be replaced with method ifPresentOrElse() directly into the stream
        if (optionalScore.isPresent()) {
            optionalScore.get().setScore(userScore);
            optionalScore.get().setDate(LocalDate.now());
        } else {
            final Score<String, Integer> score = new ScoreBuilder()
                    .setUsername(username)
                    .setScore(userScore)
                    .setDate(LocalDate.now())
                    .build();
            scoreList.add(score);
        }
        return scoreList;
    }
}
