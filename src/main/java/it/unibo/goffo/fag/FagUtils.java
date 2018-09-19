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

    /**
     *
     */
    public static final String MAIN_MENU_PATH = "/assets/ui/fxml/mainMenu.fxml";

    /**
     *
     */
    public static final String GAME_MENU_PATH = "/assets/ui/fxml/gameMenu.fxml";

    /**
     *
     */
    public static final String SCORE_MENU_PATH = "/assets/ui/fxml/ScoresView.fxml";

    /**
     *
     */
    public static final String END_GAME_MENU_PATH = "/assets/ui/fxml/endGameMenu.fxml";

    /**
     *
     */
    private static final double DISP_WIDTH = 800.0;

    /**
     *
     */
    private static final double DISP_HEIGHT = 600.0;

    /**
     *
     * @return
     */
    public double getDispWidth() {
        return DISP_WIDTH;
    }

    /**
     *
     * @return
     */
    public double getDispHeight() {
        return DISP_HEIGHT;
    }

    /**
     *
     * @return
     */
    public static FagUtils getConfig() {
        return new FagUtils();
    }

    private FagUtils() { }
}
