package it.unibo.goffo.fag.entities.life.model;

import it.unibo.goffo.fag.exceptions.LifeIsOverException;

/**
 * Concrete implementation of {@link AbsLifeModel}.
 * Only manages upper bound value: if it reaches limit, life amount is set to maximum value.
 */
@SuppressWarnings({"FinalClass", "PMD.MissingStaticMethodInNonInstantiatableClass"})
public class LifeModelImpl extends AbsLifeModel<Double> {

    private LifeModelImpl(final double start, final double minLife, final double maxLife) {
        super(start, minLife, maxLife);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLife(final Double amount) throws LifeIsOverException {
        if (Double.compare(amount, super.getMaxLife()) > 0) {
            super.setLife(super.getMaxLife());
        } else if (Double.compare(amount, super.getMinLife()) <= 0 || Double.compare(amount, super.getLife()) >= 0) {
            super.setLife(super.getMinLife());
            throw new LifeIsOverException();
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
         * @throws IllegalStateException if {@code life} or {@code maxLife} are {@code null} or if
         *  {@code life} is less than {@code minLife}.
         */
        @Override
        public LifeModel<Double> build() throws IllegalStateException {
            if (super.getLife() == null) {
                throw new IllegalStateException("Life in Builder must be assigned.");
            } else if (super.getMaxLife() == null) {
                throw new IllegalStateException("Max Life in Builder must be assigned.");
            } else if (super.getMinLife() == null) {
                throw new IllegalStateException("Min Life in Builder must be assigned.");
            } else if (Double.compare(super.getLife(), super.getMinLife()) < 0) {
                throw new IllegalStateException("Min Life cannot be greater than start life value.");
            } else if (Double.compare(super.getMinLife(), super.getMaxLife()) > 0) {
                throw new IllegalStateException("Min Life cannot be greater than maximum life value.");
            }
            if (Double.compare(super.getLife(), super.getMaxLife()) > 0) {
                super.startFrom(super.getMaxLife());
            }
            return new LifeModelImpl(super.getLife(), super.getMinLife(), super.getMaxLife());
        }
    }
}
