package it.unibo.goffo.fag.life.controller;

import it.unibo.goffo.fag.exceptions.CharacterDiesException;

public interface LifeController<T> {
    T getLife();
    void setLife(T amount);
    void increaseOf(T amount);
    void decreaseOf(T amount) throws CharacterDiesException;
}
