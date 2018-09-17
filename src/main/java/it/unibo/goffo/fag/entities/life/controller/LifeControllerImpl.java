package it.unibo.goffo.fag.entities.life.controller;

import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import it.unibo.goffo.fag.entities.life.model.LifeModelImpl;

/**
 * Concrete implementation of {@link AbsLifeController} using {@link Double} data type.
 * Life amount is being maintained between {@value MIN_LIFE} and {@value MAX_LIFE}.
 */
public final class LifeControllerImpl extends AbsLifeController<Double> {

    /**
     * Minimum life amount admitted.
     */
    private static final double MIN_LIFE = 0.0;

    /**
     * Maximum life amount admitted.
     */
    private static final double MAX_LIFE = 1.0;

    /**
     * Creates a new instance of {@link LifeController} using maximum default value ({@value MAX_LIFE}).
     * Starting life amount is given in input.
     * @param startFrom Starting amount of life.
     * @throws IllegalArgumentException if {@param startFrom} is less than minimum life value ({@value MIN_LIFE}).
     */
    public LifeControllerImpl(final double startFrom) throws IllegalArgumentException {
        if (Double.compare(startFrom, MIN_LIFE) < 0) {
            throw new IllegalArgumentException();
        }
        super.setLifeModel(new LifeModelImpl.Builder()
                .setMaxLife(MAX_LIFE)
                .startFrom(startFrom)
                .build());
    }

    /**
     * Creates a new instance of {@link LifeController} using default values and starting from maximum life amount
     * ({@value MAX_LIFE}).
     * Minimum life: {@value MIN_LIFE}; Maximum life: {@value MAX_LIFE}.
     */
    public LifeControllerImpl() {
        this(MAX_LIFE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void decreaseOf(final Double amount) throws CharacterDiesException {
        final double newLife = super.getLife() - Math.abs(amount);
        if (Double.compare(newLife, MIN_LIFE) < 0) {
            super.setLife(MIN_LIFE);
            throw new CharacterDiesException();
        }
        super.setLife(newLife);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void increaseOf(final Double amount) {
        super.setLife(super.getLife() + Math.abs(amount));
    }
}
