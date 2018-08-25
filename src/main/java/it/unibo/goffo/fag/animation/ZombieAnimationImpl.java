package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

/**
 * Plays animations for the zombies
 */
public class ZombieAnimationImpl extends AbsAnimation {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initValues() {

        idleDuration = Duration.millis(1200);

        IdleAnimations.put(MoveDirection.DOWN, new AnimationChannel("attackZombie.png", 6, width, height, idleDuration, 0, 11));   //AttackFront
        IdleAnimations.put(MoveDirection.RIGHT, new AnimationChannel("attackZombie.png", 6, width, height, idleDuration, 12, 23)); //AttackSide
        IdleAnimations.put(MoveDirection.UP, new AnimationChannel("attackZombie.png", 6, width, height, idleDuration, 24, 35));    //AttackBack
        WalkAnimations.put(MoveDirection.DOWN, new AnimationChannel("walkZombie.png", 4, width, height, walkDuration, 0, 3));      //WalkFront
        WalkAnimations.put(MoveDirection.RIGHT, new AnimationChannel("walkZombie.png", 4, width, height, walkDuration, 4, 7));     //WalkSide
        WalkAnimations.put(MoveDirection.UP, new AnimationChannel("walkZombie.png", 4, width, height, walkDuration, 8, 11));       //WalkBack
    }

}
