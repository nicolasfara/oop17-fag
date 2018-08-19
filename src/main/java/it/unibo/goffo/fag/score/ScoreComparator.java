package it.unibo.goffo.fag.score;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Comparator class for score.
 */
public class ScoreComparator implements Comparator<Score<String, Integer>>, Serializable {
    public static final long serialVersionUID = 856213157L;
    /**
     * {@inheritDoc}
     */
    @Override
    public int compare(final Score<String, Integer> score1, final Score<String, Integer> score2) {
        if (score1.getScore() > score2.getScore()) {
            return -1;
        } else if (score1.getScore().equals(score2.getScore())) {
            if (score1.getDate().isBefore(score2.getDate())) {
                return -1;
            } else if (score1.getDate().isAfter(score2.getDate())) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }
}
