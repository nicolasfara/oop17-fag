package it.unibo.goffo.fag.entities;

import com.almasb.fxgl.entity.Entity;
import it.unibo.goffo.fag.entities.movement.MoveDirection;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;

/**
 * Specific {@code Entity} that has a life and can move.
 */
public abstract class Character extends Entity {

    /**
     * Get the damage.
     * @return return the damage.
     */
    public abstract double getDamage();

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
     * @throws CharacterDiesException will thrown if the character die.
     */
    public abstract void decrementLife(double damage) throws CharacterDiesException;
}
