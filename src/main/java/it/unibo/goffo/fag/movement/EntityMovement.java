package it.unibo.goffo.fag.movement;

/**
 * This class is used to move an entity.
 */
public class EntityMovement extends AbstractMovement {

    /**
     *
     */
    public EntityMovement(final float speed) {
        super(speed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void move(final float deltaX, final float deltaY) {
        getEntity().translate(deltaX, deltaY);
    }

}
