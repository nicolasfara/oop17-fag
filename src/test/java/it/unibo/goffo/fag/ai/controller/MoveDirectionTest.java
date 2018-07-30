package it.unibo.goffo.fag.ai.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class to test {@code MoveDirection}.
 */
public class MoveDirectionTest {
    /**
     * Default constructor.
     */
    public MoveDirectionTest() { }

    @Test
    public void testNextPosition() {
        MoveDirection moveDirection = MoveDirection.UP;
        assertEquals(moveDirection.next(), MoveDirection.RIGHT);
        moveDirection = moveDirection.next();
        assertEquals(moveDirection.next(), MoveDirection.DOWN);
        moveDirection = moveDirection.next();
        assertEquals(moveDirection.next(), MoveDirection.LEFT);
        moveDirection = moveDirection.next();
        assertEquals(moveDirection.next(), MoveDirection.UP);
    }

    @Test
    public void testPrevPosition() {
        MoveDirection moveDirection = MoveDirection.UP;
        assertEquals(moveDirection.prev(), MoveDirection.LEFT);
        moveDirection = moveDirection.prev();
        assertEquals(moveDirection.prev(), MoveDirection.DOWN);
        moveDirection = moveDirection.prev();
        assertEquals(moveDirection.prev(), MoveDirection.RIGHT);
        moveDirection = moveDirection.prev();
        assertEquals(moveDirection.prev(), MoveDirection.UP);
    }
}
