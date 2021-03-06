package it.unibo.goffo.fag.animation;

import it.unibo.goffo.fag.entities.movement.MoveDirection;

/**
 * Interface that allows to play animations.
 */
public interface Animation {
    /**
     * Enum for animation type.
     */
    enum AnimationType {
        IDLE,
        WALKING
    }

    /**
     * Plays the walking animation corresponding to a direction.
     * @param direction direction that the character is facing.
     */
    void playWalkAnimation(MoveDirection direction);

    /**
     * Plays the walking animation corresponding to a direction.
     * @param direction direction that the character is facing.
     */
    void playIdleAnimation(MoveDirection direction);
}
