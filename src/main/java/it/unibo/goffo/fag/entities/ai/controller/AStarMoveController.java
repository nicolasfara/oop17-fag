package it.unibo.goffo.fag.entities.ai.controller;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.concurrent.Async;
import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.PositionComponent;
import com.almasb.fxgl.extra.ai.pathfinding.AStarGrid;
import com.almasb.fxgl.extra.ai.pathfinding.AStarNode;
import it.unibo.goffo.fag.FagUtils;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;
import it.unibo.goffo.fag.entities.Zombie;
import it.unibo.goffo.fag.entities.movement.EntityMovement;
import it.unibo.goffo.fag.entities.movement.MoveDirection;
import javafx.geometry.Point2D;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Controller class for moving an Ai with A* logic.
 */
public class AStarMoveController extends Component implements MoveController {
    private final Queue<AStarNode> nodeList = new LinkedList<>();
    private PositionComponent position;
    private final AStarGrid grid = ((FightAvengeGuerrillaApp) FXGL.getApp()).getGrid();
    private static final Logger LOGGER = Logger.get(AStarMoveController.class);
    private static final int TPF_MULTIPLIER = 70;
    private Zombie zombie;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDone() {
        return nodeList.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("PMD.AvoidCatchingNPE") //Motivation: NPE is thrown inside the library used. I cannot fix it in my code
    @Override
    public void moveTo(final Point2D destination) {
        position = getEntity().getPositionComponent();

        if (getEntity().getPosition().equals(destination)) {
            LOGGER.info(getEntity().toString() + " is already in: " + destination);
            return;
        }

        final int startX = FXGLMath.round(position.getX() / FagUtils.TILE_SIZE);
        final int startY = FXGLMath.round(position.getY() / FagUtils.TILE_SIZE);
        final int targetX = FXGLMath.round((destination.getX() + FagUtils.ZOMBIE_SIZE_X) / FagUtils.TILE_SIZE);
        final int targetY = FXGLMath.round((destination.getY() + FagUtils.ZOMBIE_SIZE_Y) / FagUtils.TILE_SIZE);

        nodeList.clear();
        final Async<List<AStarNode>> getPathTask = FXGL.getApp().getExecutor().async(() -> {
            LOGGER.infof("AStart path finding at work", Thread.currentThread());
            try {
                return grid.getPath(startX, startY, targetX, targetY);
            } catch (NullPointerException ex) {
                return Collections.emptyList();
            }
        });
        nodeList.addAll(getPathTask.await());
        getEntity().getComponentOptional(EntityMovement.class).ifPresent(EntityMovement::resume);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdded() {
        super.onAdded();
        zombie = (Zombie) getEntity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpdate(final double tpf) {
        if (nodeList.isEmpty()) {
            LOGGER.info("No node find in the list, no movement");
            return;
        }

        final double speed = tpf * TPF_MULTIPLIER;
        // No try/catch needed because we check empty queue before
        final AStarNode node = nodeList.remove();

        final int nextX = node.getX() * FagUtils.TILE_SIZE;
        final int nextY = node.getY() * FagUtils.TILE_SIZE;
        final double deltaX = nextX - position.getX();
        final double deltaY = nextY - position.getY();

        if (deltaX > 0) {
            zombie.playWalkAnimation(MoveDirection.RIGHT);
        } else if (deltaX < 0) {
            zombie.playWalkAnimation(MoveDirection.LEFT);
        }

        if (deltaY > 0) {
            zombie.playWalkAnimation(MoveDirection.DOWN);
        } else if (deltaY < 0) {
            zombie.playWalkAnimation(MoveDirection.UP);
        }

        if (Math.abs(deltaX) <= speed) {
            getEntity().getComponentOptional(EntityMovement.class).ifPresent(c -> c.setX(nextX));
        } else {
            getEntity().getComponentOptional(EntityMovement.class).ifPresent(e -> e.translateX(speed * Math.signum(deltaX)));
        }

        if (Math.abs(deltaY) <= speed) {
            getEntity().getComponentOptional(EntityMovement.class).ifPresent(c -> c.setY(nextY));
        } else {
            getEntity().getComponentOptional(EntityMovement.class).ifPresent(e -> e.translateY(speed * Math.signum(deltaY)));
        }

        if (nodeList.isEmpty()) {
            getEntity().getComponentOptional(EntityMovement.class).ifPresent(EntityMovement::pause);
        }
    }
}
