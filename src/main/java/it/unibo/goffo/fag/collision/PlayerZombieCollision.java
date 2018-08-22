package it.unibo.goffo.fag.collision;

import com.almasb.fxgl.entity.Entity;

/**
 * Basic class that handle collisions between player and zombie.
 */
public class PlayerZombieCollision extends AbstractCollision {

    private final Entity player, zombie;

    PlayerZombieCollision(final Entity entityOne, final Entity entityTwo) {
        super();
        this.player = entityOne;
        this.zombie = entityTwo;
    }

    /**
     *
     *
     */
    @Override
    protected void onCollision() {
        // player perde vita
        //
    }
}
