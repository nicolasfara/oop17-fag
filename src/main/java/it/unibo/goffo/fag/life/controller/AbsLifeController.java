package it.unibo.goffo.fag.life.controller;

import com.almasb.fxgl.entity.component.Component;
import it.unibo.goffo.fag.exceptions.CharacterDiesException;
import it.unibo.goffo.fag.life.model.LifeModel;

public abstract class AbsLifeController<T extends Number> extends Component implements LifeController<T> {

    private LifeModel<T> life;

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
    public abstract void decreaseOf(T amount) throws CharacterDiesException;

    @Override
    public abstract void increaseOf(T amount);
}
