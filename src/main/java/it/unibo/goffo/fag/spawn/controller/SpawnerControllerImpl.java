package it.unibo.goffo.fag.spawn.controller;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.time.TimerAction;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import it.unibo.goffo.fag.spawn.logic.SpawnLogic;
import it.unibo.goffo.fag.spawn.logic.SpawnLogicImpl;
import javafx.util.Duration;

import java.util.stream.Stream;

/**
 *
 */
public class SpawnerControllerImpl implements SpawnController {

    private final TimerAction timerAction;
    private final PublishSubject<? extends Entity> observable = PublishSubject.create();
    private final SpawnLogic spawnLogic = new SpawnLogicImpl();
    private static final int TIMER_TICK = 5;

    /**
     *
     */
    public SpawnerControllerImpl() {
        timerAction = FXGL.getMasterTimer().runAtInterval(() -> {
            Stream.generate(Entity::new)
                    .limit(spawnLogic.getNextCount())
                    .forEach(obj -> obj.getView());
        }, Duration.seconds(TIMER_TICK));
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
