package it.unibo.goffo.fag.life;

public class LifeModelImpl extends AbsLifeModel<Double> implements LifeModel<Double> {

    private LifeModelImpl(final double start, final double maxLife) {
        super(start, maxLife);
    }

    @Override
    public void setLife(final Double amount) {
        this.life = amount;
        if (Double.compare(this.life, this.maxLife) > 0) {
            this.life = this.maxLife;
        }
    }

    public static class Builder extends AbsLifeModel.Builder<java.lang.Double> {
        /**
         * aaaaa
         * @return LifeMel the lifemodel
         * @throws IllegalStateException aaaa eeee
         *
         */
        public LifeModel<Double> build() throws IllegalStateException {
            return new LifeModelImpl(this.life, this.maxLife);
        }
    }

}
