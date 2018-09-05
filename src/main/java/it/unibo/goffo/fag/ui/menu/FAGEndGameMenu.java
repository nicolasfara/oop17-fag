package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.menu.MenuType;

public class FAGEndGameMenu extends FAGMenu {
    public FAGEndGameMenu(final GameApplication app, final MenuType type) {
        super(app, type);
        this.makeEndGameMenu();
    }

    private void makeEndGameMenu() {
        super.setFagMenu(super.readMenuFromFXML("/assets/ui/fxml/endGameMenu.fxml"));
        super.updateView();
    }
}
