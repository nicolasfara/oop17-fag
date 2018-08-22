package it.unibo.goffo.fag.collision;

import com.almasb.fxgl.entity.Entity;

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
     * @param firstEntity First entity of the collision
     * @param secondEntity Second entity of the collision
     */
    protected abstract void onCollision(Entity firstEntity, Entity secondEntity);
}
