package it.unibo.goffo.fag.life.model;

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
     */
    void setLife(T amount);
}
