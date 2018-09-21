package it.unibo.goffo.fag.entities.life.controller;

import it.unibo.goffo.fag.entities.life.model.LifeModelImpl;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;

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
     * Creates a new instance of {@link LifeController} with given values for minimum, maximum and current life.
     * @param minLife Minimum life.
     * @param maxLife Maximum life.
     * @param startFrom Current life.
     * @throws IllegalStateException if values are null or {@param startFrom} is less than {@param minLife}.
     */
    public LifeControllerImpl(final double minLife, final double maxLife, final double startFrom) throws IllegalStateException {
        super(new LifeModelImpl.Builder()
                .setMinLife(minLife)
                .setMaxLife(maxLife)
                .startFrom(startFrom)
                .build());
    }

    /**
     * Creates a new instance of {@link LifeController} using maximum default value ({@value MAX_LIFE}).
     * Starting life amount is given in input.
     * @param startFrom Starting amount of life.
     * @throws IllegalStateException from {@code build} of {@link LifeModelImpl.Builder}.
     */
    public LifeControllerImpl(final double startFrom) throws IllegalStateException {
        this(MIN_LIFE, MAX_LIFE, startFrom);
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
        super.setLife(super.getLife() - Math.abs(amount));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void increaseOf(final Double amount) {
        try {
            super.setLife(super.getLife() + Math.abs(amount));
        } catch (CharacterDiesException e) {
            // No way
        }
    }
}
