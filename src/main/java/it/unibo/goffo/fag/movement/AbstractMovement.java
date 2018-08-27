package it.unibo.goffo.fag.movement;

import com.almasb.fxgl.entity.component.Component;
import io.reactivex.subjects.PublishSubject;

/**
 * Abstract class implement basic entity movement.
 */
public abstract class AbstractMovement extends Component implements Movement {

    private float speed;
    private static final int SPEED_FACTOR = 1;
    private final PublishSubject<MoveDirection> observable = PublishSubject.create();

    /**
     * Default constructor (Access: package protected).
     */
    AbstractMovement(final float speed) {
        super();
        this.speed = speed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveUp() {
        move(0, -SPEED_FACTOR * speed);
        observable.onNext(MoveDirection.UP);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveDown() {
        move(0, SPEED_FACTOR * speed);
        observable.onNext(MoveDirection.DOWN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveLeft() {
        move(-SPEED_FACTOR * speed, 0);
        observable.onNext(MoveDirection.LEFT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveRight() {
        move(SPEED_FACTOR * speed, 0);
        observable.onNext(MoveDirection.RIGHT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSpeed(final float newSpeed) {
        this.speed = newSpeed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PublishSubject<MoveDirection> getObservable() {
        return observable;
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