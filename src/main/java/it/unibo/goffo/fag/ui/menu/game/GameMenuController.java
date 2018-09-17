package it.unibo.goffo.fag.ui.menu.game;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.ui.menu.endgame.EndGameMenuController;
import javafx.fxml.FXML;

public class GameMenuController extends EndGameMenuController {

    @FXML
    private void resumePlay() { FXGL.getApp().getMenuListener().onResume(); }
}
