package it.unibo.goffo.fag.ui.menu.game;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.ui.menu.endgame.EndGameMenuController;
import javafx.fxml.FXML;

/**
 * Game Menu controller.
 * Same as {@link EndGameMenuController} but adding "resume" menu option.
 */
public class GameMenuController extends EndGameMenuController {

    @FXML
    private void resumePlay() {
        FXGL.getApp().getMenuListener().onResume();
    }
}
