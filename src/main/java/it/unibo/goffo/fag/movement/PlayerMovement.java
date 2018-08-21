package it.unibo.goffo.fag.movement;

import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.components.PositionComponent;

public class PlayerMovement extends AbstractMovement {


    private static final Logger LOG = Logger.get("FXGL");
    private final Vec2 velocityVector = new Vec2();
    private final PositionComponent positionComponent;

    /**
     * Default constructor used to assign a {@code PositionalComponent} to the movement.
     * @param positionComponent Component used for the moving.
     */
    public PlayerMovement(final PositionComponent positionComponent) {
        super();
        this.positionComponent = positionComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void move(final float deltaX, final float deltaY) {
        if (!positionComponent.getEntity().isActive()) {
            LOG.warning("The entity " + getEntity().toString() + "is not enable. Unable to move the entity");
            return;
        }
        LOG.info("Moving the entity: " + getEntity().toString());
        velocityVector.set(deltaX, deltaY);
        final int vectorLength = FXGLMath.roundPositive(velocityVector.length());
        velocityVector.normalizeLocal();

        for (int i = 0; i < vectorLength; i++) {
            positionComponent.translate(velocityVector.x, velocityVector.y);
        }
    }

}

/*

this part goes inside initInput() in main

Input input = getInput();

input.addAction(new UserAction("Move Right") {
    @Override
    protected void onAction() {
        player.getComponent(DudeControl.class).moveRight();
        getGameState().increment("pixelsMoved", +5);
    }
}, KeyCode.D);

input.addAction(new UserAction("Move Left") {
    @Override
    protected void onAction() {
        player.getComponent(DudeControl.class).moveLeft();
        getGameState().increment("pixelsMoved", +5);
    }
}, KeyCode.A);

input.addAction(new UserAction("Move Up") {
    @Override
    protected void onAction() {
        player.translateY(-5); // move up 5 pixels
        getGameState().increment("pixelsMoved", +5);
    }
}, KeyCode.W);

input.addAction(new UserAction("Move Down") {
    @Override
    protected void onAction() {
        player.translateY(5); // move down 5 pixels
        getGameState().increment("pixelsMoved", +5);
    }
}, KeyCode.S);
*/