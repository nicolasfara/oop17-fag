package it.unibo.goffo.fag.entities;

import it.unibo.goffo.fag.animation.ZombieAnimationImpl;
import it.unibo.goffo.fag.movement.MoveDirection;

/**
 * Defines all enemy {@code Characters} controlled by the game.
 */
public class Zombie extends Character {
    /**
     * {@inheritDoc}
     */
    @Override
    public void attack() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void playWalkAnimation(final MoveDirection direction) {
        getComponentOptional(ZombieAnimationImpl.class).ifPresent(anim -> anim.playWalkAnimation(direction));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void playIdleAnimation(final MoveDirection direction) {
        getComponentOptional(ZombieAnimationImpl.class).ifPresent(anim -> anim.playIdleAnimation(direction));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void decrementLife(final int damage) {

    }
}
