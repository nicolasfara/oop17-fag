package it.unibo.goffo.fag.ui.hud;

import com.almasb.fxgl.ui.UIController;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class HUDController implements UIController {

    @FXML
    private ProgressBar playerLife;

    @FXML
    private Label lblPoints;

    @FXML private Label round;

    public DoubleProperty getProgressProperty() {
        return this.playerLife.progressProperty();
    }

    public StringProperty getRound() {
        return this.round.textProperty();
    }

    @Override
    public void init() {
    }
}
