package it.unibo.goffo.fag.score;

import it.unibo.goffo.fag.exceptions.UserNotFoundExceptions;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Class store a basic score for the game.
 */
@ThreadSafe
public final class BasicScore implements Score {

    private static BasicScore instance;
    private final List<ScoreRecord<String, Integer>> scoreRecordList;

    /**
     * Default constructor, initialize all properties.
     */
    private BasicScore() {
        scoreRecordList = new ArrayList<>();
    }

    /**
     * Return the singleton instance.
     * @return the instance.
     */
    public static synchronized Score getInstance() {
        if (instance == null) {
            instance = new BasicScore();
        }
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addNewScore(final ScoreRecord<String, Integer> newScore) {
        if (newScore.getScore() < 0) {
            throw new IllegalArgumentException("You must insert a positive score. " + newScore.getScore() + " is not a valid score");
        }
        if (scoreRecordList.stream().anyMatch(record -> record.getName().equals(newScore.getName()))) {
            throw new IllegalArgumentException("Record already insert in the list");
        }
        scoreRecordList.add(newScore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incrementScore(final String username, final int points) throws UserNotFoundExceptions {
        scoreRecordList.stream()
                .filter(record -> record.getName().equals(username))
                .findAny()
                .orElseThrow(UserNotFoundExceptions::new)
                .setScore(getPreviousScoreByUser(e -> e.getName().equals(username)).getScore() + points);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<ScoreRecord<String, Integer>> getAllScore() {
        return scoreRecordList.stream();
    }

    /**
     * Return the record math the predicate.
     * @param userPredicate predicate used to filter the stream.
     * @return the record match the predicate.
     * @throws UserNotFoundExceptions is thrown if there isn't any record that math the predicate.
     */
    private ScoreRecord<String, Integer> getPreviousScoreByUser(final Predicate<ScoreRecord<String, Integer>> userPredicate) throws UserNotFoundExceptions {
        return scoreRecordList.stream()
                .filter(userPredicate)
                .findAny()
                .orElseThrow(UserNotFoundExceptions::new);
    }
}
