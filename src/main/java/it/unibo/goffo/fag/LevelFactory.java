package it.unibo.goffo.fag;

import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;

//@SetEntityFactory
public class LevelFactory implements EntityFactory {

    @Spawns("collidable")
    public Entity newCollidable(SpawnData data) {
        return Entities.builder()
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();

    }
}
