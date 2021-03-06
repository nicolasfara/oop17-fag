package it.unibo.goffo.fag.entities.life.model;

import it.unibo.goffo.fag.exceptions.LifeIsOverException;

/**
 * Abstract implementation of {@link LifeModel}.
 * @param <T> Preferred data type where to store life amount.
 */
abstract class AbsLifeModel<T> implements LifeModel<T> {

    /**
     * Current life value.
     */
    private T life;

    /**
     * Maximum life value.
     */
    private final T maxLife;

    /**
     * Minimum life value.
     */
    private final T minLife;

    /**
     * Set values for {@param life} and {@param maxLife}.
     * @param start Starting life value.
     * @param maxLife Maximum life value.
     */
    AbsLifeModel(final T start, final T minLife, final T maxLife) {
        this.life = start;
        this.minLife = minLife;
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
   public void setLife(final T amount) throws LifeIsOverException {
       this.life = amount;
   }

    /**
     * Get maximum life value.
     * @return Maximum life amount.
     */
    protected T getMaxLife() {
       return this.maxLife;
   }

    /**
     * Get minimum life value.
     * @return Minimum life amount.
     */
    protected T getMinLife() {
       return this.minLife;
   }

    /**
     * Abstract Builder used to get a new stored life value.
     * @param <T> Preferred data type where to store life amount.
     */
   public abstract static class Builder<T> {

       private T life;
       private T maxLife;
       private T minLife;

       public Builder<T> setMinLife(final T minLife) {
           this.minLife = minLife;
           return this;
       }

       public Builder<T> setMaxLife(final T maxLife) {
           this.maxLife = maxLife;
           return this;
       }

       public Builder<T> startFrom(final T value) {
           this.life = value;
           return this;
       }

       protected T getLife() {
           return this.life;
       }

       protected T getMaxLife() {
           return this.maxLife;
       }

       protected T getMinLife() {
           return this.minLife;
       }

       public abstract LifeModel<T> build() throws IllegalStateException;
   }
}
