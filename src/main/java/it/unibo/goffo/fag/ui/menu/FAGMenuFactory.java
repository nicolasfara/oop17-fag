package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.FXGLMenu;
import com.almasb.fxgl.scene.SceneFactory;
import com.almasb.fxgl.scene.menu.MenuType;
import it.unibo.goffo.fag.ui.menu.endgame.FAGEndGameMenu;
import it.unibo.goffo.fag.ui.menu.score.FAGScoreMenu;
import org.jetbrains.annotations.NotNull;

/**
 * Factory for scenes used in FXGL.
 * Can create Main Menu, Game Menu, Scores Menu and End Game Menu.
 */
public class FAGMenuFactory extends SceneFactory {

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public FXGLMenu newMainMenu(final GameApplication app) {
        return new FAGMenu(app, MenuType.MAIN_MENU);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public FXGLMenu newGameMenu(final GameApplication app) {
        return new FAGMenu(app, MenuType.GAME_MENU);
    }

    /**
     * Called to construct scores menu.
     *
     * @param app game application
     * @return scores menu
     */
    @NotNull
    public FXGLMenu newScoresMenu(final GameApplication app) {
        return new FAGScoreMenu(app, MenuType.GAME_MENU);
    }


    /**
     * Called to construct scores menu.
     *
     * @param app game application
     * @return scores menu
     */
    @NotNull
    public FXGLMenu newEndGameMenu(final GameApplication app) {
        return new FAGEndGameMenu(app, MenuType.GAME_MENU);
    }
}
