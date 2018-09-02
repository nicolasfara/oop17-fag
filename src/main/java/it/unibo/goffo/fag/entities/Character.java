package it.unibo.goffo.fag.entities;

import com.almasb.fxgl.entity.Entity;
import it.unibo.goffo.fag.movement.MoveDirection;

/**
 * Specific {@code Entity} that has a life and can move.
 */
public abstract class Character extends Entity {

    /**
     * Default constructor.
     */
    public Character() {
        super();
    }

    /**
     * Attack an entity.
     */
    public abstract void attack();

    /**

     * Play a work animation on the entity.
     * @param direction Movement direction.
     */
    public abstract void playWalkAnimation(MoveDirection direction);

    /**

     * Play an idle animation on the entity.
     * @param direction Movement direction.
     */
    public abstract void playIdleAnimation(MoveDirection direction);

    /**

     * Decrement the entity's life.
     * @param damage the damage.
     */
    public abstract void decrementLife(int damage);
}
