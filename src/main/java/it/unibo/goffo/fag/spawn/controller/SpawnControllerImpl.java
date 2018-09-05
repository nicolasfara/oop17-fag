package it.unibo.goffo.fag.spawn.controller;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.time.TimerAction;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import it.unibo.goffo.fag.entities.Character;
import it.unibo.goffo.fag.entities.Zombie;
import it.unibo.goffo.fag.entities.builders.ZombieFactory;
import it.unibo.goffo.fag.spawn.logic.SpawnLogic;
import it.unibo.goffo.fag.spawn.logic.SpawnLogicImpl;
import javafx.util.Duration;

import java.util.stream.Stream;

/**
 * Class control the spawn of entities.
 */
public final class SpawnControllerImpl implements SpawnController {

    private final TimerAction timerAction;
    private final PublishSubject<Character> observable = PublishSubject.create();
    private final SpawnLogic spawnLogic = new SpawnLogicImpl();
    private static final int TIMER_TICK = 5;
    private static SpawnController spawnController;

    private SpawnControllerImpl() {
        timerAction = FXGL.getMasterTimer().runAtInterval(() -> Stream.generate(this::getRandomZombieType)
                    .limit(spawnLogic.getNextCount())
                    .forEach(observable::onNext), Duration.seconds(TIMER_TICK));
    }

    /**
     * Return the same instance. In the application must be present only one spawn controller.
     * @return SpawnController instance.
     */
    public static synchronized SpawnController getInstance() {
        if (spawnController == null) {
            spawnController = new SpawnControllerImpl();
        }
        return spawnController;
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
    public Observable<Character> getObservable() {
        return observable;
    }

    private Zombie getRandomZombieType() {
        switch (FXGLMath.random(0, 1)) {
            case 0:
                return ZombieFactory.createSimpleZombie();
            case 1:
                return ZombieFactory.createAdvancedZombie();
                default:
                    throw new IllegalStateException();
        }
    }
}
