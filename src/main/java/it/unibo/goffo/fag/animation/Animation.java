package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

/**
 * Interface that allows to play animations
 */
public interface Animation {

        MoveDirection dir = null;

        int width = 128;
        int height = 128;
        Duration walkDuration = Duration.millis(1200);
        Duration idleDuration = Duration.millis(2800);
        Duration attackDuration = Duration.millis(1200);

        Map<Animation, AnimationChannel> playerAnimations = new HashMap<Animation, AnimationChannel>();

    /**
     * Plays the walking animation corresponding to a direction
     *
     * @param direction direction that the character is facing
     */
    void PlayWalkAnimation(MoveDirection direction);
}
