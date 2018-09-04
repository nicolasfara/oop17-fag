package it.unibo.goffo.fag;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.extra.ai.pathfinding.AStarGrid;
import com.almasb.fxgl.parser.tiled.TiledMap;
import com.almasb.fxgl.settings.GameSettings;
import it.unibo.goffo.fag.animation.PlayerAnimationImpl;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.entities.Player;
import it.unibo.goffo.fag.entities.builders.FagEntities;
import it.unibo.goffo.fag.movement.EntityMovement;
import it.unibo.goffo.fag.movement.MoveDirection;
import it.unibo.goffo.fag.spawn.controller.SpawnControllerImpl;
import it.unibo.goffo.fag.spawn.view.SpawnView;
import it.unibo.goffo.fag.spawn.view.SpawnViewImpl;
import com.almasb.fxgl.ui.UI;
import it.unibo.goffo.fag.life.LifeController;
import it.unibo.goffo.fag.life.LifeControllerImpl;
import it.unibo.goffo.fag.ui.hud.HUDController;

import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;

import static it.unibo.goffo.fag.FagUtils.APPLICATION_NAME;
import static it.unibo.goffo.fag.FagUtils.HEIGHT_SCREEN;
import static it.unibo.goffo.fag.FagUtils.WIDTH_SCREEN;
import static it.unibo.goffo.fag.FagUtils.MAP_SIZE;


/**
 * Main class, used to launch FXGL.
 */
public class FightAvengeGuerrillaApp extends GameApplication {

    private AStarGrid grid;
    private Player player;
    private LifeController lifeController;

    /**
     * Main method launch the game engine.
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        launch(args);
    }

    /**
     * Return the grid used in the game.
     * @return the game's grid.
     */
    public AStarGrid getGrid() {
        return this.grid;
    }

    /**
     * Method that return the player in the game.
     * @return Return the player.
     */
    public Entity getPlayer() {
        return getGameWorld().getSingleton(FagType.PLAYER).get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSettings(final GameSettings settings) {
        settings.setWidth(WIDTH_SCREEN);
        settings.setHeight(HEIGHT_SCREEN);
        settings.setTitle(APPLICATION_NAME);
        this.lifeController = new LifeControllerImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onActionBegin() {
                player.playWalkAnimation(MoveDirection.RIGHT);
            }

            @Override
            protected void onAction() {
                player.moveRight();
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.RIGHT);
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onActionBegin() {
                player.playWalkAnimation(MoveDirection.LEFT);
            }

            @Override
            protected void onAction() {
                player.moveLeft();
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.LEFT);
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onActionBegin() {
                player.playWalkAnimation(MoveDirection.UP);
            }

            @Override
            protected void onAction() {
                player.moveUp();
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.UP);
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onActionBegin() {
                player.playWalkAnimation(MoveDirection.DOWN);
            }

            @Override
            protected void onAction() {
                player.moveDown();
            }

            @Override
            protected void onActionEnd() {
                player.playIdleAnimation(MoveDirection.DOWN);
            }
        }, KeyCode.S);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initGame() {
        grid = new AStarGrid(MAP_SIZE, MAP_SIZE);
        SpawnView spawnView = new SpawnViewImpl(SpawnControllerImpl.getInstance());
        spawnView.subscribeHandler(e -> Platform.runLater(() -> FXGL.getApp().getGameWorld().addEntity(e)));

        getGameWorld().addEntityFactory(new LevelFactory());
        TiledMap map = getAssetLoader().loadJSON("level0.json", TiledMap.class);
        getGameWorld().setLevelFromMap(map);

        player = (Player) FagEntities.builder(Player.class)
                .type(FagType.PLAYER)
                .at(200, 200)
                .with(new EntityMovement(1))
                .with(new PlayerAnimationImpl())
                .buildAndAttach(getGameWorld());
        /*lifeController.bindLife();*/
        this.getGameState().setValue("playerLife", 1.0);
    }

    /**
     * {@inheritDoc}Math.abs
     */
    @Override
    protected void initPhysics() {
        super.initPhysics();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initUI() {
        /*
         * No need to use FXMLLoader. FXGL's AssetLoader does the job.
         * Remember to not use 'fx:controller' attribute in your fxml file.
         */
        final HUDController hudController = new HUDController(getGameScene(), getGameState());
        final UI hud = getAssetLoader().loadUI("hud.fxml", hudController);

        /* NOT WORKING
        hudController.getPlayerLife().progressProperty().bind(this.absLifeController.getLifeProperty());
        */

        hudController.getPlayerLife().progressProperty().bind(
                this.getGameState().doubleProperty("playerLife"));
        getGameScene().addUI(hud);
    }
}
