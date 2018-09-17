package it.unibo.goffo.fag;

import javafx.scene.paint.Color;

/**
 * Utility class.
 */
public final class FagUtils {
    /**
     * TILE_SIZE: a square (tile) of X by X pixels.
     */
    public static final int TILE_SIZE = 40;

    /**
     * MAP_WIDTH: how many tiles is the map in width.
     */
    public static final int MAP_WIDTH = 20;

    /**
     * MAP_HEIGHT: how many tiles is the map in height.
     */
    public static final int MAP_HEIGHT = 15;

    /**
     * X size for zombie entity.
     */
    public static final int ZOMBIE_SIZE_X = 64;

    /**
     * Y size for zombie entity.
     */
    public static final int ZOMBIE_SIZE_Y = 64;

    /**
     * X size for player entity.
     */
    public static final int PLAYER_SIZE_X = 64;

    /**
     * Y size for player entity.
     */
    public static final int PLAYER_SIZE_Y = 64;

    /**
     * Application name.
     */
    static final String APPLICATION_NAME = "Final Avenge Guerrilla";

    /**
     * Tutorial text color.
     */
    static final Color TUTORIAL_TEXT_COLOR = Color.BLACK;

    /**
     * Tutorial Keycode color.
     */
    static final Color TUTORIAL_KEYCODE_COLOR = Color.RED;

    /**
     * Tutorial text size.
     */
    static final int TUTORIAL_TEXT_SIZE = 18;

    /**
     * Tutorial Keycode size.
     */
    static final int TUTORIAL_KEYCODE_SIZE = 16;

    private FagUtils() { }
}
