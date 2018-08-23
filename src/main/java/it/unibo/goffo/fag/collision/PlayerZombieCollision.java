package it.unibo.goffo.fag.collision;

/**
 * Basic class that handle collisions between player and zombie.
 */
public class PlayerZombieCollision implements Collision<Player, Zombie> {

    PlayerZombieCollision() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCollision(Player p1, Zombie z1) {
        // p1.decLife();
    }
}
