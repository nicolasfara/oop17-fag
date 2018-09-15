package it.unibo.goffo.fag.ui.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

import java.util.List;
import java.util.stream.Collectors;

public class AbsMenuController {
    @FXML
    private TilePane buttons;

    private List<Button> btns;

    public void initialize() {
        this.btns = buttons.getChildren().stream()
                .filter(b -> b instanceof Button)
                .map(b -> (Button)b)
                .peek(this::bindDefaultButtonProperty)
                .collect(Collectors.toList());
/*        bindDefaultButtonProperty(this.btnStartGame);
        bindDefaultButtonProperty(this.btnScores);
        bindDefaultButtonProperty(this.btnExit);*/
    }

    private void bindDefaultButtonProperty(final Button btn) {
        btn.defaultButtonProperty().bind(btn.focusedProperty());
    }
}
