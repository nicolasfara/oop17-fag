package it.unibo.goffo.fag.ai.controller;

import javafx.geometry.Point2D;

/**
 * Interface that specify all methods to move a Component.
 */
public interface MoveController {
    /**
     * .
     * @return true if the component was completely move to destination, false otherwise.
     */
    boolean isDone();

    /**
     * The method move the component from the current position to destination position.
     * @param destination destination where the component must to be moved to.
     */
    void moveTo(Point2D destination);
}
