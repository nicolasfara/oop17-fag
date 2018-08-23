package it.unibo.goffo.fag.life;

public class LifeControllerImpl extends AbsLifeController<Double> {

    private static final Double MAX_LIFE = 1.0;
    private static final Double MIN_LIFE = 0.0;

    @SuppressWarnings("unchecked")
    public LifeControllerImpl() {
        super();
        this.life = new LifeModelImpl.Builder()
                .setMaxLife(MAX_LIFE)
                .startFrom(MAX_LIFE)
                .build();
    }

    @Override
    public void decreaseOf(final Double amount) throws CharacterDiesException {
        final double newLife = this.life.getLife() - Math.abs(amount);
        if (Double.compare(newLife, MIN_LIFE) < 0) {
            this.life.setLife(MIN_LIFE);
            throw new CharacterDiesException();
        }
        this.life.setLife(newLife);
    }

    @Override
    public void increaseOf(final Double amount) {
        this.life.setLife(this.life.getLife() + Math.abs(amount));
    }
}
