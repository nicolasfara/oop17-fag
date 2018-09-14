package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.menu.MenuType;
import it.unibo.goffo.fag.FAGConfig;

public class FAGEndGameMenu extends FAGMenu {
    public FAGEndGameMenu(final GameApplication app, final MenuType type) {
        super(app, type);
        this.makeEndGameMenu();
    }

    private void makeEndGameMenu() {
        super.setFagMenu(FAGConfig.END_GAME_MENU_PATH);
        super.updateView();
    }
}
