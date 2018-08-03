package it.unibo.goffo.fag.ai.action;

import com.almasb.fxgl.ai.GoalAction;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.extra.ai.pathfinding.NodeState;
import com.almasb.fxgl.time.LocalTimer;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;
import it.unibo.goffo.fag.ai.controller.MoveDirection;
import it.unibo.goffo.fag.ai.controller.SimpleMoveController;
import javafx.util.Duration;

import java.util.Comparator;

import static it.unibo.goffo.fag.FagUtils.BLOCK_SIZE;

/**
 * Random movement for a Basic zombie.
 */
public class RandomMoveAction extends GoalAction {

    private LocalTimer timer = FXGL.newLocalTimer();
    private static final int DURATION_STEP = 2;

    /**
     * Default constructor.
     */
    public RandomMoveAction() {
        super(RandomMoveAction.class.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpdate(double v) {
        //nothing here
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean reachedGoal() {
        //Simulate the next step waiting for a time before move the entity to another position
        return timer.elapsed(Duration.seconds(DURATION_STEP));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        timer.capture();
        //Get a random movement
        getEntity().getComponent(SimpleMoveController.class).setMoveDirection(FXGLMath.random(MoveDirection.values()).get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void end() {
        FXGL.<FightAvengeGuerrillaApp>getAppCast()
                .getGrid()
                .getNodes()
                .stream()
                .filter(node -> node.getState() == NodeState.WALKABLE)
                .min(Comparator.comparingDouble(node -> getEntity().getPosition().distance(node.getX() * BLOCK_SIZE, node.getY() * BLOCK_SIZE)))
                .ifPresent(node -> getEntity().setPosition(node.getX() * BLOCK_SIZE, node.getY() * BLOCK_SIZE));
    }
}
