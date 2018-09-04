package it.unibo.goffo.fag.rotation;

/**
 * This class is used to rotate an entity.
 */
public class EntityRotation extends AbstractRotation {

    /**
     *
     */
    public EntityRotation () {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void rotate(final double angle) {
        getEntity().setRotation(angle);
    }
}
