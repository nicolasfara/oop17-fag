package it.unibo.goffo.fag.collision;

import it.unibo.goffo.fag.entities.Player;
import it.unibo.goffo.fag.entities.Zombie;

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
    public void onCollision(final Player p1, final Zombie z1) {
        // p1.decLife();
    }
}
