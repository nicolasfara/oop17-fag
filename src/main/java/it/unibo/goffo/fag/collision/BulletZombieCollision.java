package it.unibo.goffo.fag.collision;

import com.almasb.fxgl.entity.Entity;

/**
 * Basic class that handle collisions between bullet and zombie.
 */
public class BulletZombieCollision extends AbstractCollision {

    private final Entity bullet, zombie;

    BulletZombieCollision(final Entity entityOne, final Entity entityTwo) {
        super();
        this.bullet = entityOne;
        this.zombie = entityTwo;
    }

    /**
     *
     *
     */
    @Override
    protected void onCollision() {
        // zombie.decreaseLife();
        zombie.removeFromWorld();
        bullet.removeFromWorld();
    }
}

/*

Remove Abstract class
Remove param from constructor

add param to method


 */