package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import it.unibo.goffo.fag.movement.MoveDirection;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract animation.
 */
public abstract class AbstractAnimation extends Component implements Animation {

    private AnimatedTexture texture;
    protected static Map<MoveDirection, AnimationChannel> walkAnimations = new HashMap<>();
    protected static Map<MoveDirection, AnimationChannel> idleAnimations = new HashMap<>();

    /**
     * Initialize and populates the above fields with the values corresponding to the proper character.
     */
    protected abstract void initValues();

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdded() {
        initValues();
        texture = new AnimatedTexture(idleAnimations.get(MoveDirection.DOWN));
        getEntity().setView(texture);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void playWalkAnimation(final MoveDirection direction) {
        playAnimation(walkAnimations, direction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void playIdleAnimation(final MoveDirection direction) {
        playAnimation(idleAnimations, direction);
    }

    private void playAnimation(final Map<MoveDirection, AnimationChannel> animation, final MoveDirection direction) {
        if (direction == MoveDirection.LEFT) {
            texture.loopAnimationChannel(animation.get(MoveDirection.RIGHT));
            getEntity().getView().setScaleX(-1);
        }
        texture.loopAnimationChannel(idleAnimations.get(direction));
    }
}
