package it.unibo.goffo.fag.spawner.controller;

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
     * @param mode the mode used to spawn the entities.
     */
    void setSpawnMode(SpawnMode mode);

    /**
     *
     * @return
     */
    Observable<? extends Entity> getObservable();
}
