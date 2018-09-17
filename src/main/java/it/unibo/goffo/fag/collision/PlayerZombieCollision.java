package it.unibo.goffo.fag.collision;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.entities.Player;
import it.unibo.goffo.fag.entities.Zombie;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import it.unibo.goffo.fag.exceptions.GameOverException;
import it.unibo.goffo.fag.entities.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.score.controller.ScoreController;
import it.unibo.goffo.fag.score.controller.ScoreControllerImpl;
import it.unibo.goffo.fag.score.model.ScoreModelImpl;

/**
 * Basic class that handle collisions between player and zombie.
 */
public class PlayerZombieCollision implements Collision<Player, Zombie> {

    final ScoreController scoreController = ScoreControllerImpl.getInstance(new ScoreModelImpl());

    /**
     *
     */
    public PlayerZombieCollision() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCollision(final Player p1, final Zombie z1) throws GameOverException {
        try {
            p1.decrementLife(z1.getDamage());
            FXGL.getApp().getGameState().setValue("playerLife",
                    p1.getComponent(LifeControllerImpl.class).getLife());
        } catch (CharacterDiesException e1) {
            scoreController.saveScoreToFile();
            throw new GameOverException();
        }
    }
}
