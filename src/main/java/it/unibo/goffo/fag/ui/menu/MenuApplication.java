package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.ApplicationMode;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.core.logging.*;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.EnumSet;

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
        settings.setApplicationMode(ApplicationMode.RELEASE);
        settings.setCloseConfirmation(false);
        getAudioPlayer().setGlobalMusicVolume(0.0);
        getAudioPlayer().setGlobalSoundVolume(0.0);
        /*settings.setSoundMenuBack("");
        settings.setSoundMenuPress("");
        settings.setSoundMenuSelect("");
        settings.setSoundNotification("");*/
        /*
            Trying to disable profile selection on startup.
            settings.setEnabledMenuItems(EnumSet.of(MenuItem.EXTRA)); // NOT WORKING
         */

        Logger.addOutput(new ConsoleOutput(), LoggerLevel.DEBUG);
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
