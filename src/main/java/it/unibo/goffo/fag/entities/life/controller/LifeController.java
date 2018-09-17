package it.unibo.goffo.fag.entities.life.controller;

import it.unibo.goffo.fag.exceptions.CharacterDiesException;

/**
 * Life manager for a {@link Character} entity.
 * @param <T> Type of life component.
 */
public interface LifeController<T> {
    /**
     * Get current life value.
     * @return Life amount.
     */
    T getLife();

    /**
     * Set life amount to a given value.
     * @param amount Amount of life replacing current life value.
     */
    void setLife(T amount);

    /**
     * Increase life amount of a given value.
     * @param amount Amount of life to be added to current life value.
     */
    void increaseOf(T amount);

    /**
     * Decrease life amount of a given value.
     * @param amount Amount of life to be subtracted to current life value.
     * @throws CharacterDiesException If life amount goes under a minimum value: indicates that Character is dead.
     */
    void decreaseOf(T amount) throws CharacterDiesException;
}
