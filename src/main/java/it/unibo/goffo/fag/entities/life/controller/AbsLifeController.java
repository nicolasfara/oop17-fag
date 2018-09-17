package it.unibo.goffo.fag.entities.life.controller;

import com.almasb.fxgl.entity.component.Component;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import it.unibo.goffo.fag.entities.life.model.LifeModel;

/**
 * Abstract implementation of {@link LifeController}.
 * Extends {@link Component} to be used in {@link com.almasb.fxgl.entity.Entity} builder.
 * @param <T> Data type used to store life amount.
 */
abstract class AbsLifeController<T> extends Component implements LifeController<T> {

    /**
     * Wrapper of the chosen data type.
     * @see LifeModel
     */
    private LifeModel<T> life;

    /**
     * Assign the given instance of {@link LifeModel} from concrete class.
     * @param lifeModel A {@link LifeModel} instance
     */
    protected void setLifeModel(final LifeModel<T> lifeModel) {
        this.life = lifeModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getLife() {
        return this.life.getLife();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLife(final T amount) {
        this.life.setLife(amount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void decreaseOf(T amount) throws CharacterDiesException;

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void increaseOf(T amount);

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "AbsLifeController{"
               + "life=" + life
               + "} " + super.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbsLifeController<?> that = (AbsLifeController<?>) o;

        return getLife().equals(that.getLife());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return getLife().hashCode();
    }
}
