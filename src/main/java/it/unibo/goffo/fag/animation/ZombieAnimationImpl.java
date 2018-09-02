package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import it.unibo.goffo.fag.movement.MoveDirection;
import javafx.util.Duration;

/**
 * Plays animations for the zombies.
 */
public class ZombieAnimationImpl extends AbstractAnimation {

    private static final int IDLE_DURATION = 1200;
    private static final int WALK_DURATION = 2400;
    private final Duration walkDuration = Duration.millis(IDLE_DURATION);
    private final Duration idleDuration = Duration.millis(WALK_DURATION);
    private static final int WIDTH = 128;
    private static final int HEIGHT = 128;
    private static final int FRAMES_PER_ROW_ATTACK = 6;
    private static final int FRAMES_PER_ROW_WALK = 4;
    private static final int END_FRAME_FRONT_ATTACK = 11;
    private static final int START_FRAME_SIDE_ATTACK = 12;
    private static final int END_FRAME_SIDE_ATTACK = 23;
    private static final int START_FRAME_BACK_ATTACK = 24;
    private static final int END_FRAME_BACK_ATTACK = 35;
    private static final int END_FRAME_FRONT_WALK = 3;
    private static final int START_FRAME_SIDE_WALK = 4;
    private static final int END_FRAME_SIDE_WALK = 7;
    private static final int START_FRAME_BACK_WALK = 8;
    private static final int END_FRAME_BACK_WALK = 11;
    private final AnimationChannel walkFront = new AnimationChannel("attackZombie.png", 6, WIDTH, HEIGHT, idleDuration, 0, 11);
    private final AnimationChannel walkSide = new AnimationChannel("attackZombie.png", 6, WIDTH, HEIGHT, idleDuration, 12, 23);
    private final AnimationChannel walkBack = new AnimationChannel("attackZombie.png", 6, WIDTH, HEIGHT, idleDuration, 24, 35);
    private final AnimationChannel idleFront = new AnimationChannel("attackZombie.png", 4, WIDTH, HEIGHT, walkDuration, 0, 3);
    private final AnimationChannel idleSide = new AnimationChannel("attackZombie.png", 4, WIDTH, HEIGHT, walkDuration, 4, 7);
    private final AnimationChannel idleBack = new AnimationChannel("attackZombie.png", 4, WIDTH, HEIGHT, walkDuration, 8, 11);
    private AnimatedTexture texture;

    public ZombieAnimationImpl() {
        texture = new AnimatedTexture(walkFront);
    }

    @Override
    protected void playAnimation(final AnimationType animationType, final MoveDirection direction) {
        switch (direction) {
            case UP:
                texture.loopAnimationChannel(walkBack);
                break;
            case DOWN:
                texture.loopAnimationChannel(walkFront);
                break;
            case LEFT:
                texture.loopAnimationChannel(walkSide);
                getEntity().setScaleX(-1);
                break;
            case RIGHT:
                texture.loopAnimationChannel(walkSide);
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
