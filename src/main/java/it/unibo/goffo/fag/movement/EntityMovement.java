package it.unibo.goffo.fag.movement;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.extra.ai.pathfinding.AStarNode;
import com.almasb.fxgl.extra.ai.pathfinding.NodeState;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;

import java.util.List;
import java.util.stream.Collectors;

import static it.unibo.goffo.fag.FagUtils.BLOCK_SIZE;

/**
 * This class is used to move an entity.
 */
public class EntityMovement extends AbstractMovement {

    private List<AStarNode> blocks;
    private final Vec2 velocity = new Vec2();
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
            blocks = FXGL.<FightAvengeGuerrillaApp>getAppCast().getGrid().getNodes().stream()
                    .filter(e -> e.getState().equals(NodeState.NOT_WALKABLE))
                    .collect(Collectors.toList());
        }

        velocity.set(deltaX, deltaY);
        final int length = FXGLMath.roundPositive(velocity.length());
        velocity.normalizeLocal();

        for (int i = 0; i < length; i++) {
            getEntity().getPositionComponent().translate(velocity.x, velocity.y);
            boolean collision = false;

            for (final AStarNode block : blocks) {
                if (block.getX() == getEntity().getPositionComponent().getX() && block.getY() == getEntity().getPositionComponent().getY()
                        || block.getX() == getEntity().getPositionComponent().getX() + BLOCK_SIZE && block.getY() == getEntity().getPositionComponent().getY()
                        || block.getX() == getEntity().getPositionComponent().getX() && block.getY() == getEntity().getPositionComponent().getY() + BLOCK_SIZE + (float) BLOCK_SIZE / 2) {
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
