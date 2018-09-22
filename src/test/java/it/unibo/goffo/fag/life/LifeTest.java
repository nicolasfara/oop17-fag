package it.unibo.goffo.fag.life;

import it.unibo.goffo.fag.FagUtils;
import it.unibo.goffo.fag.entities.life.controller.LifeController;
import it.unibo.goffo.fag.entities.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class LifeTest {

    private LifeController<Double> lifeController= new LifeControllerImpl();

    @Test
    public void testDecrease() {
        try {
            lifeController.decreaseOf(0.1);
            assertEquals("Decrease not working properly.",
                    lifeController.getLife(), FagUtils.MAX_LIFE - 0.1, 0.1);
        } catch (CharacterDiesException e){
            fail("Exception " + e.toString() + " should not be thrown while decreasing a legitimate value.");
        }
    }

    @Test
    public void testDecreaseGreaterThanMaxLife() {
        try {
            lifeController.decreaseOf(lifeController.getLife() + 1);
            fail("Decrease should throw an exception while decreasing a too high value.");
        } catch (CharacterDiesException e) {
            assertNotNull("Exception message should not be null", e.getMessage());
        }
    }

    @Test
    public void testDecreaseAllLife() {
        try {
            lifeController.decreaseOf(lifeController.getLife());
            fail("Decrease should throw an exception while decreasing all available life.");
        } catch (CharacterDiesException e) {
            assertNotNull("Exception message should not be null", e.getMessage());
        }
    }

    @Test
    public void testMaxLife() {
        lifeController.increaseOf(2.0);
        assertEquals("Increase should drop exceeding value.",
                lifeController.getLife(), FagUtils.MAX_LIFE, 0.1);
    }

    @Test
    public void testSetLife() {
        lifeController = new LifeControllerImpl(0.7);
        assertEquals("Constructor should create an object with given life value.",
                lifeController.getLife(), 0.7, 0.1);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildOnMinLife() {
        lifeController = new LifeControllerImpl(Double.POSITIVE_INFINITY, FagUtils.MAX_LIFE, FagUtils.MAX_LIFE);
    }

    @Test
    public void testBuildOnMaxLife() {
        lifeController = new LifeControllerImpl(Double.POSITIVE_INFINITY);
        assertEquals("Constructor should create an object with dropped life value.",
                lifeController.getLife(), FagUtils.MAX_LIFE, 0.1);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildOnCurrentLife() {
        lifeController = new LifeControllerImpl(FagUtils.MIN_LIFE, FagUtils.MAX_LIFE, Double.NEGATIVE_INFINITY);
    }
}
