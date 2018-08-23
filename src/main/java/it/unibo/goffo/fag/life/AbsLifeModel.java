package it.unibo.goffo.fag.life;

public abstract class AbsLifeModel<T extends Number> implements LifeModel<T> {

    protected T life;
    protected T maxLife;

    protected AbsLifeModel(final T start, final T maxLife) {
        this.life = start;
        this.maxLife = maxLife;
    }

   @Override
   public T getLife() {
       return this.life;
   }

   @Override
   public abstract void setLife(T amount);

    public abstract static class Builder<T extends Number> {

        protected T life;
        protected T maxLife;

        public Builder setMaxLife(final T maxLife) {
            this.maxLife = maxLife;
            return this;
        }

        public Builder startFrom(final T value) {
            this.life = value;
            return this;
        }

        public abstract LifeModel<T> build() throws IllegalStateException;
    }

}
