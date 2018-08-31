package it.unibo.goffo.fag.entities.builders;

import it.unibo.goffo.fag.animation.ZombieAnimationImpl;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.entities.Zombie;
import javafx.geometry.Point2D;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public final class ZombieFactory {

    private ZombieFactory() { }

    /**
     *
     * @return
     */
    public static Zombie createSimpleZombie() {
        return (Zombie) FagEntities.builder(Zombie.class)
                .at(randomPoint())
                .type(FagType.SIMPLE_ZOMBIE)
                .with(new ZombieAnimationImpl())
                .build();
    }

    /**
     *
     * @return
     */
    public static Zombie createAdvancedZombie() {
        return (Zombie) FagEntities.builder(Zombie.class)
                .at(randomPoint())
                .type(FagType.ADVANCE_ZOMBIE)
                .with(new ZombieAnimationImpl())
                .build();
    }

    /**
     *
     * @return
     */
    private static Point2D randomPoint() {
        return new Point2D(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble());
    }
}

