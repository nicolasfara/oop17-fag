package it.unibo.goffo.fag.life;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.IntegerPropertyBase;

public class LifeImpl implements Life {

    private IntegerProperty life;
    private int maxLife;

    private LifeImpl(final int start, final int maxLife) {
        super();
        this.life.set(start);
        this.maxLife = maxLife;
    }

    @Override
    public int getLife() {
        return this.life.get();
    }

    @Override
    public void setLife(final int amount) {
        this.life.add(amount);
        if (this.life.get() > this.maxLife) {
            this.life.set(this.maxLife);
        }
    }

    @Override
    public void setMaxLife(final int maxLife) {
        this.maxLife = maxLife;
    }

    public IntegerProperty lifeProperty() {
        if (this.life == null) {
            this.life = new IntegerPropertyBase() {
                @Override
                public Object getBean() {
                    return LifeImpl.this;
                }

                @Override
                public String getName() {
                    return "life";
                }
            };
        }
        return this.life;
    }

    public static class Builder {
        private IntegerPropertyBase life;
        private int maxLife = 0;

        public Builder setMaxLife(final int maxLife) {
            this.maxLife = maxLife;
            return this;
        }

        public Builder startFrom(final int value) {
            this.life.set(value);
            return this;
        }

        public LifeImpl build() throws IllegalStateException {
            if (this.life == null || this.maxLife == 0) {
                throw new IllegalStateException("Life must have a max value and has to start from a certain value");
            }
            return new LifeImpl(this.life.get(), this.maxLife);
        }
    }
}
