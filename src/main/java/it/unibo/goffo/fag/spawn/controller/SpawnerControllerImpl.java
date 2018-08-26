package it.unibo.goffo.fag.spawner.controller;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.time.Timer;
import com.almasb.fxgl.time.TimerAction;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import javafx.util.Duration;

/**
 *
 */
public class SpawnerControllerImpl implements SpawnController {

    private final TimerAction timerAction;
    private final PublishSubject<? extends Entity> observable = PublishSubject.create();

    /**
     *
     */
    public SpawnerControllerImpl() {
        timerAction = FXGL.getMasterTimer().runAtInterval(() -> {
        }, Duration.seconds(10));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startSpawn() {
       timerAction.resume();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stopSpawn() {
        timerAction.pause();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void disposeTimer() {
        timerAction.expire();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Observable<? extends Entity> getObservable() {
        return observable;
    }
}
