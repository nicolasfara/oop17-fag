package it.unibo.goffo.fag.life;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class LifeModelImpl extends AbsLifeModel<Double>  {

    private final DoubleProperty lifeProperty;

    private LifeModelImpl(final double start, final double maxLife) {
        super();
        this.life = start;
        this.maxLife = maxLife;
        this.lifeProperty = new SimpleDoubleProperty(start);
    }

    @Override
    public Double getLife() {
        return this.life;
    }

    @Override
    public void setLife(final Double amount) {
        this.life = amount;
        this.lifeProperty.set(amount);
        if (Double.compare(this.life, this.maxLife) > 0) {
            this.life = this.maxLife;
            this.lifeProperty.set(this.maxLife);
        }
    }

    @Override
    public void setMaxLife(final Double maxLife) {
        this.maxLife = maxLife;
    }

    public DoubleProperty getProperty() {
        return this.lifeProperty;
    }

    public static class Builder extends AbsLifeModel.Builder {

        public LifeModelImpl build() throws IllegalStateException {

            return null;
        }
    }

}
