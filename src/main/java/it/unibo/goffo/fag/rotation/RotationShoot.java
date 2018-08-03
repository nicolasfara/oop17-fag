package it.unibo.goffo.fag.rotation;

import it.unibo.goffo.fag.FightAvengeGuerrillaApp;

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
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Map;


public class RotationShoot extends FightAvengeGuerrillaApp {

    public enum EntityType {

        PLAYER

    }

    private Entity player;

    @Override
    protected void initGame() {
        player = Entities.builder()
                .type(EntityType.PLAYER)
                .at(300, 300)
                .bbox(new HitBox(BoundingShape.box(32,42)))
                .with(new DudeControl())
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());
    }

    @Override
    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Rotate Left") {
            @Override
            protected void onAction() {
                player.setRotation(-90.0);
            }
        }, KeyCode.LEFT);

        input.addAction(new UserAction("Rotate Right") {
            @Override
            protected void onAction() {
                player.setRotation(90.0);
            }
        }, KeyCode.RIGHT);

        input.addAction(new UserAction("Rotate Up") {
            @Override
            protected void onAction() {
                player.setRotation(0.0);
            }
        }, KeyCode.UP);

        input.addAction(new UserAction("Rotate Down") {
            @Override
            protected void onAction() {
                player.setRotation(180.0);
            }
        }, KeyCode.DOWN);
    }
}
