package it.unibo.goffo.fag.entities.life.model;

import it.unibo.goffo.fag.exceptions.LifeIsOverException;

/**
 * Life amount storage.
 * @param <T> Data type used to store life amount.
 */
public interface LifeModel<T> {
    /**
     * Obtain life value.
     * @return Life amount value.
     */
    T getLife();

    /**
     * Set life value.
     * @param amount New life amount.
     * @throws LifeIsOverException if life is over (under a minimum value).
     */
    void setLife(T amount) throws LifeIsOverException;
}
