package it.unibo.goffo.fag.movement;

import com.almasb.fxgl.entity.component.Component;

/**
 * Abstract class implement basic entity movement.
 */
public abstract class AbstractMovement extends Component implements Movement {

    private float speed;
    private static final int SPEED_FACTOR = 5;

    /**
     * Default constructor (Access: package protected).
     */
    AbstractMovement() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveUp() {
        move(0, -SPEED_FACTOR * speed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveDown() {
        move(0, SPEED_FACTOR * speed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveLeft() {
        move(-SPEED_FACTOR * speed, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveRight() {
        move(SPEED_FACTOR * speed, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSpeed(final float newSpeed) {
        this.speed = newSpeed;
    }

    /**
     * This method must be used to move the entity to a delta position.
     * Plus sign to {@code dx} move the entity to the right of the monitor; minus sign move to the left the entity.
     * Plus sign to {@code dy} move the entity dow to the screen; minus sign move to the top the entity.
     * @param deltaX delta movement to move the entity on left or right.
     * @param deltaY delta movement to move on top or bottom the entity.
     */
    protected abstract void move(float deltaX, float deltaY);

}
