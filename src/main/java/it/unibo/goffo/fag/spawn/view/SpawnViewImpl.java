package it.unibo.goffo.fag.spawn.view;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import it.unibo.goffo.fag.entities.Character;
import it.unibo.goffo.fag.spawn.controller.SpawnController;

/**
 * Concrete class used to show the entity into the game world.
 */
public class SpawnViewImpl implements SpawnView {

    private final SpawnController spawnController;

    /**
     * Default constructor use to take a reference of the controller.
     * @param spawnController the spawn controller.
     */
    public SpawnViewImpl(final SpawnController spawnController) {
        this.spawnController = spawnController;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void subscribeHandler(final Consumer<Character> consumer) {
        final Disposable disposable = spawnController.getObservable()
                .observeOn(Schedulers.newThread())
                .subscribe(consumer);
        final CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(disposable);
    }
}
