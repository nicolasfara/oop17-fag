package it.unibo.goffo.fag.ui.hud;

import com.almasb.fxgl.ui.UIController;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * View Controller for HUD component.
 * Implements UIController in order to get loaded from FXGL assetloader.
 */
public class HUDController implements UIController {

    @FXML
    private ProgressBar playerLife;

    @FXML
    private Label round;

    @FXML
    private Label lblPoints;

    /**
     * Get life progress property. Used to bind to game engine and its properties with {@link com.almasb.fxgl.gameplay.GameState}.
     * @return life progress bar bindable {@link javafx.beans.property.Property}.
     */
    public DoubleProperty getLifeProgressProperty() {
        return this.playerLife.progressProperty();
    }

    /**
     * Get round progress property. Used to bind to game engine and its properties with {@link com.almasb.fxgl.gameplay.GameState}.
     * @return round progress (using a String value) bindable {@link javafx.beans.property.Property}.
     */
    public StringProperty getRoundProperty() {
        return this.round.textProperty();
    }

    /**
     * Get point progress property. Used to bind to game engine and its properties with {@link com.almasb.fxgl.gameplay.GameState}.
     * @return game points (using a String value) bindable {@link javafx.beans.property.Property}.
     */
    public StringProperty getPointsProperty() {
        return this.lblPoints.textProperty();
    }

    @Override
    public void init() {
    }
}
