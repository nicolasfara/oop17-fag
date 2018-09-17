package it.unibo.goffo.fag.entities.life.model;

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
    private T maxLife;

    /**
     * Set values for {@param life} and {@param maxLife}.
     * @param start Starting life value.
     * @param maxLife Maximum life value.
     */
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
     * Get maximum life value.
     * @return Maximum life amount.
     */
   T getMaxLife() {
       return this.maxLife;
   }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbsLifeModel<?> that = (AbsLifeModel<?>) o;

        if (!getLife().equals(that.getLife())) {
            return false;
        }
        return getMaxLife().equals(that.getMaxLife());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = getLife().hashCode();
        result = 31 * result + getMaxLife().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AbsLifeModel{"
                + "life=" + life
                + ", maxLife=" + maxLife
                + '}';
    }

    /**
     * Abstract Builder used to get a new stored life value.
     * @param <T> Preferred data type where to store life amount.
     */
   public abstract static class Builder<T> {

       private T life;
       private T maxLife;

       public Builder<T> setMaxLife(final T maxLife) {
           this.maxLife = maxLife;
           return this;
       }

       public Builder<T> startFrom(final T value) {
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
