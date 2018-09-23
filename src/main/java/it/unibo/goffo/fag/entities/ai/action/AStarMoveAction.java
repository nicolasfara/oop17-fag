package it.unibo.goffo.fag.entities.ai.action;

import com.almasb.fxgl.ai.GoalAction;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.concurrent.Async;
import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.PositionComponent;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;
import it.unibo.goffo.fag.entities.ai.controller.AStarMoveController;


/**
 * Action to be taken by the AI for enemies.
 */
public class AStarMoveAction extends GoalAction {

    private static final Logger LOGGER = Logger.get(AStarMoveAction.class);

    /**
     * Constructor call. Simply call GoalAction constructor.
     */
    public AStarMoveAction() {
        super("AStar");

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        final PositionComponent positionComponent = getEntity().getPositionComponent();
        LOGGER.info("Start method AStartMoveAction, entity start at: " + positionComponent.toString());

        final Entity player = FXGL.<FightAvengeGuerrillaApp>getAppCast().getPlayer();

        final Async<Void> moving = FXGL.getExecutor().async(() -> getEntity().getComponent(AStarMoveController.class).moveTo(player.getPositionComponent().getValue()));

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
