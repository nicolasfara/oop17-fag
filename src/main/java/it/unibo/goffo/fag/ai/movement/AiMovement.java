package it.unibo.goffo.fag.ai.movement;

import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.components.PositionComponent;

/**
 * This class is used to assign to an AI entity a movement.
 */
public class AiMovement extends AbstractMovement {

    private static final Logger LOG = Logger.get("FXGL");
    private Vec2 velocityVector = new Vec2();
    private PositionComponent positionComponent;

    /**
     * Default constructor used to assign a {@code PositionalComponent} to the movement.
     * @param positionComponent Component used for the moving.
     */
    public AiMovement(final PositionComponent positionComponent) {
        this.positionComponent = positionComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void move(final float dx, final float dy) {
        if (!positionComponent.getEntity().isActive()) {
            LOG.warning("The entity " + getEntity().toString() + "is not enable. Unable to move the entity");
            return;
        }
        LOG.info("Moving the entity: " + getEntity().toString());
        velocityVector.set(dx, dy);
        int vectorLength = FXGLMath.roundPositive(velocityVector.length());
        velocityVector.normalizeLocal();

        for (int i = 0; i < vectorLength; i++) {
            positionComponent.translate(velocityVector.x, velocityVector.y);
        }
    }
}
