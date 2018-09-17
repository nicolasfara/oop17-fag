package it.unibo.goffo.fag.collision;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.entities.Bullet;
import it.unibo.goffo.fag.entities.Zombie;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;

/**
 * Basic class that handle collisions between bullet and zombie.
 */
public class BulletZombieCollision implements Collision<Bullet, Zombie> {

    /**
     *
     */
    public BulletZombieCollision() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCollision(final Bullet b1, final Zombie z1) {
        try {
            b1.removeFromWorld();
            z1.decrementLife(b1.getDamage());
        } catch (CharacterDiesException e1) {
            z1.removeFromWorld();
            FXGL.getApp().getGameState().setValue("points",
                    String.valueOf(Integer.valueOf(FXGL.getApp().getGameState().getString("points")) + 1));
        }
    }
}
