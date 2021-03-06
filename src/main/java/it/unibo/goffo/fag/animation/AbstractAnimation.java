package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.entity.component.Component;
import it.unibo.goffo.fag.entities.movement.MoveDirection;

/**
 * Abstract animation.
 */
public abstract class AbstractAnimation extends Component implements Animation {

    /**
     * {@inheritDoc}
     */
    @Override
    public void playWalkAnimation(final MoveDirection direction) {
        playAnimation(AnimationType.WALKING, direction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void playIdleAnimation(final MoveDirection direction) {
        playAnimation(AnimationType.IDLE, direction);
    }

    /**
     * Play an animation with animation type and direction.
     * @param animationType animation type.
     * @param direction direction.
     */
    protected abstract void playAnimation(AnimationType animationType, MoveDirection direction);
}
