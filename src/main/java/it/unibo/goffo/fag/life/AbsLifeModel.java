package it.unibo.goffo.fag.life;

/**
 * Simple implementation on life manager with Number data types.
 * @param <T> A Number data type.
 */
public abstract class AbsLifeModel<T extends Number> implements LifeModel<T> {

    protected T life;
    protected T maxLife;

    protected AbsLifeModel(final T start, final T maxLife) {
        this.life = start;
        this.maxLife = maxLife;
    }

    /**
     * {@inheritDoc}
     */
   @Override
   public T getLife() {
       return this.life;
   }

    /**
     * {@inheritDoc}
     */
   @Override
   public abstract void setLife(T amount);

    /**
     * Simple builder to get a new life stored value in number way.
     * @param <T>
     */
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
