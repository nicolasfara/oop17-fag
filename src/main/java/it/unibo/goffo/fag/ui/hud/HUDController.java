package it.unibo.goffo.fag.ui.hud;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.gameplay.GameState;
import com.almasb.fxgl.scene.GameScene;
import com.almasb.fxgl.ui.UIController;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;
import it.unibo.goffo.fag.life.GameOverException;
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

    private final LifeController lifeController;

    private static final double LIFE_OFFSET = 0.1;

    /**
     * Controller for in-game HUD.
     * @param scene used GameScene to interact with
     */
    public HUDController(final GameScene scene, final GameState state) {
        this.scene = scene;
        this.state = state;
        this.lifeController = new LifeController();
    }

    public ProgressBar getPlayerLife() {
        return this.playerLife;
    }

    @FXML
    public void decreaseLife() {
        try {
            this.lifeController.decreaseLife(LIFE_OFFSET);
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        /* this.state.doubleProperty("playerLife").set(this.playerLife.getProgress() - 0.1); */
        /*state.setValue("playerLife", this.lifeController.getLife());*/
        System.out.println("doubleProperty = " + this.state.getDouble("playerLife"));
        System.out.println("Progress = " + this.playerLife.getProgress());
    }

    @FXML
    protected void initialize() {
    }

    @Override
    public void init() {
    }
}
