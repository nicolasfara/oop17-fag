package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import javafx.fxml.FXML;

public class GameMenuController extends EndGameMenuController {

    @FXML
    private void resumePlay() {
        FXGL.getApp().getMenuListener().onResume();
    }

}
