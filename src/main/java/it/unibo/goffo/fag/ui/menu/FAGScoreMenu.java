package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.menu.MenuType;
import it.unibo.goffo.fag.FAGConfig;

public class FAGScoreMenu extends FAGMenu {

    public FAGScoreMenu(final GameApplication app, final MenuType type) {
        super(app, type);
        this.makeScoresMenu();
    }

    private void makeScoresMenu() {
        super.switchMenuTo(super.readMenuFromFXML(FAGConfig.SCORE_MENU_PATH));
/*        super.setFagMenu(FAGConfig.SCORE_MENU_PATH);
        super.updateView();*/
    }
}
