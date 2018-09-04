package it.unibo.goffo.fag.life;

import com.almasb.fxgl.app.FXGL;

public class LifeControllerImpl extends AbsLifeController<Double> {

    private static final double MIN_LIFE = 0.0;
    private static final double MAX_LIFE = 1.0;
    private static double LIFE_OFFSET = 0.1;

    //@SuppressWarnings("unchecked")
    public LifeControllerImpl() {
        super(new LifeModelImpl.Builder()
                .setMaxLife(MAX_LIFE)
                .startFrom(MAX_LIFE)
                .build());
    }

    public void setLifeOffset(final double amount) {
        if (Double.compare(amount, MAX_LIFE) > 0) {
            LIFE_OFFSET = MAX_LIFE;
        } else if (Double.compare(amount, MIN_LIFE) < 0) {
            this.setLifeOffset(MIN_LIFE + LIFE_OFFSET);
        }
        LIFE_OFFSET = amount;
    }

    public double getLifeOffset() {
        return LIFE_OFFSET;
    }

    public void autoIncrese() {
        this.increaseOf(LIFE_OFFSET);
    }

    public void autoDecrease() throws CharacterDiesException {
        this.decreaseOf(LIFE_OFFSET);
    }

    @Override
    public void decreaseOf(final Double amount) throws CharacterDiesException {
        final double newLife = super.getLife() - Math.abs(amount);
        if (Double.compare(newLife, MIN_LIFE) < 0) {
            super.setLife(MIN_LIFE);
            throw new CharacterDiesException();
        }
        super.setLife(newLife);
        updateGameEngine();
    }

    @Override
    public void increaseOf(final Double amount) {
        super.setLife(super.getLife() + Math.abs(amount));
        updateGameEngine();
    }


    /* NON IMPLEMENTARE QUI */
    private void updateGameEngine() {
        FXGL.getApp().getGameState().setValue("playerLife", super.getLife());

    }
}
