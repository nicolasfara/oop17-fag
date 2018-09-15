package it.unibo.goffo.fag.movement;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.Entity;
import it.unibo.goffo.fag.entities.FagType;

import java.util.List;

/**
 * This class is used to move an entity.
 */
public class EntityMovement extends AbstractMovement {

    private List<Entity> blocks;
    private final Vec2 velocity = new Vec2();
    private static final double TOLERANCE = 0.00001;
    private static final Logger LOGGER = Logger.get(EntityMovement.class);

    /**
     * Constructor, build a Movement component with velocity.
     * @param speed the speed must have the entity.
     */
    public EntityMovement(final float speed) {
        super(speed);
        LOGGER.info("Speed: " + speed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void move(final float deltaX, final float deltaY) {
        if (!getEntity().isActive()) {
            return;
        }

        if (blocks == null) {
            blocks = FXGL.getApp().getGameWorld().getEntitiesByType(FagType.WALL);
        }
        velocity.set(deltaX, deltaY);
        final int length = FXGLMath.roundPositive(velocity.length());
        velocity.normalizeLocal();

        for (int i = 0; i < length; i++) {
            getEntity().getPositionComponent().translate(velocity.x, velocity.y);
            boolean collision = false;
            for (final Entity wall : blocks) {
                if (wall.getBoundingBoxComponent().isCollidingWith(getEntity().getBoundingBoxComponent())) {
                    collision = true;
                    break;
                }
            }

            if (collision) {
                getEntity().getPositionComponent().translate(-velocity.x, -velocity.y);
                break;
            }
        }
    }
}
