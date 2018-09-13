package it.unibo.goffo.fag.entities;

import it.unibo.goffo.fag.animation.PlayerAnimationImpl;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import it.unibo.goffo.fag.life.Damage;
import it.unibo.goffo.fag.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.movement.EntityMovement;
import it.unibo.goffo.fag.movement.MoveDirection;

/**
 * The {@code Character} controlled by the user.
 */
public class Player extends Character {
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
        getComponentOptional(PlayerAnimationImpl.class).ifPresent(anim -> anim.playWalkAnimation(direction));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void playIdleAnimation(final MoveDirection direction) {
        getComponentOptional(PlayerAnimationImpl.class).ifPresent(anim -> anim.playIdleAnimation(direction));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void decrementLife(final double damage) throws CharacterDiesException {
        getComponent(LifeControllerImpl.class).decreaseOf(damage);
    }

    /**
     * Move the entity up.
     */
    public void moveUp() {
        getComponent(EntityMovement.class).moveUp();
    }

    /**
     * Move the entity down.
     */
    public void moveDown() {
        getComponent(EntityMovement.class).moveDown();
    }

    /**
     * Move the entity left.
     */
    public void moveLeft() {
        getComponent(EntityMovement.class).moveLeft();
    }

    /**
     * Move the entity right.
     */
    public void moveRight() {
        getComponent(EntityMovement.class).moveRight();
    }

}
