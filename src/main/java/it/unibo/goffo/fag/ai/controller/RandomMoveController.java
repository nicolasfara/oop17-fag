package it.unibo.goffo.fag.ai.controller;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import it.unibo.goffo.fag.ai.movement.AiMovement;
import it.unibo.goffo.fag.ai.movement.Movement;

import java.util.Arrays;
import java.util.List;

/**
 * This class reply the behaviour of a random movement for a basic "AI" to be attached to an entity.
 */
public class RandomMoveController extends Component implements MoveController {

    private MoveDirection moveDirection;
    private Movement movement;
    private static final int TPF_MULTIPLIER = 30;
    private static final List<? extends MoveDirection> DIRECTION_LIST = Arrays.asList(MoveDirection.values());

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMoveDirection(final MoveDirection moveDirection) {
        this.moveDirection = moveDirection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdded() {
        movement = new AiMovement(getEntity().getPositionComponent());
        moveDirection = getRandomMoveDirection(DIRECTION_LIST);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpdate(final double tpf) {
        super.onUpdate(tpf);
        movement.setSpeed((float) tpf * TPF_MULTIPLIER);
        moveDirection = getRandomMoveDirection(DIRECTION_LIST);

        switch (moveDirection) {
            case UP:
                movement.moveUp();
                break;
            case DOWN:
                movement.moveDown();
                break;
            case LEFT:
                movement.moveLeft();
                break;
            case RIGHT:
                movement.moveRight();
                break;
                default:
                    throw new IllegalStateException("Invalid direction");
        }
    }

    private MoveDirection getRandomMoveDirection(final List<? extends MoveDirection> directionList) {
        return FXGLMath.random(directionList).get();
    }
}
