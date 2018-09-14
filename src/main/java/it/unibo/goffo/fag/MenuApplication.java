package it.unibo.goffo.fag;

import com.almasb.fxgl.app.*;
import com.almasb.fxgl.core.logging.ConsoleOutput;
import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.core.logging.LoggerLevel;
import com.almasb.fxgl.settings.GameSettings;
import it.unibo.goffo.fag.ui.menu.FAGMenuFactory;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

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

        /*
         * Trying to disable sound
         */
        /*
        settings.setSoundMenuBack("");
        settings.setSoundMenuPress("");
        settings.setSoundMenuSelect("");
        settings.setSoundNotification("");
        */
        getAudioPlayer().setGlobalMusicVolume(0.0);
        getAudioPlayer().setGlobalSoundVolume(0.0);

        /*
            Trying to disable profile selection on startup.
         */
        /*
        settings.setEnabledMenuItems(EnumSet.of(MenuItem.EXTRA)); // NOT WORKING
         */

        Logger.addOutput(new ConsoleOutput(), LoggerLevel.DEBUG);
    }

        @Override
    protected void initUI() {
        /*
            Random background to see new games in "Restart" game menu option.
         */
        Rectangle bg = new Rectangle(600, 600);
        bg.setFill(Color.color(new Random().nextDouble(), new Random().nextDouble(), new Random().nextDouble()));
        getGameScene().addUINode(bg);

        /*
         * Managing end game menu.
         */
        Button btnEndGame = new Button("END GAME");
        btnEndGame.setTranslateX(200);
        btnEndGame.setTranslateY(200);
        getGameScene().addUINode(btnEndGame);
        btnEndGame.setOnMouseClicked(
            e -> FAGMenuFactory.newEndGameMenu(this)
        );
    }

    /**
     * Main.
     * @param args Args.
     */
    public static void main(final String[] args) {
        launch(args);
    }

}
