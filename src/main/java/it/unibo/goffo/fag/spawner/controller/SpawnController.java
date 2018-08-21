package it.unibo.goffo.fag.spawner.controller;

import com.almasb.fxgl.entity.Entity;
import io.reactivex.Observable;

/**
 *
 */
public interface SpawnerController {
    /**
     *
     */
    void startSpawner();

    /**
     *
     */
    void stopSpawner();

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
