package it.unibo.goffo.fag.ai.action;

import com.almasb.fxgl.ai.GoalAction;
import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.entity.component.Component;

import it.unibo.goffo.fag.ai.controller.RandomMoveController;

/**
 *
 */
public class RandomMoveAction extends GoalAction {

    private static final Logger LOGGER = Logger.get(RandomMoveAction.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpdate(final double v) {
        //Not used
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean reachedGoal() {
        if (getEntity().getComponent(RandomMoveController.class).collidingWithPlayer()) {
            getEntity().getComponentOptional(RandomMoveController.class).ifPresent(Component::pause);
            LOGGER.info("Entity collision");
            return true;
        }
        getEntity().getComponentOptional(RandomMoveController.class).ifPresent(Component::resume);
        return false;
    }
}
