package it.unibo.goffo.fag;

public class FAGConfig {

    private static final double DISP_WIDTH = 800.0;
    private static final double DISP_HEIGHT = 600.0;

    public static final String MAIN_MENU_PATH = "/assets/ui/fxml/mainMenu.fxml";
    public static final String GAME_MENU_PATH = "/assets/ui/fxml/gameMenu.fxml";
    public static final String SCORE_MENU_PATH = "/assets/ui/fxml/ScoresView.fxml";
    public static final String END_GAME_MENU_PATH = "/assets/ui/fxml/endGameMenu.fxml";

    public static FAGConfig getConfig() {
        return new FAGConfig();
    }

    public double getDispWidth() {
        return DISP_WIDTH;
    }

    public double getDispHeight() {
        return DISP_HEIGHT;
    }
}
