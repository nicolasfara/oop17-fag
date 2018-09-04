package it.unibo.goffo.fag.rotation;

import com.almasb.fxgl.entity.component.Component;

/**
 * Abstract class implement basic entity movement.
 */
public abstract class AbstractRotation extends Component implements Rotation {

    private final double FACE_UP = 0.0;
    private final double FACE_DOWN = 180.0;
    private final double FACE_LEFT = -90.0;
    private final double FACE_RIGHT = 90.0;
    /**
     * Default constructor (Access: package protected).
     */
    AbstractRotation() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rotateUp() {
        rotate(FACE_UP);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rotateDown() {
        rotate(FACE_DOWN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rotateLeft() {
        rotate(FACE_LEFT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rotateRight() {
        rotate(FACE_RIGHT);
    }

    /**
     * This method must be used to rotate the entity.
     * @param angle set the angle rotation of the entity.
     */
    protected abstract void rotate(double angle);
}
