package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

import java.util.List;

public class AnimationPlayer {

    private List<AnimationChannel> playerAnimationList;
    private List<AnimationChannel> ZombieAnimationList;
    private static final int width = 128;
    private static final int height = 128;
    private static final Duration walkDuration = Duration.millis(1200);
    private static final Duration idleDuration = Duration.millis(2800);

    public void AnimationPlayer() {
        playerAnimationList.add(new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 0, 3));     // WalkDown
        playerAnimationList.add(new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 4, 7));     // WalkRight
        playerAnimationList.add(new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 8, 11));   // WalkLeft
        playerAnimationList.add(new AnimationChannel("fagsheet.png", 4, width, height, walkDuration, 12, 15)); // WalkUp
        playerAnimationList.add(new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 16, 19)); // IdleDown
        playerAnimationList.add(new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 20, 23)); // IdleRight
        playerAnimationList.add(new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 24, 27)); // IdleLeft
        playerAnimationList.add(new AnimationChannel("fagsheet.png", 4, width, height, idleDuration, 28, 31)); // IdleUp
        playerAnimationList.add(new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 0, 3));    // IdleShootFront
        playerAnimationList.add(new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 4, 7));    // IdleShootSide
        playerAnimationList.add(new AnimationChannel("shootFag.png", 4, width, height, idleDuration, 8, 11));   // IdleShootBack
        playerAnimationList.add(new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 12, 15));  //WalkShootFront
        playerAnimationList.add(new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 16, 1));   //WalkShootSide
        playerAnimationList.add(new AnimationChannel("shootFag.png", 4, width, height, walkDuration, 20, 2));   //WalkShootBack
    }
}