package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.FXGLMenu;
import com.almasb.fxgl.scene.menu.MenuType;
import it.unibo.goffo.fag.FagUtils;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * An extension of {@link FXGLMenu} which creates main and game menu.
 * Also sets empty elements like profile, background, version and title view.
 */
public class FAGMenu extends FXGLMenu {

    private Parent menu;
    private final GameApplication app;

    /**
     * Creates the menu based on {@link MenuType}.
     * @param app to get menu associated with.
     * @param type menu type used by the game
     */
    public FAGMenu(final GameApplication app, final MenuType type) {
        super(app, type);

        this.app = app;

        if (type == MenuType.MAIN_MENU) {
            this.makeMainMenu();
        } else if (type == MenuType.GAME_MENU) {
            this.makeGameMenu();
        }

        menuRoot.getChildren().add(this.menu);
        contentRoot.getChildren().add(EMPTY);
    }

    private void makeMainMenu() {
        this.setFagMenu(FagUtils.MAIN_MENU_PATH);
    }

    private void makeGameMenu() {
        this.setFagMenu(FagUtils.GAME_MENU_PATH);
    }

    /**
     * Change current menu node by reading it from FXML file.
     * @param menuFile FXML file where to get menu.
     */
    protected final void setFagMenu(final String menuFile) {
        this.menu = this.readMenuFromFXML(menuFile);
    }

    /**
     * Updates {@link com.almasb.fxgl.scene.GameScene} by adding a new node.
     */
    protected void updateView() {
        this.app.getGameScene().addUINode(this.menu);
    }

    /**
     * Read a FXML file containing a menu.
     * @param fileName where to get menu.
     * @return loaded menu object
     */
    protected final Parent readMenuFromFXML(final String fileName) {
        Parent tmp = null;
        try {
            tmp = FXMLLoader.load(getClass().getResource(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void switchMenuTo(final Node menuBox) {
        super.switchMenuTo(menuBox);
        final Stage newStage = new Stage();
        newStage.setScene(new Scene((Parent) menuBox));
        newStage.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Button createActionButton(final String name, final Runnable action) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Button createActionButton(final StringBinding name, final Runnable action) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node createBackground(final double width, final double height) {
        return new Rectangle(0, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node createTitleView(final String title) {
        return FXGL.getUIFactory().newText(title, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node createVersionView(final String version) {
        return FXGL.getUIFactory().newText(version, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node createProfileView(final String profileName) {
        return FXGL.getUIFactory().newText(profileName, 0);
    }
}
