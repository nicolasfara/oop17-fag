package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class FagControl extends Component implements AnimationPlayer {

    private int speedX = 0;
    private int speedY = 0;

    private AnimatedTexture texture;
    private Map<Animation, AnimationChannel> playerAnimations;
    //private AnimationChannel animIdleUp, animIdleRight, animIdleLeft, animIdleDown, animWalkRight, animWalkLeft, animWalkUp, animWalkDown;

    public FagControl() {
        playerAnimations = new HashMap<Animation, AnimationChannel>();

        playerAnimations.put(new Animation(MoveDirection.DOWN, true, false), new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 0, 3));        // WalkDown
        playerAnimations.put(new Animation(MoveDirection.RIGHT, true, false), new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 4, 7));        // WalkRight
        playerAnimations.put(new Animation(MoveDirection.LEFT, true, false), new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 8, 11));       // WalkLeft
        playerAnimations.put(new Animation(MoveDirection.UP, true, false), new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 12, 15));      // WalkUp
        playerAnimations.put(new Animation(MoveDirection.DOWN, false, false), new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 16, 19));      // IdleDown
        playerAnimations.put(new Animation(MoveDirection.RIGHT, false, false), new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 20, 23));      // IdleRight
        playerAnimations.put(new Animation(MoveDirection.LEFT, false, false), new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 24, 27));      // IdleLeft
        playerAnimations.put(new Animation(MoveDirection.UP, false, false), new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 28, 31));      // IdleUp
        playerAnimations.put(new Animation(MoveDirection.DOWN, false, true), new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 0, 3));        // IdleShootFront
        playerAnimations.put(new Animation(MoveDirection.RIGHT, false, true), new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 4, 7));        // IdleShootSide
        playerAnimations.put(new Animation(MoveDirection.UP, false, true), new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 8, 11));       // IdleShootBack
        playerAnimations.put(new Animation(MoveDirection.DOWN, true, true), new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 12, 15));      //WalkShootFront
        playerAnimations.put(new Animation(MoveDirection.RIGHT, true, true), new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 16, 1));       //WalkShootSide
        playerAnimations.put(new Animation(MoveDirection.UP, true, true), new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 20, 2));       //WalkShootBack
        //animWalkDown = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(1200),0,3);
        //animWalkRight = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(1200),4,7);
        //animWalkLeft = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(1200),8,11);
        //animWalkUp = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(1200),12,15);
        //animIdleDown = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(2800),16,19);
        //animIdleRight = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(2800),20,23);
        //animIdleLeft = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(2800),24,27);
        //animIdleUp = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(2800),28,31);

        texture = new AnimatedTexture(playerAnimations.get(new Animation(MoveDirection.DOWN, false, false)));
        this.PlayAnimation(MoveDirection.DOWN, false, false);

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void PlayAnimation(MoveDirection direction, boolean moving, boolean attacking) {
        AnimationChannel animation = playerAnimations.get(new Animation(direction,moving,attacking));
        texture.loopAnimationChannel(animation);
    }
}
