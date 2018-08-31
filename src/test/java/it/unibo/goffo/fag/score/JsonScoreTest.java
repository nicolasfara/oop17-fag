package it.unibo.goffo.fag.score;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class JsonScoreTest {

    private final List<Score<String, Integer>> scoreList = new ArrayList<>();

    @Before
    public void initialize() {
        JsonScore score1 = new JsonScore("user1", 30);
        score1.setDate(LocalDate.now());
        JsonScore score2 = new JsonScore("user2", 32);
        score2.setDate(LocalDate.now());
        JsonScore score3 = new JsonScore("user3", 3);
        score3.setDate(LocalDate.now());
        JsonScore score4 = new JsonScore("user4", 44);
        score4.setDate(LocalDate.now());
        scoreList.add(score1);
        scoreList.add(score2);
        scoreList.add(score3);
        scoreList.add(score4);

    }

    @Test
    public void testComparator() {
        scoreList.sort(new ScoreComparator());
        assertThat(scoreList).isOrdered(new ScoreComparator());
    }
}
