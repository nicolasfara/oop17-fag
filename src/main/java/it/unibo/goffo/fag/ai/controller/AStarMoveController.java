package it.unibo.goffo.fag.ai.controller;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.concurrent.Async;
import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.PositionComponent;
import com.almasb.fxgl.extra.ai.pathfinding.AStarGrid;
import com.almasb.fxgl.extra.ai.pathfinding.AStarNode;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;
import javafx.geometry.Point2D;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static it.unibo.goffo.fag.FagUtils.BLOCK_SIZE;
import static it.unibo.goffo.fag.FagUtils.ZOMBIE_SIZE_X;
import static it.unibo.goffo.fag.FagUtils.ZOMBIE_SIZE_Y;

/**
 * Controller class for moving an Ai with A* logic.
 */
public class AStarMoveController extends Component implements MoveController {
    private final Queue<AStarNode> nodeList = new LinkedList<>();
    private PositionComponent position;
    private static final Logger LOGGER = Logger.get(AStarMoveController.class);
    private static final int TPF_MULTIPLIER = 50;

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
    @Override
    public void moveTo(final Point2D destination) {
        position = getEntity().getPositionComponent();

        if (position.getValue().equals(destination)) {
            LOGGER.info(getEntity().toString() + " is already in: " + destination);
            return;
        }

        final AStarGrid grid = ((FightAvengeGuerrillaApp) FXGL.getApp()).getGrid();

        final int startX = FXGLMath.round(position.getX() / BLOCK_SIZE);
        final int startY = FXGLMath.round(position.getY() / BLOCK_SIZE);
        final int targetX = FXGLMath.round((destination.getX() + ZOMBIE_SIZE_X) / BLOCK_SIZE);
        final int targetY = FXGLMath.round((destination.getY() + ZOMBIE_SIZE_Y) / BLOCK_SIZE);

        nodeList.clear();
        final Async<List<AStarNode>> getPathTask = FXGL.getApp().getExecutor().async(() -> {
            LOGGER.infof("AStart path finding at work", Thread.currentThread());
            return grid.getPath(startX, startY, targetX, targetY);
        });
        nodeList.addAll(getPathTask.await());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpdate(final double tpf) {
        if (nodeList.isEmpty()) {
            LOGGER.info("No node find in the list, no movement");
        }

        final double speed = tpf * TPF_MULTIPLIER;
        // No try/catch needed because we check empty queue before
        final AStarNode node = nodeList.remove();

        final int nextX = node.getX() * BLOCK_SIZE;
        final int nextY = node.getY() * BLOCK_SIZE;
        final double deltaX = nextX - position.getX();
        final double deltaY = nextY - position.getY();

        position.translateX(speed * Math.signum(deltaX));
        position.translateY(speed * Math.signum(deltaY));
    }
}
