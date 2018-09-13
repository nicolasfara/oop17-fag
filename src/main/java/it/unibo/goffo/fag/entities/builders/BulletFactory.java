package it.unibo.goffo.fag.entities.builders;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.PhysicsComponent;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;
import it.unibo.goffo.fag.entities.Bullet;
import it.unibo.goffo.fag.entities.FagType;
import com.almasb.fxgl.entity.components.CollidableComponent;
import it.unibo.goffo.fag.entities.Zombie;
import it.unibo.goffo.fag.life.Damage;
import it.unibo.goffo.fag.movement.EntityMovement;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Factory for BUllet creation.
 */
public final class BulletFactory {

    private static final double BULLET_DAMAGE = 1.0;
    private static final Entity player = ((FightAvengeGuerrillaApp) FXGL.getApp()).getPlayer();

    private BulletFactory() { }

    /**
     * Create a bullet.
     * @return the bullet
     */
    public static Bullet createBullet() {
        Bullet bullet = (Bullet) FagEntities.builder(Bullet.class)
                .at(player.getCenter().getX(), player.getCenter().getY())
                .type(FagType.BULLET)
                //.with(new EntityMovement(10))
                .with(new Damage(BULLET_DAMAGE))
                .with(new CollidableComponent(true))
                .with(new PhysicsComponent())
                .viewFromNodeWithBBox(new Circle(10, Color.GREEN))
                .buildAndAttach(FXGL.getApp().getGameWorld());
        bullet.setScaleX(0.5);
        bullet.setScaleY(0.5);
        return bullet;
    }

}
