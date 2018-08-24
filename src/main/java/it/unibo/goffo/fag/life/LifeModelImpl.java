package it.unibo.goffo.fag.life;

public class LifeModelImpl extends AbsLifeModel<Double> implements LifeModel<Double> {

    private LifeModelImpl(final double start, final double maxLife) {
        super(start, maxLife);
    }

    @Override
    public void setLife(final Double amount) {
        super.setLife(amount);
        if (Double.compare(super.getLife(), super.getMaxLife()) > 0) {
            super.setLife(super.getMaxLife());
        }
    }

    public static class Builder extends AbsLifeModel.Builder<Double> {

        /**
         * aaa.
         * @return LifeMel the life model.
         * @throws IllegalStateException aaa edee.
         *
         */
        public LifeModel<Double> build() throws IllegalStateException {
            if (super.getLife() == null) {
                throw new IllegalStateException("Life in Builder must be assigned");
            } else if (super.getMaxLife() == null) {
                throw new IllegalStateException("Max Life in Builder must be assigned");
            }
            return new LifeModelImpl(super.getLife(), super.getMaxLife());
        }
    }

}
