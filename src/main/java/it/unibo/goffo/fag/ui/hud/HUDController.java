package it.unibo.goffo.fag.ui.hud;

import com.almasb.fxgl.ui.UIController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class HUDController implements UIController {

    @FXML
    private ProgressBar playerLife;

    @FXML
    private Label lblPoints;

    @FXML
    private Button btnDecreaseLife;


    public ProgressBar getPlayerLife() {
        return this.playerLife;
    }

    @Override
    public void init() {
    }
}
