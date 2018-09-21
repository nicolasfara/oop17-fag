package it.unibo.goffo.fag.ui.menu.endgame;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.menu.MenuType;
import it.unibo.goffo.fag.FagUtils;
import it.unibo.goffo.fag.ui.menu.FAGMenu;

/**
 * End Game menu.
 */
public class FAGEndGameMenu extends FAGMenu {

    /**
     * Create new End Game Menu.
     * @param app game application.
     * @param type menu type.
     */
    public FAGEndGameMenu(final GameApplication app, final MenuType type) {
        super(app, type);
        this.makeEndGameMenu();
    }

    private void makeEndGameMenu() {
        super.setFagMenu(FagUtils.END_GAME_MENU_PATH);
        super.updateView();
    }
}
