package it.unibo.goffo.fag.life;

abstract class AbsLifeModel<T> implements LifeModel<T> {

    protected T life;
    protected T maxLife;

   @Override
   public T getLife() {
       return this.life;
   }

   @Override
   public abstract void setLife(T amount);

   @Override
   public abstract void setMaxLife(T maxLife);


    public abstract static class Builder<T extends Number> {

        private T life;
        private T maxLife;

        public Builder setMaxLife(final T maxLife) {
            this.maxLife = maxLife;
            return this;
        }

        public Builder startFrom(final T value) {
            this.life = value;
            return this;
        }

        abstract LifeModel<T> build() throws IllegalStateException;
    }

}
