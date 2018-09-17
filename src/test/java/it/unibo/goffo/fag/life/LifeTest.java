package it.unibo.goffo.fag.life;

import it.unibo.goffo.fag.entities.life.controller.LifeController;
import it.unibo.goffo.fag.entities.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LifeTest {

    private final LifeController<Double> lifeController= new LifeControllerImpl();

    /**
     * Test life.
     */
    @Test
    public void testDieException() {
        try {
            lifeController.decreaseOf(0.1);
        } catch (CharacterDiesException e) {
        }
    }
}
