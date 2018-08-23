package it.unibo.goffo.fag.entities;

import com.almasb.fxgl.entity.Entity;
import it.unibo.goffo.fag.movement.EntityMovement;

public class Character extends Entity {
    EntityMovement movement = new EntityMovement(this);
}
