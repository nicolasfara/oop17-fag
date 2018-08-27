package it.unibo.goffo.fag.spawn.view;

import io.reactivex.functions.Consumer;
import it.unibo.goffo.fag.entities.Character;

/**
 * Interface to visualize the entity in the game each time the controller produce the entity.
 */
public interface SpawnView {
    /**
     * This method must be called to define the behaviour of the attach to the game world.
     * @param consumer consumer define the behaviour.
     */
    void subscribeHandler(Consumer<Character> consumer);
}
