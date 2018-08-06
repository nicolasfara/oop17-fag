package it.unibo.goffo.fag.score;

import it.unibo.goffo.fag.exceptions.UserNotFoundExceptions;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertThat;

public class BasicScoreTest {

    private Score score;

    @Before
    public void initialize() throws NoSuchFieldException, IllegalAccessException {
        final Field instance = BasicScore.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);

        score = BasicScore.getInstance();
        score.addNewScore(new ScoreRecord<>("player1", 1));
        score.addNewScore(new ScoreRecord<>("player2", 1));
        score.addNewScore(new ScoreRecord<>("player3", 10));
    }

    @Test
    public void insertNewUserTest() {
        final Score score = BasicScore.getInstance();
        final List<ScoreRecord<String, Integer>> expectedList = Collections.singletonList(new ScoreRecord<>("player1", 1));
        assertThat(score.getAllScore().collect(Collectors.toList()))
                .containsAllIn(expectedList);
    }

    @Test
    public void insertMultipleUserTest() {
        final List<ScoreRecord<String, Integer>> expectedList = Arrays.asList(new ScoreRecord<>("player1", 1),
                new ScoreRecord<>("player2", 1),
                new ScoreRecord<>("player3", 10));

        assertThat(score.getAllScore().collect(Collectors.toList()))
                .containsAllIn(expectedList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertAlreadyPresentUserTest() {
        score.addNewScore(new ScoreRecord<>("player1", 200));
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertWrongScoreTest() {
        score.addNewScore(new ScoreRecord<>("player", -10));
    }

    @Test
    public void incrementScoreTest() {
        score.incrementScore("player1", 10);
        assertThat(score.getAllScore()
                .filter(record -> record.getName().equals("player1"))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getScore()).isEqualTo(11);
    }

    @Test(expected = UserNotFoundExceptions.class)
    public void incrementNonExistentUserScoreTest() {
        score.incrementScore("player6", 10);
    }
}
