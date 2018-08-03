package it.unibo.goffo.fag.animation;

import com.almasb.fxgl.animation.Animation;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

public class FagControl extends Component {

    private int speed = 0;
    private static final int width = 128;
    private static final int height = 128;

    private AnimatedTexture texture;
    private AnimationChannel animIdle, animWalk, animWalk_L;

    public FagControl() {
        animWalk = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(2000),4,7);
        animIdle = new AnimationChannel("fagsheet.png", 4, width, height, Duration.millis(2800),20,23);

        texture = new AnimatedTexture(animIdle);
    }

    @Override
    public void onAdded() {
        entity.setView(texture);
    }

    @Override
    public void onUpdate(double tpf) {
        entity.translateX(speed * tpf);

        if (speed != 0) {

            if (texture.getAnimationChannel() == animIdle) {
                texture.loopAnimationChannel(animWalk);
            }

            speed = (int) (speed * 0.9);

            if (FXGLMath.abs(speed) < 1) {
                speed = 0;
                texture.loopAnimationChannel(animIdle);
            }
        }
    }

    public void moveRight() {
        speed = 40;

        getEntity().setScaleX(1);
    }

    public void moveLeft() {
        speed = -40;

        getEntity().setScaleX(-1);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
