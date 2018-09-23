package it.unibo.goffo.fag.entities.life.controller;

import it.unibo.goffo.fag.entities.life.model.LifeModelImpl;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;

import static it.unibo.goffo.fag.FagUtils.MIN_LIFE;
import static it.unibo.goffo.fag.FagUtils.MAX_LIFE;

/**
 * Concrete implementation of {@link AbsLifeController} using {@link Double} data type.
 * Life amount is being maintained between values set in {@link it.unibo.goffo.fag.FagUtils}
 */
public final class LifeControllerImpl extends AbsLifeController<Double> {

    /**
     * Creates a new instance of {@link LifeController} with given values for minimum, maximum and current life.
     * @param minLife Minimum life.
     * @param maxLife Maximum life.
     * @param startFrom Current life.
     * @throws IllegalStateException if values are null or startFrom is less than minLife.
     */
    public LifeControllerImpl(final double minLife, final double maxLife, final double startFrom) throws IllegalStateException {
        super(new LifeModelImpl.Builder()
                .setMinLife(minLife)
                .setMaxLife(maxLife)
                .startFrom(startFrom)
                .build());
    }

    /**
     * Creates a new instance of {@link LifeController} using maximum default value.
     * Starting life amount is given in input.
     * @param startFrom Starting amount of life.
     * @throws IllegalStateException from {@code build} of {@link LifeModelImpl.Builder}.
     */
    public LifeControllerImpl(final double startFrom) throws IllegalStateException {
        this(MIN_LIFE, MAX_LIFE, startFrom);
    }

    /**
     * Creates a new instance of {@link LifeController} using default values and starting from maximum life amount.
     */
    public LifeControllerImpl() {
        this(MAX_LIFE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void decreaseOf(final Double amount) throws CharacterDiesException {
        super.setLife(Double.sum(super.getLife(), -Math.abs(amount)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void increaseOf(final Double amount) {
        try {
            super.setLife(Double.sum(super.getLife(), Math.abs(amount)));
        } catch (CharacterDiesException e) {
            e.printStackTrace();
        }
    }
}
