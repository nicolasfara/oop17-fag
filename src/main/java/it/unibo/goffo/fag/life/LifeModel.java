package it.unibo.goffo.fag.life;

public interface LifeModel<T> {
    T getLife();

    void setLife(T amount);
}
