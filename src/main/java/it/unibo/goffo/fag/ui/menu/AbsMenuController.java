package it.unibo.goffo.fag.ui.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

/**
 * Abstract Menu Controller.
 * Contains buttons mapping from focused property to "default button" property to get "ENTER" key
 * based on current focused button.
 */
public class AbsMenuController {
    @FXML
    private TilePane buttons;

    /**
     * Executed after loading "@FXML" tagged properties.
     */
    public void initialize() {
        buttons.getChildren().stream()
                .filter(b -> b instanceof Button)
                .map(b -> (Button) b)
                .forEach(this::bindDefaultButtonProperty);
    }

    private void bindDefaultButtonProperty(final Button btn) {
        btn.defaultButtonProperty().bind(btn.focusedProperty());
    }
}
