package it.unibo.goffo.fag.ai.movement;

import com.almasb.fxgl.entity.component.Component;

/**
 * Abstract class implement basic entity movement.
 */
public abstract class AbstractMovement extends Component implements Movement {

    private double speed;

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveUp() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveDown() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveLeft() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveRight() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSpeed(final double newSpeed) {

    }

    /**
     * This method must be used to move the entity to a delta position.
     * Plus sign to {@code dx} move the entity to the right of the monitor; minus sign move to the left the entity.
     * Plus sign to {@code dy} move the entity dow to the screen; minus sign move to the top the entity.
     * @param deltaX delta movement to move the entity on left or right.
     * @param deltaY delta movement to move on top or bottom the entity.
     */
    abstract void move(float deltaX, float deltaY);

}
