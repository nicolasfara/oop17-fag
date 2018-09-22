package it.unibo.goffo.fag;

import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import it.unibo.goffo.fag.entities.FagType;

/**
 * Factory that creates the level parsing it from a given file.
 */
public class LevelFactory implements EntityFactory {
    /**
     * Borders are entities on the edges of the window,
     * meant to detect when another entity is leaving the playable area.
     * @param data data from the file.
     * @return an entity.
     */
    @Spawns("border")
    public Entity createBorder(final SpawnData data) {
        return Entities.builder()
                .type(FagType.BORDER)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new CollidableComponent(true))
                .with(new PhysicsComponent())
                .build();

    }

    /**
     * Walls are entities that prevent others to walk across them.
     * @param data data from the file.
     * @return an entity.
     */
    @Spawns("wall")
    public Entity crateWall(final SpawnData data) {
        return Entities.builder()
                .type(FagType.WALL)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();

    }
}
