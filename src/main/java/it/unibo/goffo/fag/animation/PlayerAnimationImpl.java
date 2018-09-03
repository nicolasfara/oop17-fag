package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import it.unibo.goffo.fag.movement.MoveDirection;
import javafx.util.Duration;

/**
 * Plays animations for the player.
 */
public class PlayerAnimationImpl extends AbstractAnimation {

    private static final int IDLE_DURATION = 2800;
    private static final int WALK_DURATION = 1200;
    private static final int WIDTH = 128;
    private static final int HEIGHT = 128;
    private static final int FRAMES_PER_ROW = 4;
    private static final int END_FRAME_SHOT_FRONT = 3;
    private static final int START_FRAME_SHOT_SIDE = 4;
    private static final int END_FRAME_SHOT_SIDE = 7;
    private static final int START_FRAME_SHOT_BACK = 8;
    private static final int END_FRAME_SHOT_BACK = 11;
    private static final int START_FRAME_WALK_FRONT = 12;
    private static final int END_FRAME_WALK_FRONT = 15;
    private static final int START_FRAME_WALK_SIDE = 16;
    private static final int END_FRAME_WALK_SIDE = 19;
    private static final int START_FRAME_WALK_BACK = 20;
    private static final int END_FRAME_WALK_BACK = 23;
    private final Duration walkDuration = Duration.millis(IDLE_DURATION);
    private final Duration idleDuration = Duration.millis(WALK_DURATION);
    private final AnimationChannel shotFront = new AnimationChannel("shootFag.png", FRAMES_PER_ROW, WIDTH, HEIGHT, idleDuration, 0, END_FRAME_SHOT_FRONT);
    private final AnimationChannel shotSide = new AnimationChannel("shootFag.png", FRAMES_PER_ROW, WIDTH, HEIGHT, idleDuration, START_FRAME_SHOT_SIDE, END_FRAME_SHOT_SIDE);
    private final AnimationChannel shotBack = new AnimationChannel("shootFag.png", FRAMES_PER_ROW, WIDTH, HEIGHT, idleDuration, START_FRAME_SHOT_BACK, END_FRAME_SHOT_BACK);
    private final AnimationChannel walkFront = new AnimationChannel("shootFag.png", FRAMES_PER_ROW, WIDTH, HEIGHT, walkDuration, START_FRAME_WALK_FRONT, END_FRAME_WALK_FRONT);
    private final AnimationChannel walkSide = new AnimationChannel("shootFag.png", FRAMES_PER_ROW, WIDTH, HEIGHT, walkDuration, START_FRAME_WALK_SIDE, END_FRAME_WALK_SIDE);
    private final AnimationChannel walkBack = new AnimationChannel("shootFag.png", FRAMES_PER_ROW, WIDTH, HEIGHT, walkDuration, START_FRAME_WALK_BACK, END_FRAME_WALK_BACK);
    private AnimatedTexture texture;

    /**
     * Initialize texture for animation.
     */
    public PlayerAnimationImpl() {
        texture = new AnimatedTexture(shotFront);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void playAnimation(final AnimationType animationType, final MoveDirection direction) {
        switch (direction) {
            case UP:
                if (animationType == AnimationType.WALKING) {
                    texture.loopAnimationChannel(walkBack);
                } else {
                    texture.loopAnimationChannel(shotBack);
                }
                break;
            case DOWN:
                if (animationType == AnimationType.WALKING) {
                    texture.loopAnimationChannel(walkFront);
                } else {
                    texture.loopAnimationChannel(shotFront);
                }
                break;
            case LEFT:
                if (animationType == AnimationType.WALKING) {
                    texture.loopAnimationChannel(walkSide);
                } else {
                    texture.loopAnimationChannel(shotSide);
                }
                getEntity().setScaleX(-1);
                break;
            case RIGHT:
                if (animationType == AnimationType.WALKING) {
                    texture.loopAnimationChannel(walkSide);
                } else {
                    texture.loopAnimationChannel(shotSide);
                }
                getEntity().setScaleX(1);
                break;
                default:
                    break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdded() {
        super.onAdded();
        getEntity().setView(texture);
    }
}
