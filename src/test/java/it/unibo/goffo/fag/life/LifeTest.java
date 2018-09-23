package it.unibo.goffo.fag.life;

import it.unibo.goffo.fag.FagUtils;
import it.unibo.goffo.fag.entities.life.controller.LifeController;
import it.unibo.goffo.fag.entities.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Test class for Life Model (and its Builder) and Controller.
 */
public class LifeTest {

    private static final double START_VALUE = 0.7;
    private static final double LEGITIMATE_OFFSET = 0.1;
    private static final double ILLEGITIMATE_OFFSET = 2;
    private static final double ASSERT_DOUBLE_OFFSET = 0.1;

    private LifeController<Double> lifeController = new LifeControllerImpl();

    /**
     * Test decrease with a legitimate in-range value.
     */
    @Test
    public void testDecrease() {
        try {
            lifeController.decreaseOf(LEGITIMATE_OFFSET);
            assertEquals("Decrease not working properly.",
                    lifeController.getLife(), FagUtils.MAX_LIFE - LEGITIMATE_OFFSET, ASSERT_DOUBLE_OFFSET);
        } catch (CharacterDiesException e) {
            fail("Exception " + e.toString() + " should not be thrown while decreasing a legitimate value.");
        }
    }

    /**
     * Test decrease with a out-of-range value.
     */
    @Test
    public void testDecreaseGreaterThanMaxLife() {
        try {
            lifeController.decreaseOf(lifeController.getLife() + ILLEGITIMATE_OFFSET);
            fail("Decrease should throw an exception while decreasing a too high value.");
        } catch (CharacterDiesException e) {
            assertNotNull("Exception message should not be null", e.getMessage());
        }
    }

    /**
     * Test decreasing all available life.
     */
    @Test
    public void testDecreaseAllLife() {
        try {
            lifeController.decreaseOf(lifeController.getLife());
            fail("Decrease should throw an exception while decreasing all available life.");
        } catch (CharacterDiesException e) {
            assertNotNull("Exception message should not be null", e.getMessage());
        }
    }

    /**
     * Test increasing life over maximum value.
     */
    @Test
    public void testMaxLife() {
        lifeController.increaseOf(ILLEGITIMATE_OFFSET);
        assertEquals("Increase should drop exceeding value.",
                lifeController.getLife(), FagUtils.MAX_LIFE, ASSERT_DOUBLE_OFFSET);
    }

    /**
     * Test Builder creating life with exact give amount.
     */
    @Test
    public void testSetLife() {
        lifeController = new LifeControllerImpl(START_VALUE);
        assertEquals("Constructor should create an object with given life value.",
                lifeController.getLife(), START_VALUE, ASSERT_DOUBLE_OFFSET);
    }

    /**
     * Test Builder with minimum life greater than maximum/starting life value.
     */
    @Test(expected = IllegalStateException.class)
    public void testBuildOnMinLife() {
        lifeController = new LifeControllerImpl(Double.POSITIVE_INFINITY, FagUtils.MAX_LIFE, FagUtils.MAX_LIFE);
    }

    /**
     * Test Builder with given starting life value greater than default min/max values.
     */
    @Test
    public void testBuildOnMaxLife() {
        lifeController = new LifeControllerImpl(Double.POSITIVE_INFINITY);
        assertEquals("Constructor should create an object with dropped life value.",
                lifeController.getLife(), FagUtils.MAX_LIFE, ASSERT_DOUBLE_OFFSET);
    }

    /**
     * Test Builder with starting life value less than minimum value.
     */
    @Test(expected = IllegalStateException.class)
    public void testBuildOnCurrentLife() {
        lifeController = new LifeControllerImpl(FagUtils.MIN_LIFE, FagUtils.MAX_LIFE, Double.NEGATIVE_INFINITY);
    }
}
