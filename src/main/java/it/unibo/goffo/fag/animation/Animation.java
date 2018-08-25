package it.unibo.goffo.fag.animation;

/**
 * Interface that allows to play animations
 */
public interface Animation {


    /**
     * Plays the walking animation corresponding to a direction
     *
     * @param direction direction that the character is facing
     */
    void playWalkAnimation(MoveDirection direction);

    /**
     * Plays the walking animation corresponding to a direction
     *
     * @param direction direction that the character is facing
     */
    void playIdleAnimation(MoveDirection direction);
}
