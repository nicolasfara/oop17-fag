package it.unibo.goffo.fag.ui.hud;

import com.almasb.fxgl.gameplay.GameState;
import com.almasb.fxgl.scene.GameScene;
import com.almasb.fxgl.ui.UIController;
import it.unibo.goffo.fag.life.LifeController;
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

    private final GameScene scene;
    private final GameState state;

    /**
     * Controller for in-game HUD.
     * @param scene used GameScene to interact with
     */
    public HUDController(final GameScene scene, final GameState state) {
        this.scene = scene;
        this.state = state;
    }

    public ProgressBar getPlayerLife() {
        return this.playerLife;
    }

    @FXML
    public void decreaseLife() {
        this.state.doubleProperty("playerLife").set(this.playerLife.getProgress() - 0.1);
        System.out.println(this.state.doubleProperty("playerLife").get());
        System.out.println((this.playerLife.getProgress()));
    }

    @FXML
    protected void initialize() {
    }

    @Override
    public void init() {
    }
}
