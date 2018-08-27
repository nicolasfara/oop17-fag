package it.unibo.goffo.fag.entities.builders;

import it.unibo.goffo.fag.animation.ZombieAnimationImpl;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.entities.Zombie;
import javafx.geometry.Point2D;

import java.util.concurrent.ThreadLocalRandom;

public class ZombieFactory {

//    Player player = (Player) FagEntities.builder(Player.class)
//            .type(FagType.PLAYER)
//            .at(50, 50)//.from(data)
//            // data.<Integer>get("width"), data.<Integer>get("height")
//            .bbox(new HitBox(BoundingShape.box(64, 64)))
//            .with(new CollidableComponent(true))
//            .with(new EntityMovement(1))
//            .build();


    private ZombieFactory() {}

    public static Zombie createSimpleZombie() {
        final Zombie zombie = (Zombie) FagEntities.builder(Zombie.class)
                .at(randomPoint(/*max height, max width*/))
                .type(FagType.SIMPLE_ZOMBIE)
                .with(new ZombieAnimationImpl())
                .build();

        return zombie;
    }

    public static Zombie createAdvancedZombie() {
        final Zombie zombie = (Zombie) FagEntities.builder(Zombie.class)
                .at(randomPoint(/*max height, max width*/))
                .type(FagType.ADVANCE_ZOMBIE)
                .with(new ZombieAnimationImpl())
                .build();

        return zombie;
    }

    private static Point2D randomPoint(){
        final Point2D position;
        double x, y;

        x = ThreadLocalRandom.current().nextDouble();
        y = ThreadLocalRandom.current().nextDouble();
        position = new Point2D(x, y);

        return position;
    }
}

