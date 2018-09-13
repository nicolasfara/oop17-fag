package it.unibo.goffo.fag.entities;

import it.unibo.goffo.fag.movement.EntityMovement;

/**
 * Bullet.
 */
public class Bullet extends AbstractWeapon {
    /**
     * Set the damage of the bullet.
     */
    public Bullet() {
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
