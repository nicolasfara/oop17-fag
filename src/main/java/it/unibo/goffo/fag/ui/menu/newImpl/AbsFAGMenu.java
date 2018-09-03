package it.unibo.goffo.fag.ui.menu.newImpl;

import com.almasb.fxgl.app.FXGL;
import javafx.fxml.FXML;

public abstract class AbsFAGMenu implements FAGMenu {

    AbsFAGMenu() { }

    public void exit() {
        FXGL.getApp().getMenuListener().onExit();
    }

   private void newGame() {
       FXGL.getApp().getMenuListener().onNewGame();
   }
}
