package it.unibo.goffo.fag.life;

public interface LifeModel<T> {
    T getLife();

    void setLife(T amount);

/*    public interface Builder<T> {
        public Builder setMaxLife(final T maxLife);
        public Builder startFrom(final T value);
    }*/
}
