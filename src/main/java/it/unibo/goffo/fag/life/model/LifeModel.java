package it.unibo.goffo.fag.life.model;

/**
 * Life manager.
 * @param <T> Object where to store life data.
 */
public interface LifeModel<T> {
    /**
     * Obtain life value.
     * @return life amount value.
     */
    T getLife();

    /**
     * Set life value.
     * @param amount New life amount.
     */
    void setLife(T amount);
}
