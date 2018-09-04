package it.unibo.goffo.fag.rotation;

/**
 * Interface used to generate a rotation assignable to an entity.
 */
public interface Rotation {
    /**
     * The method rotate the entity face up.
     */
    void rotateUp();

    /**
     * The method rotate the entity face down.
     */
    void rotateDown();

    /**
     * The method rotate the entity face left.
     */
    void rotateLeft();

    /**
     * The method rotate the entity face right.
     */
    void rotateRight();
}
