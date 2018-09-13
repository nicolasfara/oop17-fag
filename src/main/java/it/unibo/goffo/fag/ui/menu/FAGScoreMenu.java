package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.menu.MenuType;

public class FAGScoreMenu extends FAGMenu {

    public FAGScoreMenu(final GameApplication app, final MenuType type) {
        super(app, type);
        this.makeScoresMenu();
    }

    private void makeScoresMenu() {
        super.setFagMenu(super.readMenuFromFXML("/assets/ui/fxml/ScoresView.fxml"));
        super.updateView();
    }
}
