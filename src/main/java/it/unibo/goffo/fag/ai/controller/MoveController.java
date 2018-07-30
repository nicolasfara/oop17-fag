package it.unibo.goffo.fag.ai.controller;

/**
 * Interface specify a method for setting the move direction.
 */
public interface MoveController {
    /**
     * This method when called set the direction that the entity must take.
     * @param moveDirection the direction where the entity must move to.
     */
    void setMoveDirection(MoveDirection moveDirection);
}
