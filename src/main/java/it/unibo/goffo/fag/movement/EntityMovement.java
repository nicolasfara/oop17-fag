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
     *
     * @param speed
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
            blocks = FXGL.<FightAvengeGuerrillaApp>getAppCast().getGrid().getNodes().stream().filter(e -> e.getState().equals(NodeState.NOT_WALKABLE)).collect(Collectors.toList());
        }

        velocity.set(deltaX, deltaY);
        final int length = FXGLMath.roundPositive(velocity.length());
        velocity.normalizeLocal();

        for (int i = 0; i < length; i++) {
            getEntity().getPositionComponent().translate(velocity.x, velocity.y);
            boolean collision = false;
            for (int j = 0; j < blocks.size(); j++) {
                if (blocks.get(j).getX() == getEntity().getPositionComponent().getX() && blocks.get(j).getY() == getEntity().getPositionComponent().getY()
                        || blocks.get(j).getX() == getEntity().getPositionComponent().getX() + BLOCK_SIZE && blocks.get(j).getY() == getEntity().getPositionComponent().getY()
                        || blocks.get(j).getX() == getEntity().getPositionComponent().getX() && blocks.get(j).getY() == getEntity().getPositionComponent().getY() + BLOCK_SIZE + BLOCK_SIZE / 2) {
                    collision = true;
                    break;
                }
            }

            if (collision) {
                getEntity().getPositionComponent().translate(-velocity.x, -velocity.y);
                break;
            }
        }
        //getEntity().translate(deltaX, deltaY);
    }
}
