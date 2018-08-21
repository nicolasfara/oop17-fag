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
    /**
     * Bisogna estendere o ereditare da player (o quella in cui si creano le 3 entita)
     * poi sistemare i type del metodo e le dipendeze e siamo a posto
     * fare test sul main per la call al metodo e vedere se funziona
     * 
     */
    public void onCollision(EntityType first, EntityType second) {
        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(first, second) {
                    @Override
                    protected void onCollisionBegin(Entity bullet, Entity zombie) {
                        zombie.removeFromWorld();
                    }
                });
    }
}