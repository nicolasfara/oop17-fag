package it.unibo.goffo.fag.score;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static com.google.common.truth.Truth.assertThat;

public class JsonScoreTest {

    private ScoreComparator scoreComparator = new ScoreComparator();

    @Test
    public void testGraterThan() {
        JsonScore score1 = new JsonScore("player1", 20);
        score1.setDate(LocalDate.now());
        JsonScore score2 = new JsonScore("player2", 30);
        score2.setDate(LocalDate.now());
        assertThat(scoreComparator.compare(score1, score2)).isGreaterThan(0);
    }

    @Test
    public void testEqual() {
        JsonScore score1 = new JsonScore("player1", 20);
        score1.setDate(LocalDate.now());
        JsonScore score2 = new JsonScore("player2", 20);
        score2.setDate(LocalDate.now());
        assertThat(scoreComparator.compare(score1, score2)).isEqualTo(0);
    }

    @Test
    public void testLessThan() {
        JsonScore score1 = new JsonScore("player1", 30);
        score1.setDate(LocalDate.now());
        JsonScore score2 = new JsonScore("player2", 20);
        score2.setDate(LocalDate.now());
        assertThat(scoreComparator.compare(score1, score2)).isLessThan(0);
    }

    @Test
    public void testEqualScoreDifferentDate() {
        JsonScore score1 = new JsonScore("player1", 20);
        score1.setDate(LocalDate.of(2018, Month.JANUARY, 1));
        JsonScore score2 = new JsonScore("player2", 20);
        score2.setDate(LocalDate.of(2018, Month.DECEMBER, 31));
        assertThat(scoreComparator.compare(score1, score2)).isLessThan(0);
    }
}
