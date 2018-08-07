package it.unibo.goffo.fag.score.model;

import it.unibo.goffo.fag.score.model.datatype.ScoreRecord;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScoreLogicTest {

    private ScoreLogic scoreLogic;
    private List<ScoreRecord<String, Integer>> scoreRecords;

    @Before
    public void initialize() {
        scoreLogic = new ScoreLogicImpl();
        scoreRecords = Arrays.asList(new ScoreRecord<>("player1", 10),
                new ScoreRecord<>("player2", 12),
                new ScoreRecord<>("player3", 23));
        if (scoreLogic.isEmpty()) {
            scoreLogic.getScoresFromController(scoreRecords.stream());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testException() {
        final List<ScoreRecord<String, Integer>> scoreRecordList = Collections.singletonList(new ScoreRecord<>("player100", 200));
        scoreLogic.getScoresFromController(scoreRecordList.stream());
        //now a IllegalStateException
        scoreLogic.getScoresFromController(scoreRecordList.stream());
    }
}
