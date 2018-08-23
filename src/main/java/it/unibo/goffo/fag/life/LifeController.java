package it.unibo.goffo.fag.life;

public interface LifeController<T> {
    T getLife();
    void increaseOf(T amount);
    void decreaseOf(T amount) throws CharacterDiesException;
}
