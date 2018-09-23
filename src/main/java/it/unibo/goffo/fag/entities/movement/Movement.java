package it.unibo.goffo.fag.entities.movement;

/**
 * Interface used to generate a movement assignable to an entity.
 */
public interface Movement {
    /**
     * The method move the entity up.
     */
    void moveUp();

    /**
     * The method move the entity down.
     */
    void moveDown();

    /**
     * The method move the entity left.
     */
    void moveLeft();

    /**
     * The method move the entity right.
     */
    void moveRight();

    /**
     * Translate the entity by the given delta on X.
     * @param deltaX the delta.
     */
    void translateX(double deltaX);

    /**
     * Translate the entity by the given delta on Y.
     * @param deltaY the delta.
     */
    void translateY(double deltaY);

    /**
     * Set the X position.
     * @param x x position.
     */
    void setX(double x);

    /**
     * Set the Y position.
     * @param y y position.
     */
    void setY(double y);

    /**
     * Method useful to change the speed of the entity.
     * @param newSpeed the new speed to assign to the entity.
     */
    void setSpeed(float newSpeed);
}
