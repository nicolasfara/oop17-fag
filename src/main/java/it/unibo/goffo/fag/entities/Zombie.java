package it.unibo.goffo.fag.entities;

import it.unibo.goffo.fag.animation.ZombieAnimationImpl;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import it.unibo.goffo.fag.entities.life.Damage;
import it.unibo.goffo.fag.entities.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.entities.movement.MoveDirection;

/**
 * Defines all enemy {@code Characters} controlled by the game.
 */
public class Zombie extends Character {
    /**
     * {@inheritDoc}
     */
    @Override
    public double getDamage() {
        return getComponent(Damage.class).getDamage();
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
    public void decrementLife(final double damage) throws CharacterDiesException {
        getComponent(LifeControllerImpl.class).decreaseOf(damage);
    }
}
