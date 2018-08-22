package it.unibo.goffo.fag.collision;


/**
 * Abstract class implement basic collision.
 */
public abstract class AbstractCollision implements Collision {

    /**
     *
     */
    AbstractCollision() { super(); }

    /**
     *
     *
     */
    @Override
    protected abstract void onCollision();
}
