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
    public MoveDirectionTest() {
        super();
    }

    @Test
    public void testNextPosition() {
        MoveDirection moveDirection = MoveDirection.UP;
        assertEquals("The next should be RIGHT", moveDirection.next(), MoveDirection.RIGHT);
        moveDirection = moveDirection.next();
        assertEquals("The next should be DOWN", moveDirection.next(), MoveDirection.DOWN);
        moveDirection = moveDirection.next();
        assertEquals("The next should be LEFT", moveDirection.next(), MoveDirection.LEFT);
        moveDirection = moveDirection.next();
        assertEquals("The next should be UP", moveDirection.next(), MoveDirection.UP);
    }

    @Test
    public void testPrevPosition() {
        MoveDirection moveDirection = MoveDirection.UP;
        assertEquals("The prev should be LEFT", moveDirection.prev(), MoveDirection.LEFT);
        moveDirection = moveDirection.prev();
        assertEquals("The prev should be DOWN", moveDirection.prev(), MoveDirection.DOWN);
        moveDirection = moveDirection.prev();
        assertEquals("The prev should be RIGHT", moveDirection.prev(), MoveDirection.RIGHT);
        moveDirection = moveDirection.prev();
        assertEquals("The prev should be UP", moveDirection.prev(), MoveDirection.UP);
    }
}
