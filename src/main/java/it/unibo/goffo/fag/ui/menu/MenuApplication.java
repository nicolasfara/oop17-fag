package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MenuApplication extends GameApplication {
    /**
     * Initialize app settings.
     *
     * @param settings app settings
     */
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setTitle("Fight Avenge Guerrilla");
        settings.setMenuEnabled(true);
        settings.setSceneFactory(new FAGMenuFactory());
    }

        @Override
    protected void initUI() {
        Rectangle bg = new Rectangle(600, 600);
        bg.setFill(Color.BLUE);
        getGameScene().addUINode(bg);
    }

    public static void exitGame() {
        new MenuApplication().exit();
    }

    /**
     * Main.
     * @param args Args.
     */
    public static void main(final String[] args) {
        launch(args);
    }

}
