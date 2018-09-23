package it.unibo.goffo.fag.score;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static com.google.common.truth.Truth.assertThat;

/**
 * Test all possible cases for the comparator.
 */
public class JsonScoreTest {

    private final ScoreComparator scoreComparator = new ScoreComparator();
    private static final int SCORE1 = 20;
    private static final int SCORE2 = 30;
    private static final int YEAR = 2018;

    /**
     * Test the great case.
     */
    @Test
    public void testGraterThan() {
        final JsonScore score1 = new JsonScore("player1", SCORE1);
        score1.setDate(LocalDate.now());
        final JsonScore score2 = new JsonScore("player2", SCORE2);
        score2.setDate(LocalDate.now());
        assertThat(scoreComparator.compare(score1, score2)).isGreaterThan(0);
    }

    /**
     * Test the equal case.
     */
    @Test
    public void testEqual() {
        final JsonScore score1 = new JsonScore("player11", SCORE1);
        score1.setDate(LocalDate.now());
        final JsonScore score2 = new JsonScore("player12", SCORE1);
        score2.setDate(LocalDate.now());
        assertThat(scoreComparator.compare(score1, score2)).isEqualTo(0);
    }

    /**
     * Test less case.
     */
    @Test
    public void testLessThan() {
        final JsonScore score1 = new JsonScore("player21", SCORE2);
        score1.setDate(LocalDate.now());
        final JsonScore score2 = new JsonScore("player22", SCORE1);
        score2.setDate(LocalDate.now());
        assertThat(scoreComparator.compare(score1, score2)).isLessThan(0);
    }

    /**
     * Test the different date.
     */
    @Test
    public void testEqualScoreDifferentDate() {
        final JsonScore score1 = new JsonScore("player31", 20);
        score1.setDate(LocalDate.of(YEAR, Month.JANUARY, 1));
        final JsonScore score2 = new JsonScore("player32", 20);
        score2.setDate(LocalDate.of(YEAR, Month.DECEMBER, 1));
        assertThat(scoreComparator.compare(score1, score2)).isLessThan(0);
    }
}
