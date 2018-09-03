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
    private final Duration walkDuration = Duration.millis(IDLE_DURATION);
    private static final int WIDTH = 128;
    private static final int HEIGHT = 128;
    private static final int FRAMES_PER_ROW = 6;
    private static final int END_WALK_FRONT = 11;
    private static final int START_WALK_SIDE = 12;
    private static final int END_WALK_SIDE = 23;
    private static final int START_WALK_BACK = 24;
    private static final int END_WALK_BACK = 35;
    private final AnimationChannel walkFront = new AnimationChannel("attackZombie.png", FRAMES_PER_ROW, WIDTH, HEIGHT, walkDuration, 0, END_WALK_FRONT);
    private final AnimationChannel walkSide = new AnimationChannel("attackZombie.png", FRAMES_PER_ROW, WIDTH, HEIGHT, walkDuration, START_WALK_SIDE, END_WALK_SIDE);
    private final AnimationChannel walkBack = new AnimationChannel("attackZombie.png", FRAMES_PER_ROW, WIDTH, HEIGHT, walkDuration, START_WALK_BACK, END_WALK_BACK);
    private AnimatedTexture texture;

    /**
     * Initialize the texture for animation.
     */
    public ZombieAnimationImpl() {
        texture = new AnimatedTexture(walkFront);
    }

    /**
     * {@inheritDoc}
     */
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
