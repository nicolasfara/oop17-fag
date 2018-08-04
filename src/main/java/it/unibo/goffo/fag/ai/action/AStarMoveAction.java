package it.unibo.goffo.fag.ai.action;


import com.almasb.fxgl.ai.GoalAction;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.concurrent.Async;
import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.PositionComponent;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;
import it.unibo.goffo.fag.ai.controller.AStarMoveController;
import javafx.geometry.Point2D;

import static it.unibo.goffo.fag.FagUtils.BLOCK_SIZE;
import static it.unibo.goffo.fag.FagUtils.PLAYER_SIZE_X;
import static it.unibo.goffo.fag.FagUtils.PLAYER_SIZE_Y;


/**
 * Action to be taken by the AI for enemies.
 */
public class AStarMoveAction extends GoalAction {

    private int targetX;
    private int targetY;
    private static final Logger LOGGER = Logger.get(AStarMoveAction.class);

    /**
     * Constructor call. Simply call GoalAction constructor.
     */
    public AStarMoveAction() {
        super(AStarMoveAction.class.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        final PositionComponent positionComponent = getEntity().getPositionComponent();
        LOGGER.info("Start method AStartMoveAction, entity start at: " + positionComponent.toString());

        final Entity player = ((FightAvengeGuerrillaApp) FXGL.getApp()).getPlayer();

        targetX = FXGLMath.round((player.getX() + PLAYER_SIZE_X) / BLOCK_SIZE);
        targetY = FXGLMath.round((player.getX() + PLAYER_SIZE_Y) / BLOCK_SIZE);

        Async<Void> moving = FXGL.getExecutor().async(() -> {
            final Point2D destPoint = new Point2D(targetX * BLOCK_SIZE, targetY * BLOCK_SIZE);
            getEntity().getComponent(AStarMoveController.class).moveTo(destPoint);
        });

        moving.await();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpdate(final double v) {
        //nothing here
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean reachedGoal() {
        return getEntity().getComponent(AStarMoveController.class).isDone();
    }
}
