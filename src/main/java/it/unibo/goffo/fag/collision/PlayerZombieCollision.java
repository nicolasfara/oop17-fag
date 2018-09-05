package it.unibo.goffo.fag.collision;

import it.unibo.goffo.fag.entities.Player;
import it.unibo.goffo.fag.entities.Zombie;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;

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
        try {
            p1.decrementLife(z1.getDamage());
        } catch (CharacterDiesException e1) {
            System.out.println("Player dead");
        }
    }
}
