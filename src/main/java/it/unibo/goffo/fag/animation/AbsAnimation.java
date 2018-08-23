package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.texture.AnimationChannel;

public abstract class AbsAnimation implements Animation{

    public abstract AnimationChannel GetAnimation();
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void PlayWalkAnimation(MoveDirection direction) {

    }
}
