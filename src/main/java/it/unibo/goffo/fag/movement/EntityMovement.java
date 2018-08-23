package it.unibo.goffo.fag.movement;

/**
 * This class is used to move an entity.
 */
public class EntityMovement extends AbstractMovement {

    /**
     *
     */
    public EntityMovement() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void move(final float deltaX, final float deltaY) {
        getEntity().translate(deltaX, deltaY);
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
