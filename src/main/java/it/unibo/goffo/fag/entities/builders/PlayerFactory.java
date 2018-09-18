package it.unibo.goffo.fag.entities.builders;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import it.unibo.goffo.fag.animation.PlayerAnimationImpl;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.entities.Player;
import it.unibo.goffo.fag.entities.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.entities.movement.EntityMovement;

import static it.unibo.goffo.fag.FagUtils.PLAYER_SIZE_X;
import static it.unibo.goffo.fag.FagUtils.PLAYER_SIZE_Y;

/**
 * Factory for player creation.
 */
public final class PlayerFactory {

    private PlayerFactory() { }

    /**
     * Creates the player.
     * @return the player.
     */
    public static Player createPlayer() {
        return (Player) FagEntities.builder(Player.class)
                .type(FagType.PLAYER)
                .at(100, 100)
                .with(new EntityMovement(1))
                .with(new LifeControllerImpl(1))
                .with(new PlayerAnimationImpl())
                .bbox(new HitBox(BoundingShape.box(PLAYER_SIZE_X, PLAYER_SIZE_Y)))
                .with(new CollidableComponent(true))
                .buildAndAttach(FXGL.getApp().getGameWorld());
    }
}
