package it.unibo.goffo.fag.life;

public abstract class AbsLifeController<T extends Number> implements LifeController<T> {

    private LifeModel<T> life;

    @SuppressWarnings("unchecked")
    AbsLifeController(final LifeModel<T> lifeModel) {
        this.life = lifeModel;
    }

    @Override
    public T getLife() {
        return this.life.getLife();
    }

    @Override
    public void setLife(final T amount) {
        this.life.setLife(amount);
    }

    @Override
    public abstract void decreaseOf(final T amount) throws CharacterDiesException;

    @Override
    public abstract void increaseOf(final T amount);
}
