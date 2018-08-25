package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

/**
 * Plays animations for the player
 */
public class PlayerAnimationImpl extends AbsAnimation {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initValues() {

        idleDuration = Duration.millis(2800);

        IdleAnimations.put(MoveDirection.DOWN, new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 0, 3));        // IdleShootFront
        IdleAnimations.put(MoveDirection.RIGHT, new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 4, 7));        // IdleShootSide
        IdleAnimations.put(MoveDirection.UP, new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 8, 11));       // IdleShootBack
        WalkAnimations.put(MoveDirection.DOWN, new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 12, 15));      //WalkShootFront
        WalkAnimations.put(MoveDirection.RIGHT, new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 16, 1));       //WalkShootSide
        WalkAnimations.put(MoveDirection.UP, new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 20, 2));       //WalkShootBack
    }

}
