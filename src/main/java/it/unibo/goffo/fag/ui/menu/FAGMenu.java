package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.FXGLMenu;
import com.almasb.fxgl.scene.menu.MenuType;
import com.almasb.fxgl.ui.UI;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;

public class FAGMenu extends FXGLMenu {

    private MainMenuController mainMenuController;
    private UI fxmlUI;
    private Node fagMenu;

    public FAGMenu(final GameApplication app, final MenuType type) {
        super(app, type);

        /*
            Questo approccio pare non funzionare:
                non quando si va a chiamare createTitleView dà nullPointerException
                su mainMenuController
         */
/*        this.mainMenuController = newImpl MainMenuController();
        this.fxmlUI = FXGL.getAssetLoader().loadUI("mainMenu.fxml", this.mainMenuController);
        app.getGameScene().addUI(fxmlUI);*/

        try {
            fagMenu = FXMLLoader.load(getClass().getResource("/assets/ui/mainMenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        menuRoot.getChildren().add(this.fagMenu);
        contentRoot.getChildren().add(EMPTY);

        activeProperty().addListener((observable, wasActive, isActive) -> {
            if (!isActive) {
                switchMenuTo(this.fagMenu);
                switchMenuContentTo(EMPTY);
            }
        });
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
        Rectangle bg = new Rectangle(width, height);
        bg.setFill(Color.BLUE);
        return bg;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node createTitleView(final String title) {

        /*mainMenuController.setMenuTitle(title);
        return mainMenuController.getMenuTitle();*/


        Text text = FXGL.getUIFactory().newText(title, 50);

        StackPane titleRoot = new StackPane();
        titleRoot.getChildren().addAll(text);

        titleRoot.setTranslateX(app.getWidth() / 2.0 - (text.getLayoutBounds().getWidth() + 20) / 2);
        titleRoot.setTranslateY(50);
        return titleRoot;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node createVersionView(String version) {
        Text view = FXGL.getUIFactory().newText(version);
/*        view.setTranslateY(app.getHeight() - 2);*/
        return view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node createProfileView(String profileName) {
        Text view = FXGL.getUIFactory().newText(profileName);
/*        view.setTranslateY(app.getHeight() - 2);
        view.setTranslateX(app.getWidth() - view.getLayoutBounds().getWidth());*/
        return view;
    }
}
