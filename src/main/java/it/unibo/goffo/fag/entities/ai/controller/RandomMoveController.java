package it.unibo.goffo.fag.entities.ai.controller;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.time.LocalTimer;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;
import it.unibo.goffo.fag.animation.ZombieAnimationImpl;
import it.unibo.goffo.fag.entities.movement.EntityMovement;
import it.unibo.goffo.fag.entities.movement.MoveDirection;
import javafx.util.Duration;

/**
 * Random behaviour for the entity.
 */
public class RandomMoveController extends Component {

    private MoveDirection moveDirection;
    private final LocalTimer timer = FXGL.newLocalTimer();

    private static final Logger LOGGER = Logger.get(RandomMoveController.class);

    /**
     *
     */
    public RandomMoveController() {
        super();
        moveDirection = MoveDirection.LEFT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdded() {
        timer.capture();
        getEntity().getComponentOptional(ZombieAnimationImpl.class).ifPresent(anim -> anim.playWalkAnimation(moveDirection));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpdate(final double tpf) {
        if (timer.elapsed(Duration.seconds(2))) {
            moveDirection = FXGLMath.random(MoveDirection.values()).get();
            getEntity().getComponentOptional(ZombieAnimationImpl.class).ifPresent(anim -> anim.playWalkAnimation(moveDirection));
            LOGGER.info("Change direction");
            timer.capture();
        }
        switch (moveDirection) {
            case UP:
                getEntity().getComponentOptional(EntityMovement.class).ifPresent(EntityMovement::moveUp);
                break;
            case DOWN:
                getEntity().getComponentOptional(EntityMovement.class).ifPresent(EntityMovement::moveDown);
                break;
            case LEFT:
                getEntity().getComponentOptional(EntityMovement.class).ifPresent(EntityMovement::moveLeft);
                break;
            case RIGHT:
                getEntity().getComponentOptional(EntityMovement.class).ifPresent(EntityMovement::moveRight);
                break;
                default:
                    break;
        }
    }

    /**
     * If the entity colliding with the player, this method return te colliding status.
     * @return true if the entity collide with the player, false otherwise.
     */
    public boolean collidingWithPlayer() {
        return FXGL.<FightAvengeGuerrillaApp>getAppCast().getPlayer().isColliding(getEntity());
    }
}
