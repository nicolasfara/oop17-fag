package it.unibo.goffo.fag.life;

/**
 * Simple implementation on life manager with Number data types.
 * @param <T> A Number data type.
 */
public abstract class AbsLifeModel<T extends Number> implements LifeModel<T> {

    private T life;
    private T maxLife;

    AbsLifeModel(final T start, final T maxLife) {
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
   public void setLife(final T amount) {
       this.life = amount;
   }

    /**
     * aaa.
     * @return aaa.
     */
   T getMaxLife() {
       return this.maxLife;
   }

    /**
     * Simple builder to get a new life stored value in number way.
     * @param <T>
     */
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

       T getLife() {
           return this.life;
       }

       T getMaxLife() {
           return this.maxLife;
       }

       public abstract LifeModel<T> build() throws IllegalStateException;
   }

}
