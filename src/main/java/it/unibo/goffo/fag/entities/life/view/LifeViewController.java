package it.unibo.goffo.fag.entities.life.view;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

/**
 * View controller.
 * Used to get life bar displayed in HUD and get its property bound with {@link com.almasb.fxgl.gameplay.GameState}.
 */
public class LifeViewController {

    @FXML
    private ProgressBar playerLife;

    public DoubleProperty getProgressProperty() {
        return this.playerLife.progressProperty();
    }
}
