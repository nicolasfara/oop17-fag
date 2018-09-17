package it.unibo.goffo.fag.entities.builders;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.extra.entity.components.ProjectileComponent;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;
import it.unibo.goffo.fag.entities.Bullet;
import it.unibo.goffo.fag.entities.FagType;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Factory for Bullet creation.
 */
public final class BulletFactory {

    private static final Entity PLAYER = ((FightAvengeGuerrillaApp) FXGL.getApp()).getPlayer();
    private static final double BULLET_DAMAGE = 1.0;
    private static final int SPEED = 500;

    private BulletFactory() { }

    /**
     * Create a bullet.
     * @param newDirection direction of the bullet
     */
    public static void createBullet(final Point2D newDirection) {
        Bullet bullet = (Bullet) FagEntities.builder(Bullet.class)
                .at(PLAYER.getCenter().getX(), PLAYER.getCenter().getY())
                .type(FagType.BULLET)
                .with(new ProjectileComponent(newDirection, SPEED))
                .with(new CollidableComponent(true))
                .viewFromNodeWithBBox(new Circle(10, Color.GREEN))
                .buildAndAttach(FXGL.getApp().getGameWorld());
        bullet.setScaleX(0.5);
        bullet.setScaleY(0.5);
        bullet.setDamage(BULLET_DAMAGE);
    }
}
