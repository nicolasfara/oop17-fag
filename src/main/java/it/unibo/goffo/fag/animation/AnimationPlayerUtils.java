package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class AnimationPlayerUtils {

    private class Animation{
        private MoveDirection dir;
        private boolean mov;
        private boolean atk;

        private Animation(MoveDirection direction, boolean moving, boolean attacking){
            dir = direction;
            mov = moving;
            atk = attacking;
        }
    }

    private Map<Animation, AnimationChannel> playerAnimations;
    private Map<Animation, AnimationChannel> zombieAnimations;
    private static final int width = 128;
    private static final int height = 128;
    private static final Duration walkDuration = Duration.millis(1200);
    private static final Duration idleDuration = Duration.millis(2800);
    private static final Duration attackDuration = Duration.millis(1200);

    public void AnimationPlayerUtils() {
        playerAnimations = new HashMap<Animation, AnimationChannel>();
        zombieAnimations = new HashMap<Animation, AnimationChannel>();

        playerAnimations.put(new Animation(MoveDirection.DOWN, true, false), new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 0, 3));        // WalkDown
        playerAnimations.put(new Animation(MoveDirection.RIGHT, true, false), new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 4, 7));        // WalkRight
        playerAnimations.put(new Animation(MoveDirection.LEFT, true, false), new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 8, 11));       // WalkLeft
        playerAnimations.put(new Animation(MoveDirection.UP, true, false), new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 12, 15));      // WalkUp
        playerAnimations.put(new Animation(MoveDirection.DOWN, false, false), new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 16, 19));      // IdleDown
        playerAnimations.put(new Animation(MoveDirection.RIGHT, false, false), new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 20, 23));      // IdleRight
        playerAnimations.put(new Animation(MoveDirection.LEFT, false, false), new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 24, 27));      // IdleLeft
        playerAnimations.put(new Animation(MoveDirection.UP, false, false), new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 28, 31));      // IdleUp
        playerAnimations.put(new Animation(MoveDirection.DOWN, false, true), new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 0, 3));        // IdleShootFront
        playerAnimations.put(new Animation(MoveDirection.RIGHT, false, true), new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 4, 7));        // IdleShootSide
        playerAnimations.put(new Animation(MoveDirection.UP, false, true), new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 8, 11));       // IdleShootBack
        playerAnimations.put(new Animation(MoveDirection.DOWN, true, true), new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 12, 15));      //WalkShootFront
        playerAnimations.put(new Animation(MoveDirection.RIGHT, true, true), new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 16, 1));       //WalkShootSide
        playerAnimations.put(new Animation(MoveDirection.UP, true, true), new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 20, 2));       //WalkShootBack

        //zombieAnimations.add(new AnimationChannel("attackiZombie.png", 6, width, height, attackDuration, 0, 11));    //AttackFront
        //zombieAnimations.add(new AnimationChannel("attackiZombie.png", 6, width, height, attackDuration, 12, 23));   //AttackSide
        //zombieAnimations.add(new AnimationChannel("attackiZombie.png", 6, width, height, attackDuration, 24, 35));   //AttackBack
        //zombieAnimations.add(new AnimationChannel("walkZombie.png", 4, width, height, walkDuration, 0, 3));          //WalkFront
        //zombieAnimations.add(new AnimationChannel("walkZombie.png", 4, width, height, walkDuration, 4, 7));          //WalkSide
        //zombieAnimations.add(new AnimationChannel("walkZombie.png", 4, width, height, walkDuration, 8, 11));         //WalkBack
    }

    public void PlayAnimation(){}

}