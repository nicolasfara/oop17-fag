package it.unibo.goffo.fag;

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
     * Minimum life amount.
     */
    public static final double MIN_LIFE = 0.0;

    /**
     * Maximum life amount.
     */
    public static final double MAX_LIFE = 1.0;

    /**
     * Application name.
     */
    public static final String APPLICATION_NAME = "Final Avenge Guerrilla";

    /**
     * Main Menu FXML file path.
     */
    public static final String MAIN_MENU_PATH = "/assets/ui/fxml/mainMenu.fxml";

    /**
     * Game Menu FXML file path.
     */
    public static final String GAME_MENU_PATH = "/assets/ui/fxml/gameMenu.fxml";

    /**
     * Score Menu FXML file path.
     */
    public static final String SCORE_MENU_PATH = "/assets/ui/fxml/ScoresView.fxml";

    /**
     * End Game Menu FXML file path.
     */
    public static final String END_GAME_MENU_PATH = "/assets/ui/fxml/endGameMenu.fxml";

    /**
     * Tutorial duration in View.
     */
    public static final int TUTORIAL_DURATION = 15;

    /**
     * Window Display Width.
     */
    private static final double DISP_WIDTH = MAP_WIDTH * TILE_SIZE;

    /**
     * Window Display Height.
     */
    private static final double DISP_HEIGHT = MAP_HEIGHT * TILE_SIZE;

    /**
     * Get window display width.
     * @return window display width.
     */
    public double getDispWidth() {
        return DISP_WIDTH;
    }

    /**
     * Get window display height.
     * @return window display height.
     */
    public double getDispHeight() {
        return DISP_HEIGHT;
    }

    /**
     * Get current game configuration.
     * Mostly used by FXML files to get dynamic window size.
     * @return configuration.
     */
    public static FagUtils getConfig() {
        return new FagUtils();
    }

    private FagUtils() { }
}
