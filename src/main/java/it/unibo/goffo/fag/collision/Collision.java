package it.unibo.goffo.fag.collision;

// Minimum required dependencies (https://github.com/AlmasB/FXGL#minimal-example)
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.settings.GameSettings;

// Suggested basic dependencies (https://github.com/AlmasB/FXGL/wiki/Basic-Game-Example#preparation)
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
// import it.oop.Animation.DudeControl;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Map;



public class Collision extends FightAvengeGuerrillaApp {

    public enum EntityType {

        PLAYER, ZOMBIE, BULLET

    }

    private Entity player, zombie, bullet;

    @Override
    protected void initGame() {
    /*
        player = Entities.builder()
                .type(EntityType.PLAYER)
                .at(300, 300)
                .bbox(new HitBox(BoundingShape.box(32,42)))
                .with(new DudeControl())
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());
    */

        zombie = Entities.builder()
                .type(EntityType.ZOMBIE)
                .at(400, 300)
                .viewFromNodeWithBBox(new Rectangle(30,30, Color.GREEN))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        bullet = Entities.builder()
                .type(EntityType.BULLET)
                .at(300,300)
                .viewFromNodeWithBBox(new Rectangle(30,30, Color.RED))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());
    }

    @Override
    protected void initPhysics() {
    /*
        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(EntityType.PLAYER, EntityType.ZOMBIE) {
                    @Override
                    protected void onCollisionBegin(Entity player, Entity zombie) {
                        zombie.removeFromWorld();
                    }
                });
    */
        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(EntityType.BULLET, EntityType.ZOMBIE) {
                    @Override
                    protected void onCollisionBegin(Entity bullet, Entity zombie) {
                        zombie.removeFromWorld();
                    }
                });
    }
}