package it.unibo.goffo.fag.entities.life.controller;

import com.almasb.fxgl.entity.component.Component;
import it.unibo.goffo.fag.entities.life.model.LifeModel;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import it.unibo.goffo.fag.exceptions.LifeIsOverException;

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
    private final LifeModel<T> life;

    /**
     * Assign the given instance of {@link LifeModel} from concrete class.
     * @param lifeModel A {@link LifeModel} instance
     */
    AbsLifeController(final LifeModel<T> lifeModel) {
        super();
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
    public void setLife(final T amount) throws CharacterDiesException {
        try {
            this.life.setLife(amount);
        } catch (LifeIsOverException e) {
            throw new CharacterDiesException();
        }
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
}
