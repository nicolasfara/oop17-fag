package it.unibo.goffo.fag.ui.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

/**
 *
 */
public class AbsMenuController {
    @FXML
    private TilePane buttons;

    /**
     *
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
