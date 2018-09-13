package it.unibo.goffo.fag;

import com.almasb.fxgl.app.ApplicationMode;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.core.logging.ConsoleOutput;
import com.almasb.fxgl.core.logging.Logger;
import com.almasb.fxgl.core.logging.LoggerLevel;
import com.almasb.fxgl.settings.GameSettings;
import com.almasb.fxgl.ui.UI;
import it.unibo.goffo.fag.ui.menu.EndGameMenuController;
import it.unibo.goffo.fag.ui.menu.FAGMenuFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
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
        /*
            Random background to see new games in "Restart" game menu option.
         */
        Rectangle bg = new Rectangle(600, 600);
        bg.setFill(Color.color(new Random().nextDouble(), new Random().nextDouble(), new Random().nextDouble()));
        getGameScene().addUINode(bg);
        Button btnEndGame = new Button("END GAME");
        btnEndGame.setTranslateX(200);
        btnEndGame.setTranslateY(200);
        getGameScene().addUINode(btnEndGame);
/*        btnEndGame.setOnMouseClicked(
                e -> new FAGMenuFactory().newEndGameMenu(this)
        );*/

        btnEndGame.setOnMouseClicked(
//                e -> new FAGMenuFactory().newEndGameMenu(this)
                e -> new FAGMenuFactory().newScoresMenu(this)
        );

        /*
        // 1. create a controller class that implements UIController
            EndGameMenuController gameMenuController = new EndGameMenuController();

        btnEndGame.setOnMouseClicked(e -> {
            // 2. place fxml file in "assets/ui" and load it
            final UI fxmlUI = getAssetLoader().loadUI("fxml/endGameMenu.fxml", gameMenuController);
            // 4. add UI to game scene
            getGameScene().addUI(fxmlUI);
            }
        );

e
/*        btnEndGame.setOnMouseClicked(e -> {
            try {
                getGameScene().addUINode(FXMLLoader.load(getClass().getResource("/assets/ui/fxml/endGameMenu.fxml")));
            } catch (IOException k) {
                k.printStackTrace();
            }
            }
        );*/
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
