package it.unibo.goffo.fag.ui.menu.score;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.menu.MenuType;
import it.unibo.goffo.fag.FagUtils;
import it.unibo.goffo.fag.ui.menu.FAGMenu;

public class FAGScoreMenu extends FAGMenu {

    public FAGScoreMenu(final GameApplication app, final MenuType type) {
        super(app, type);
        this.makeScoresMenu();
    }

    private void makeScoresMenu() {
        super.switchMenuTo(super.readMenuFromFXML(FagUtils.SCORE_MENU_PATH));
/*        super.setFagMenu(FAGConfig.SCORE_MENU_PATH);
        super.updateView();*/
    }
}
