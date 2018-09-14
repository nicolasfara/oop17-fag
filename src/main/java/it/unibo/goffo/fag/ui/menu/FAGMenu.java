package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.FXGLMenu;
import com.almasb.fxgl.scene.menu.MenuType;

import it.unibo.goffo.fag.FAGConfig;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class FAGMenu extends FXGLMenu {

    private Parent fagMenu;

    public FAGMenu(final GameApplication app, final MenuType type) {
        super(app, type);

        if (type == MenuType.MAIN_MENU) {
            this.makeMainMenu();
        } else if (type == MenuType.GAME_MENU) {
            this.makeGameMenu();
        }

        menuRoot.getChildren().add(this.fagMenu);
        contentRoot.getChildren().add(EMPTY);

        // USELESS ?
/*        activeProperty().addListener((observable, wasActive, isActive) -> {
            if (!isActive) {
                switchMenuTo(this.fagMenu);
                switchMenuContentTo(EMPTY);
            }
        });*/
}

    private void makeMainMenu() {
        this.setFagMenu(FAGConfig.MAIN_MENU_PATH);
    }

    private void makeGameMenu() {
        this.setFagMenu(FAGConfig.GAME_MENU_PATH);
    }

    protected void setFagMenu(final String menuFile) {
        this.fagMenu = this.readMenuFromFXML(menuFile);
    }

    protected void updateView() {
        FXGL.getApp().getGameScene().addUINode(this.fagMenu);
//        menuRoot.getChildren().set(0, this.fagMenu);
    }

    protected Parent readMenuFromFXML(final String fileName) {
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
        newStage.setScene(new Scene((Parent)menuBox));
        newStage.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void switchMenuContentTo(final Node content) {
        super.switchMenuContentTo(content);
//        contentRoot.getChildren().set(0, content);
    }

    @Override
    protected Button createActionButton(String name, Runnable action) {
        return null;
    }

    @Override
    protected Button createActionButton(StringBinding name, Runnable action) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node createBackground(final double width, final double height) {
        return new Rectangle(0,0);
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
    protected Node createVersionView(String version) {
        return FXGL.getUIFactory().newText(version, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node createProfileView(String profileName) {
        return FXGL.getUIFactory().newText(profileName, 0);
    }
}
