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
    private static final int FRAMES_PER_ROW = 4;
    private static final String ANIMATION_FILENAME = "walkZombie.png";
    private final AnimationChannel walkFront = new AnimationChannel(ANIMATION_FILENAME, FRAMES_PER_ROW, WIDTH, HEIGHT, walkDuration, 0, 3);
    private final AnimationChannel walkSide = new AnimationChannel(ANIMATION_FILENAME, FRAMES_PER_ROW, WIDTH, HEIGHT, walkDuration, 4, 7);
    private final AnimationChannel walkBack = new AnimationChannel(ANIMATION_FILENAME, FRAMES_PER_ROW, WIDTH, HEIGHT, walkDuration, 8, 11);
    private final AnimatedTexture texture;

    /**
     * Initialize the texture for animation.
     */
    public ZombieAnimationImpl() {
        super();
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
                getEntity().setScaleX(-0.5);
                break;
            case RIGHT:
                texture.loopAnimationChannel(walkSide);
                getEntity().setScaleX(0.5);
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
