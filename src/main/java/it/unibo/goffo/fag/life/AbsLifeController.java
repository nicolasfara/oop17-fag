package it.unibo.goffo.fag.life;

public abstract class AbsLifeController<T extends Number> implements LifeController<T> {

    protected LifeModel<T> life;

    @SuppressWarnings("unchecked")
    protected AbsLifeController() { }

    @Override
    public T getLife() {
        return this.life.getLife();
    }

    @Override
    public abstract void decreaseOf(final T amount) throws CharacterDiesException;

    @Override
    public abstract void increaseOf(final T amount);
}
