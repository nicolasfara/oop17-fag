package it.unibo.goffo.fag.collision;

import it.unibo.goffo.fag.exceptions.GameOverException;

/**
 * Interface used to manage collisions between two entities.
 * @param <T> First entity
 * @param <U> Second entity
 */
public interface Collision<T, U> {

    /**
     * {@inheritDoc}
     */
    void onCollision(T e1, U e2) throws GameOverException;
}
