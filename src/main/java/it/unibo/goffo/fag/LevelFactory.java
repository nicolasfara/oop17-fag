package it.unibo.goffo.fag;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import it.unibo.goffo.fag.entities.FagType;

/**
 * This class aims to create the level parsing it from a given file.
 */
public class LevelFactory implements EntityFactory {

    /**
     * Spawns a wall entity every time the keyword wall is found while parsing the level.
     * @param data data from the file.
     * @return an entity.
     */
    @Spawns("wall")
    public Entity newWall(final SpawnData data) {
        return Entities.builder()
                .type(FagType.WALL)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();

    }
}
