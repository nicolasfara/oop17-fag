package it.unibo.goffo.fag.entities.builders;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import it.unibo.goffo.fag.animation.PlayerAnimationImpl;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.entities.Player;
import it.unibo.goffo.fag.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.movement.EntityMovement;
import it.unibo.goffo.fag.rotation.EntityRotation;

import static it.unibo.goffo.fag.FagUtils.PLAYER_SIZE_X;
import static it.unibo.goffo.fag.FagUtils.PLAYER_SIZE_Y;

public final class PlayerFactory {


    public static Player createPlayer() {
        Player player = (Player) FagEntities.builder(Player.class)
                .type(FagType.PLAYER)
                .at(200, 200)
                .with(new EntityMovement(1))
                .with(new EntityRotation())
                .with(new LifeControllerImpl(1))
                .with(new PlayerAnimationImpl())
                .bbox(new HitBox(BoundingShape.box(PLAYER_SIZE_X, PLAYER_SIZE_Y)))
                .with(new CollidableComponent(true))
                .buildAndAttach(FXGL.getApp().getGameWorld());
        player.setScaleX(0.5);
        player.setScaleY(0.5);
        return player;
    }
}
