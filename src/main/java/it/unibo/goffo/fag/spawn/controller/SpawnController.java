package it.unibo.goffo.fag.spawn.controller;

import com.almasb.fxgl.entity.Entity;
import io.reactivex.Observable;

/**
 *
 */
public interface SpawnController {
    /**
     *
     */
    void startSpawn();

    /**
     *
     */
    void stopSpawn();

    /**
     *
     */
    void disposeTimer();

    /**
     *
     * @return
     */
    Observable<? extends Entity> getObservable();
}
