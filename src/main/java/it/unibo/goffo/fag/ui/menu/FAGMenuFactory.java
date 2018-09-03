package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.FXGLMenu;
import com.almasb.fxgl.scene.SceneFactory;
import com.almasb.fxgl.scene.menu.MenuType;
import org.jetbrains.annotations.NotNull;

public class FAGMenuFactory extends SceneFactory {

    @NotNull
    @Override
    public FXGLMenu newMainMenu(final GameApplication app) {
        return new FAGMenu(app, MenuType.MAIN_MENU);
    }
}
