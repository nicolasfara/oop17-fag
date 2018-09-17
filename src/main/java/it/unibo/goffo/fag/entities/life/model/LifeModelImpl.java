package it.unibo.goffo.fag.entities.life.model;

/**
 * Concrete implementation of {@link AbsLifeModel}.
 * Only manages upper bound value: if it reaches limit, life amount is set to maximum value.
 */
public class LifeModelImpl extends AbsLifeModel<Double> {

    private LifeModelImpl(final double start, final double maxLife) {
        super(start, maxLife);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLife(final Double amount) {
        if (Double.compare(amount, super.getMaxLife()) > 0) {
            super.setLife(super.getMaxLife());
        } else {
            super.setLife(amount);
        }
    }

    /**
     * Concrete {@link AbsLifeModel.Builder} implementation.
     * All parameters are needed to get {@code build()} work successfully.
     */
    public static class Builder extends AbsLifeModel.Builder<Double> {
        /**
         * Concretely build a new {@link LifeModel} instance.
         * Note: if life is greater than maxLife, it is set to that value.
         * @return a new {@link LifeModel} instance, with given parameters.
         * @throws IllegalStateException if {@code life} or {@code maxLife} are {@code null}.
         */
        public LifeModel<Double> build() throws IllegalStateException {
            if (super.getLife() == null) {
                throw new IllegalStateException("Life in Builder must be assigned");
            } else if (super.getMaxLife() == null) {
                throw new IllegalStateException("Max Life in Builder must be assigned");
            }
            if (Double.compare(super.getLife(), super.getMaxLife()) > 0) {
                super.startFrom(super.getMaxLife());
            }
            return new LifeModelImpl(super.getLife(), super.getMaxLife());
        }
    }
}
