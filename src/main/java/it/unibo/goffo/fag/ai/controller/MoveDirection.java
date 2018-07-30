package it.unibo.goffo.fag.ai.controller;

/**
 * Enum that contain all possible direction for an entity.
 */
public enum MoveDirection {

    //The order is IMPORTANT, don't change!
    /**
     * Up direction for the entity.
     */
    UP,
    /**
     * Right direction for the entity.
     */
    RIGHT,
    /**
     * Down direction for the entity.
     */
    DOWN,
    /**
     * Left direction for the entity.
     */
    LEFT;

    /**
     * Get the next direction in clockwise order.
     * @return return the position.
     */
    public MoveDirection next() {
        int index = ordinal() + 1;
        if (index == values().length) {
            index = 0;
        }
        return values()[index];
    }

    /**
     * Get the previous direction.
     * @return return the position.
     */
    public MoveDirection prev() {
        int index = ordinal() - 1;
        if (index == -1) {
            index = values().length - 1;
        }
        return values()[index];
    }
}
