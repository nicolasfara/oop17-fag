package it.unibo.goffo.fag.life;

import it.unibo.goffo.fag.FagUtils;
import it.unibo.goffo.fag.entities.life.controller.LifeController;
import it.unibo.goffo.fag.entities.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LifeTest {

    private LifeController<Double> lifeController= new LifeControllerImpl();

    @Test
    public void testDecrease() {
        // Decreasing an amount less than maxValue
        try {
            lifeController.decreaseOf(0.1);
            assertEquals(lifeController.getLife(), FagUtils.MAX_LIFE - 0.1, 0.1);
        } catch (CharacterDiesException e){
            fail();
        }
    }

    @Test
    public void testDecreaseGreaterThanMaxLife() {
        try {
            lifeController.decreaseOf(lifeController.getLife() + 1);
            fail();
        } catch (CharacterDiesException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDecreaseAllLife() {
        try {
            lifeController.decreaseOf(lifeController.getLife());
            fail();
        } catch (CharacterDiesException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMaxLife() {
        lifeController.increaseOf(2.0);
        assertEquals(lifeController.getLife(), FagUtils.MAX_LIFE, 0.1);
    }

    @Test
    public void testSetLife() {
        lifeController = new LifeControllerImpl(0.7);
        assertEquals(lifeController.getLife(), 0.7, 0.1);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildOnMinLife() {
        lifeController = new LifeControllerImpl(Double.POSITIVE_INFINITY, FagUtils.MAX_LIFE, FagUtils.MAX_LIFE);
    }

    @Test
    public void testBuildOnMaxLife() {
        lifeController = new LifeControllerImpl(Double.POSITIVE_INFINITY);
        assertEquals(lifeController.getLife(), FagUtils.MAX_LIFE, 0.1);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildOnCurrentLife() {
        lifeController = new LifeControllerImpl(FagUtils.MIN_LIFE, FagUtils.MAX_LIFE, Double.NEGATIVE_INFINITY);
    }
}
