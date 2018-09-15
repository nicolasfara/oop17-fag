package it.unibo.goffo.fag;

/**
 * Utility class.
 */
public final class FagUtils {
    /**
     * Map details.
     * TILE_SIZE: a square (tile) of X by X pixels.
     * MAP_WIDTH: how many tiles is the map in width.
     * MAP_HEIGHT: how many tiles is the map in height.
     */
    public static final int TILE_SIZE = 40;
    public static final int MAP_WIDTH = 20;
    public static final int MAP_HEIGHT = 15;

    /**
     * Map details for AI.
     * BLOCK_SIZE: block size for AI grid.
     * AI_WIDTH: width of the AI grid.
     * AI_HEIGHT: height of the AI grid.
     */
    public static final int AI_BLOCK = 40;
    public static final int AI_WIDTH = 800;
    public static final int AI_HEIGHT = 600;

    /**
     * X size for zombie entity.
     */
    public static final int ZOMBIE_SIZE_X = 32;

    /**
     * Y size for zombie entity.
     */
    public static final int ZOMBIE_SIZE_Y = 64;

    /**
     * X size for player entity.
     */
    public static final int PLAYER_SIZE_X = 32;

    /**
     * Y size for player entity.
     */
    public static final int PLAYER_SIZE_Y = 64;

    /**
     * Application name.
     */
    static final String APPLICATION_NAME = "Final Avenge Guerrilla";

    private FagUtils() { }
}
