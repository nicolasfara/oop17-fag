package it.unibo.goffo.fag.ui.menu;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.FXGLMenu;
import com.almasb.fxgl.scene.menu.MenuType;
import com.almasb.fxgl.ui.UI;

import javafx.beans.binding.StringBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;

public class FAGMenu extends FXGLMenu {

    private Parent fagMenu;

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

        if (type == MenuType.MAIN_MENU) {
            this.makeMainMenu();
        } else if (type == MenuType.GAME_MENU) {
            this.makeGameMenu();
        }

        menuRoot.getChildren().add(fagMenu);
        contentRoot.getChildren().add(EMPTY);

        activeProperty().addListener((observable, wasActive, isActive) -> {
            if (!isActive) {
                switchMenuTo(this.fagMenu);
                switchMenuContentTo(EMPTY);
            }
        });

        /*        final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        final Parent scene = FXMLLoader.load(getClass().getResource("/assets/ui/fxml/ScoresView.fxml"));
        stage.setScene(new Scene(scene, 800, 600));*/

        /*
            NOT WORKING
            i seguenti metodi sono chiamati nel costruttore, eseguito alla creazione del menù, ovvero della macchina a stati
            ma in quel momento ancora non è stato renderizzato nulla, quindi per questo non va
         */
/*        if (FXGL.getApp().getStateMachine().getCurrentState().equals(FXGL.getApp().getStateMachine().getIntroState())) {
            FXGL.getApp().getGameScene().getRoot().getChildren().add(this.fagMenu);
        }*/

/*        switchMenuTo(this.fagMenu);
        switchMenuContentTo(this.fagMenu);*/

        /*
        final Stage stage = (Stage) menuRoot.getChildren().get(0).getScene().getWindow();
        stage.setScene(new Scene(fagMenu, 800, 600));*/
    }

    private void makeMainMenu() {
        this.setFagMenu(this.readMenuFromFXML("/assets/ui/fxml/mainMenu.fxml"));
    }

    private void makeGameMenu() {
        this.setFagMenu(this.readMenuFromFXML("/assets/ui/fxml/gameMenu.fxml"));
    }

    protected void setFagMenu(final Parent parent) {
        this.fagMenu = parent;
    }

    protected void updateView() {
        FXGL.getApp().getGameScene().addUINode(this.fagMenu);
//        menuRoot.getChildren().set(0, this.fagMenu);
    }

    public void makeScoresMenu(final String scoresMenuFile) {
        this.fagMenu = this.readMenuFromFXML(scoresMenuFile);
        this.switchMenuContentTo(this.fagMenu);
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

        Node oldMenu = menuRoot.getChildren().get(0);
        menuBox.setOpacity(0);
        menuRoot.getChildren().set(0, menuBox);
        oldMenu.setOpacity(1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void switchMenuContentTo(final Node content) {
        super.switchMenuContentTo(content);
        contentRoot.getChildren().set(0, content);
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
