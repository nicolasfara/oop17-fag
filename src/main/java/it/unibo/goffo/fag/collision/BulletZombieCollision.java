package it.unibo.goffo.fag.collision;

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
    public void onCollision(Bullet p1, Zombie z1) {
        // z1.decLife();
        // b1.removeFromWorld();
    }
}
