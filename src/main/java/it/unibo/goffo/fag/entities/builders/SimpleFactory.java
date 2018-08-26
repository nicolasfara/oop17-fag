package it.unibo.goffo.fag.entities.builders;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.entities.Player;
import it.unibo.goffo.fag.entities.Zombie;
import it.unibo.goffo.fag.movement.EntityMovement;
import javafx.geometry.Point2D;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleFactory {

    Player player = (Player) FagEntities.builder(Player.class)
            .type(FagType.PLAYER)
            .at(50, 50)//.from(data)
            // data.<Integer>get("width"), data.<Integer>get("height")
            .bbox(new HitBox(BoundingShape.box(64, 64)))
            .with(new CollidableComponent(true))
            .with(new EntityMovement(1))
            .build();


    Zombie zombie = (Zombie) FagEntities.builder(Zombie.class)
            .at(randomPoint(/*max height, max width*/))
            .type(FagType.SIMPLE_ZOMBIE)
            .buildAndAttach(FXGL.getApp().getGameWorld());

    private static Point2D randomPoint(){
        final Point2D position;
        double x, y;

        x = ThreadLocalRandom.current().nextDouble();
        y = ThreadLocalRandom.current().nextDouble();
        position = new Point2D(x, y);

        return position;
    }
}

