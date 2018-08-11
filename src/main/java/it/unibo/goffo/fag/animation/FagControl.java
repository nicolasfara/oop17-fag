package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.BoundingBoxComponent;
import com.almasb.fxgl.entity.components.PositionComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import it.unibo.goffo.fag.entities.FagType;
import javafx.util.Duration;

import java.util.List;

public class FagControl extends Component {

    private PositionComponent position;
    private BoundingBoxComponent bbox;
    private int speedX = 0;
    private int speedY = 0;
    private static final int width = 128;
    private static final int height = 128;

    private AnimatedTexture texture;
    private AnimationChannel animIdleUp, animIdleRight, animIdleLeft, animIdleDown, animWalkRight, animWalkLeft, animWalkUp, animWalkDown;

    public FagControl() {
        animWalkDown = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(1200),0,3);
        animWalkRight = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(1200),4,7);
        animWalkLeft = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(1200),8,11);
        animWalkUp = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(1200),12,15);
        animIdleDown = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(2800),16,19);
        animIdleRight = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(2800),20,23);
        animIdleLeft = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(2800),24,27);
        animIdleUp = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(2800),28,31);

        texture = new AnimatedTexture(animIdleDown);
        texture.loopAnimationChannel(animIdleDown);
    }

    @Override
    public void onAdded() {
        entity.setView(texture);
    }

    @Override
    public void onUpdate(double tpf) {
        entity.translateX(speedX * tpf);
        entity.translateY(speedY * tpf);

        if (speedY != 0) {

            if (texture.getAnimationChannel() != animWalkDown && speedY > 0) {
                texture.loopAnimationChannel(animWalkDown);
            }

            if (texture.getAnimationChannel() != animWalkUp && speedY < 0) {
                texture.loopAnimationChannel(animWalkUp);
            }

            speedY = (int) (speedY * 0.9);

            if (FXGLMath.abs(speedY) < 1) {
                if (texture.getAnimationChannel() == animWalkDown){
                    texture.loopAnimationChannel(animIdleDown);
                }
                if (texture.getAnimationChannel() == animWalkUp){
                    texture.loopAnimationChannel(animIdleUp);
                }
                speedY = 0;
            }
        }

        if (speedX != 0) {

            if (texture.getAnimationChannel() != animWalkRight && speedX > 0) {
                texture.loopAnimationChannel(animWalkRight);
            }

            if (texture.getAnimationChannel() != animWalkLeft && speedX < 0) {
                texture.loopAnimationChannel(animWalkLeft);
            }

            speedX = (int) (speedX * 0.9);

            if (FXGLMath.abs(speedX) < 1) {
                if (texture.getAnimationChannel() == animWalkRight){
                    texture.loopAnimationChannel(animIdleRight);
                }
                if (texture.getAnimationChannel() == animWalkLeft){
                    texture.loopAnimationChannel(animIdleLeft);
                }
                speedX = 0;
            }
        }
    }

    public void moveUp() {
        speedY = -40;

        //texture.loopAnimationChannel(animWalkUp);
    }

    public void moveLeft() {
        speedX = -40;

        //texture.loopAnimationChannel(animWalkLeft);
    }

    public void moveRight() {
        speedX = 40;

        //texture.loopAnimationChannel(animWalkRight);
    }

    public void moveDown() {
        speedY = 40;

        //texture.loopAnimationChannel(animWalkDown);
    }

    public void stop() {
        speedX = 0;
        speedY = 0;
    }

    private List<Entity> walls;
    
    private void move(double dx, double dy) {
        if (!getEntity().isActive())
            return;

        if (walls == null) {
            walls = FXGL.getApp().getGameWorld().getEntitiesByType(FagType.WALL);
        }

        double mag = Math.sqrt(dx * dx + dy * dy);
        long length = Math.round(mag);

        double unitX = dx / mag;
        double unitY = dy / mag;

        for (int i = 0; i < length; i++) {
            position.translate(unitX, unitY);

            boolean collision = false;

            for (int j = 0; j < walls.size(); j++) {
                if (walls.get(j).getBoundingBoxComponent().isCollidingWith(bbox)) {
                    collision = true;
                    break;
                }
            }

            if (collision) {
                position.translate(-unitX, -unitY);
                break;
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
