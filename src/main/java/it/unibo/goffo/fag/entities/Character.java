package it.unibo.goffo.fag.entities;

import com.almasb.fxgl.entity.Entity;
import it.unibo.goffo.fag.movement.MoveDirection;

/**
 * Specific {@code Entity} that has a life and can move
 */
public abstract class Character extends Entity {

    /**
     * Default constructor
     */
    public Character() {
        super();
    }

    /**
     *
     */
    public abstract void attack();

    /**
     *
     * @param direction
     */
    public abstract void playWalkAnimation(MoveDirection direction);

    /**
     *
     * @param direction
     */
    public abstract void playIdleAnimation(MoveDirection direction);

    /**
     *
     * @param damage
     */
    public abstract void decrementLife(int damage);
}
