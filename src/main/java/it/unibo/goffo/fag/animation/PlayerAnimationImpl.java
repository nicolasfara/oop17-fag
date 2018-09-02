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
    private final Duration walkDuration = Duration.millis(IDLE_DURATION);
    private final Duration idleDuration = Duration.millis(WALK_DURATION);
    private static final int WIDTH = 128;
    private static final int HEIGHT = 128;
    private static final int FRAMES_PER_ROW_SHOT = 4;
    private static final int FRAMES_PER_ROW_WALK = 4;
    private static final int END_FRAME_FRONT_SHOT = 3;
    private static final int START_FRAME_SIDE_SHOT = 12;
    private static final int END_FRAME_SIDE_SHOT = 23;
    private static final int START_FRAME_BACK_SHOT = 24;
    private static final int END_FRAME_BACK_SHOT = 35;
    private static final int END_FRAME_FRONT_WALK = 3;
    private static final int START_FRAME_SIDE_WALK = 4;
    private static final int END_FRAME_SIDE_WALK = 7;
    private static final int START_FRAME_BACK_WALK = 8;
    private static final int END_FRAME_BACK_WALK = 11;
    private final AnimationChannel shotFront = new AnimationChannel("shotFag.png", 4, WIDTH, HEIGHT, idleDuration, 0, 3);
    private final AnimationChannel shotSide = new AnimationChannel("shotFag.png", 4, WIDTH, HEIGHT, idleDuration, 4, 7);
    private final AnimationChannel shotBack = new AnimationChannel("shotFag.png", 4, WIDTH, HEIGHT, idleDuration, 8, 11);
    private final AnimationChannel walkFront = new AnimationChannel("shotFag.png", 4, WIDTH, HEIGHT, walkDuration, 12, 15);
    private final AnimationChannel walkSide = new AnimationChannel("shotFag.png", 4, WIDTH, HEIGHT, walkDuration, 16, 19);
    private final AnimationChannel walkBack = new AnimationChannel("shotFag.png", 4, WIDTH, HEIGHT, walkDuration, 20, 23);
    private AnimatedTexture texture;

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
                getEntity().getView().setScaleX(-1);
            case RIGHT:
                if (animationType == AnimationType.WALKING) {
                    texture.loopAnimationChannel(walkSide);
                } else {
                    texture.loopAnimationChannel(shotSide);
                }
                default:
                    break;
        }
    }
}
