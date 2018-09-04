package it.unibo.goffo.fag.collision;

import it.unibo.goffo.fag.entities.Bullet;
import it.unibo.goffo.fag.entities.Zombie;

/**
 * Basic class that handle collisions between bullet and zombie.
 */
public class BulletZombieCollision implements Collision<Bullet, Zombie> {

    BulletZombieCollision() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCollision(final Bullet b1, final Zombie z1) {
        // z1.decLife();
        // b1.removeFromWorld();
    }
}
