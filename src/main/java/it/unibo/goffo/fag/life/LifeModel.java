package it.unibo.goffo.fag.life;

public interface LifeModel<T> {
    T getLife();

    public void setLife(T amount);
    void setMaxLife(T maxLife);
}
