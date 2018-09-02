package it.unibo.goffo.fag.animation;

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

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initValues() {
        idleAnimations.put(MoveDirection.DOWN, new AnimationChannel("attackZombie.png", FRAMES_PER_ROW_ATTACK, WIDTH, HEIGHT, idleDuration, 0, END_FRAME_FRONT_ATTACK));   //AttackFront
        idleAnimations.put(MoveDirection.RIGHT, new AnimationChannel("attackZombie.png", FRAMES_PER_ROW_ATTACK, WIDTH, HEIGHT, idleDuration, START_FRAME_SIDE_ATTACK, END_FRAME_SIDE_ATTACK)); //AttackSide
        idleAnimations.put(MoveDirection.UP, new AnimationChannel("attackZombie.png", FRAMES_PER_ROW_ATTACK, WIDTH, HEIGHT, idleDuration, START_FRAME_BACK_ATTACK, END_FRAME_BACK_ATTACK));    //AttackBack
        walkAnimations.put(MoveDirection.DOWN, new AnimationChannel("walkZombie.png", FRAMES_PER_ROW_WALK, WIDTH, HEIGHT, walkDuration, 0, END_FRAME_FRONT_WALK));      //WalkFront
        walkAnimations.put(MoveDirection.RIGHT, new AnimationChannel("walkZombie.png", FRAMES_PER_ROW_WALK, WIDTH, HEIGHT, walkDuration, START_FRAME_SIDE_WALK, END_FRAME_SIDE_WALK));     //WalkSide
        walkAnimations.put(MoveDirection.UP, new AnimationChannel("walkZombie.png", FRAMES_PER_ROW_WALK, WIDTH, HEIGHT, walkDuration, START_FRAME_BACK_WALK, END_FRAME_BACK_WALK));       //WalkBack
    }

}
