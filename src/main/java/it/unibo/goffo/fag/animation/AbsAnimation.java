package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public abstract class AbsAnimation extends Component implements Animation{

    protected AnimatedTexture texture;


    protected static int width = 128;
    protected static int height = 128;
    protected static Duration walkDuration = Duration.millis(1200);
    protected static Duration idleDuration;

    protected static Map<MoveDirection, AnimationChannel> WalkAnimations = new HashMap<>();
    protected static Map<MoveDirection, AnimationChannel> IdleAnimations = new HashMap<>();

    /**
     * Initialize and populates the above fields with the values corresponding to the proper character
     */
    protected abstract void initValues();

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdded() {

        initValues();

        texture = new AnimatedTexture(IdleAnimations.get(MoveDirection.DOWN));
        getEntity().setView(texture);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void playWalkAnimation(MoveDirection direction) {
        if(direction == MoveDirection.LEFT){
            texture.loopAnimationChannel(WalkAnimations.get(MoveDirection.RIGHT));
            getEntity().getView().setScaleX(-1);
        }

        texture.loopAnimationChannel(WalkAnimations.get(direction));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void playIdleAnimation(MoveDirection direction) {
        if(direction == MoveDirection.LEFT){
            texture.loopAnimationChannel(IdleAnimations.get(MoveDirection.RIGHT));
            getEntity().getView().setScaleX(-1);
        }

        texture.loopAnimationChannel(IdleAnimations.get(direction));

    }
}
