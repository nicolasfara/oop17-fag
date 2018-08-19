package it.unibo.goffo.fag.score.controller;

import it.unibo.goffo.fag.score.Score;
import it.unibo.goffo.fag.score.model.ScoreModelImpl;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class ScoreControllerTest {

    private ScoreController scoreController;

    @Before
    public void initialize() throws NoSuchFieldException, IllegalAccessException {
        scoreController = new ScoreControllerImpl(new ScoreModelImpl());
        Field filePath = ScoreControllerImpl.class.getDeclaredField("path");
        filePath.setAccessible(true);
        filePath.set(scoreController, Paths.get(System.getProperty("java.io.tmpdir"), "fag"));
    }

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
        List<Score<String, Integer>> list = Collections.unmodifiableList(scoreController.loadScoreFromFile());
        for (Score<String, Integer> score : list) {
            System.out.println(score);
        }

        list.get(2).setDate(LocalDate.now());
        System.out.println(list);
    }
}
