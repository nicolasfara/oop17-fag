package it.unibo.goffo.fag.spawn.controller;

import io.reactivex.Observable;
import it.unibo.goffo.fag.entities.Character;

/**
 * Interface to manage the spawn control.
 */
public interface SpawnController {
    /**
     * Start the timer to spawn entities.
     */
    void startSpawn();

    /**
     * Stop the timer from spawn the entities.
     */
    void stopSpawn();

    /**
     * Dispose all timer's resources.
     */
    void disposeTimer();

    /**
     * Reset the timer and all the property.
     */
    void reset();

    /**
     * Return an observable Character. Used by the view.
     * @return The observable entities.
     */
    Observable<Character> getObservable();
}
