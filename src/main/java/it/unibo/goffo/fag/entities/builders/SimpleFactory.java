package it.unibo.goffo.fag.entities.builders;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.entities.Player;
import it.unibo.goffo.fag.entities.Zombie;
import it.unibo.goffo.fag.movement.EntityMovement;

public class SimpleFactory {

    Player player = (Player) FagEntities.builder(Player.class)
            .type(FagType.PLAYER)
            .from(data)
            .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
            .with(new CollidableComponent(true))
            .with(new EntityMovement(1))
            .build();


    Zombie zombie = (Zombie) FagEntities.builder(Zombie.class)
            .at(200, 200)
            .type(FagType.SIMPLE_ZOMBIE)
            .buildAndAttach(FXGL.getApp().getGameWorld());

}
