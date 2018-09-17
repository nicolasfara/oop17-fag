package it.unibo.goffo.fag.entities.builders;

import com.almasb.fxgl.ai.AIControl;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.extra.ai.pathfinding.AStarNode;
import com.almasb.fxgl.extra.ai.pathfinding.NodeState;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import it.unibo.goffo.fag.FightAvengeGuerrillaApp;
import it.unibo.goffo.fag.ai.controller.AStarMoveController;
import it.unibo.goffo.fag.ai.controller.RandomMoveController;
import it.unibo.goffo.fag.animation.ZombieAnimationImpl;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.entities.Zombie;
import it.unibo.goffo.fag.life.Damage;
import it.unibo.goffo.fag.life.controller.LifeControllerImpl;
import it.unibo.goffo.fag.movement.EntityMovement;
import javafx.geometry.Point2D;

import java.util.List;
import java.util.stream.Collectors;

import static it.unibo.goffo.fag.FagUtils.*;

/**
 * Factory for zombie creation.
 */
public final class ZombieFactory {

    private static final double SIMPLE_DAMAGE = 0.1;
    private static final double ADVANCE_DAMAGE = 0.2;

    private ZombieFactory() { }

    /**
     * Create a simple zombie with random AI.
     * @return the zombie.
     */
    public static Zombie createSimpleZombie() {
        return (Zombie) FagEntities.builder(Zombie.class)
                .at(randomPoint())
                .type(FagType.SIMPLE_ZOMBIE)
                .with(new ZombieAnimationImpl())
                .with(new CollidableComponent(true))
                .bbox(new HitBox(BoundingShape.box(ZOMBIE_SIZE_X, ZOMBIE_SIZE_Y)))
                .with(new EntityMovement(1))
                .with(new LifeControllerImpl(1))
                .with(new Damage(SIMPLE_DAMAGE))
                .with(new RandomMoveController())
                .with(new AIControl("random.tree"))
                .build();
    }

    /**
     * Create an advanced zombie with path-finding AI to follow the player.
     * @return the zombie.
     */
    public static Zombie createAdvancedZombie() {
        return (Zombie) FagEntities.builder(Zombie.class)
                .at(randomPoint())
                .type(FagType.ADVANCE_ZOMBIE)
                .with(new ZombieAnimationImpl())
                .with(new CollidableComponent(true))
                .bbox(new HitBox(BoundingShape.box(ZOMBIE_SIZE_X, ZOMBIE_SIZE_Y)))
                .with(new EntityMovement(1))
                .with(new LifeControllerImpl(1))
                .with(new Damage(ADVANCE_DAMAGE))
                .with(new AStarMoveController())
                .with(new AIControl("astar.tree"))
                .build();
    }

    private static Point2D randomPoint() {
        final List<AStarNode> aStarNodes = FXGL.<FightAvengeGuerrillaApp>getAppCast().getGrid().getNodes().stream()
                .filter(e -> e.getState() == NodeState.WALKABLE)
                .collect(Collectors.toList());
        return new Point2D(FXGLMath.random(aStarNodes).get().getX() * TILE_SIZE, FXGLMath.random(aStarNodes).get().getY() * TILE_SIZE);
    }
}

