package it.unibo.goffo.fag.life.controller;

import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import it.unibo.goffo.fag.life.model.LifeModelImpl;

public class LifeControllerImpl extends AbsLifeController<Double> {

    private static final double MIN_LIFE = 0.0;
    private static final double MAX_LIFE = 1.0;

    public LifeControllerImpl() {
        super(new LifeModelImpl.Builder()
                .setMaxLife(MAX_LIFE)
                .startFrom(MAX_LIFE)
                .build());
    }

    public LifeControllerImpl(final double startFrom) {
        super(new LifeModelImpl.Builder()
                .setMaxLife(MAX_LIFE)
                .startFrom(startFrom)
                .build());
    }

    @Override
    public void decreaseOf(final Double amount) throws CharacterDiesException {
        final double newLife = super.getLife() - Math.abs(amount);
        if (Double.compare(newLife, MIN_LIFE) < 0) {
            super.setLife(MIN_LIFE);
            throw new CharacterDiesException();
        }
        super.setLife(newLife);
    }

    @Override
    public void increaseOf(final Double amount) {
        super.setLife(super.getLife() + Math.abs(amount));
    }
}
