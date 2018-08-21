package it.unibo.goffo.fag.movement;

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


public class Movement extends FightAvengeGuerrillaApp {

    /**
     * deve implementare movement (che non si è capito chi deve farla)
     *
     * bisogna anche importare la classe che genera il player e sostituire i vari parametri
     */
    public enum EntityType {

        PLAYER

    }

    private Entity player;

    @Override
    protected void initGame() {
        player = Entities.builder()
                .type(EntityType.PLAYER)
                .at(300, 300)
                .bbox(new HitBox(BoundingShape.box(32, 42)))
                .with(new DudeControl())
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());
    }

    /**
     *
     * @param input
     *
     * sostituire "player" con il corrispondente della classe che verrà fatta
     */
    public void onMovement(Input input) {

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                player.getComponent(DudeControl.class).moveRight();
                getGameState().increment("pixelsMoved", +5);
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.getComponent(DudeControl.class).moveLeft();
                getGameState().increment("pixelsMoved", +5);
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                player.translateY(-5); // move up 5 pixels
                getGameState().increment("pixelsMoved", +5);
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                player.translateY(5); // move down 5 pixels
                getGameState().increment("pixelsMoved", +5);
            }
        }, KeyCode.S);
    }
}