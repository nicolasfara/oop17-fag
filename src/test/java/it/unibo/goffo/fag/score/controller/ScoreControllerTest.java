package it.unibo.goffo.fag.score.controller;

import it.unibo.goffo.fag.score.JsonScore;
import it.unibo.goffo.fag.score.Score;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreControllerTest {

    private ScoreController scoreController;

    @Before
    public void initialize() throws NoSuchFieldException, IllegalAccessException {
        scoreController = new ScoreControllerImpl("prop");
        Field filePath = ScoreControllerImpl.class.getDeclaredField("path");
        filePath.setAccessible(true);
        filePath.set(scoreController, Paths.get(System.getProperty("java.io.tmpdir"), "fag"));
    }

    @Test
    public void test1() {
        List<Score<String, Integer>> scoreList = new ArrayList<>();
        Score<String, Integer> score = new JsonScore("user10", 10);
        score.setDate(LocalDate.now());
        scoreList.add(score);
        scoreList.add(new JsonScore("user20", 200));
        scoreList.add(new JsonScore("user30", 23));
        scoreController.saveScoreToFile(scoreList);
    }

    @Test
    public void test2() {
        List<Score<String, Integer>> list = Collections.unmodifiableList(scoreController.loadScoreFromFile(String.class, Integer.class));
        for (Score<String, Integer> score : list) {
            System.out.println(score);
        }

        list.get(2).setDate(LocalDate.now());
        System.out.println(list);
    }
}