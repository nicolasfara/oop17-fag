package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.texture.AnimationChannel;
import it.unibo.goffo.fag.movement.MoveDirection;
import javafx.util.Duration;

/**
 * Plays animations for the player.
 */
public class PlayerAnimationImpl extends AbstractAnimation {

    private static final int IDLE_DURATION = 2800;
    private static final int WALK_DURATION = 1200;
    private final Duration walkDuration = Duration.millis(IDLE_DURATION);
    private final Duration idleDuration = Duration.millis(WALK_DURATION);
    private static final int FRAMES_PER_ROW_SHOT = 6;
    private static final int FRAMES_PER_ROW_WALK = 4;
    private static final int END_FRAME_FRONT_SHOT = 11;
    private static final int START_FRAME_SIDE_SHOT = 12;
    private static final int END_FRAME_SIDE_SHOT = 23;
    private static final int START_FRAME_BACK_SHOT = 24;
    private static final int END_FRAME_BACK_SHOT = 35;
    private static final int END_FRAME_FRONT_WALK = 3;
    private static final int START_FRAME_SIDE_WALK = 4;
    private static final int END_FRAME_SIDE_WALK = 7;
    private static final int START_FRAME_BACK_WALK = 8;
    private static final int END_FRAME_BACK_WALK = 11;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initValues() {
        idleAnimations.put(MoveDirection.DOWN, new AnimationChannel("shootFag.png", 4, WIDTH, HEIGHT, idleDuration, 0, 3));        // IdleShootFront
        idleAnimations.put(MoveDirection.RIGHT, new AnimationChannel("shootFag.png", 4, WIDTH, HEIGHT, idleDuration, 4, 7));        // IdleShootSide
        idleAnimations.put(MoveDirection.UP, new AnimationChannel("shootFag.png", 4, WIDTH, HEIGHT, idleDuration, 8, 11));       // IdleShootBack
        walkAnimations.put(MoveDirection.DOWN, new AnimationChannel("shootFag.png", 4, WIDTH, HEIGHT, walkDuration, 12, 15));      //WalkShootFront
        walkAnimations.put(MoveDirection.RIGHT, new AnimationChannel("shootFag.png", 4, WIDTH, HEIGHT, walkDuration, 16, 1));       //WalkShootSide
        walkAnimations.put(MoveDirection.UP, new AnimationChannel("shootFag.png", 4, WIDTH, HEIGHT, walkDuration, 20, 2));       //WalkShootBack
    }

}
