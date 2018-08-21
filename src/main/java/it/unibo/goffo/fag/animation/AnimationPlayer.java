package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public interface AnimationPlayer {

        class Animation{
            private MoveDirection dir;
            private boolean mov;
            private boolean atk;

            Animation(MoveDirection direction, boolean moving, boolean attacking){
                dir = direction;
                mov = moving;
                atk = attacking;
            }
        }

        int width = 128;
        int height = 128;
        Duration walkDuration = Duration.millis(1200);
        Duration idleDuration = Duration.millis(2800);
        Duration attackDuration = Duration.millis(1200);

        Map<Animation, AnimationChannel> playerAnimations = new HashMap<Animation, AnimationChannel>();

        void PlayAnimation(MoveDirection direction, boolean moving, boolean attacking);
}
