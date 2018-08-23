package it.unibo.goffo.fag.entities;

import com.almasb.fxgl.entity.Entity;
import it.unibo.goffo.fag.movement.EntityMovement;

/**
 * Specific {@code Entity} that has a life and can move
 */
public class Character extends Entity {
    private static EntityMovement movement;

    /**
     * Default constructor
     */
    public Character() {
        super();
        movement = new EntityMovement(this);
    }
}
