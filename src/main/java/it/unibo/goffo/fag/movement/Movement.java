package it.unibo.goffo.fag.movement;

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

    void translateX(double deltaX);

    void translateY(double deltaY);

    void setX(double x);

    void setY(double y);

    /**
     * Method useful to change the speed of the entity.
     * @param newSpeed the new speed to assign to the entity.
     */
    void setSpeed(float newSpeed);
}
