package it.unibo.goffo.fag;

import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import it.unibo.goffo.fag.entities.FagType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class LevelFactory implements EntityFactory {

    @Spawns("circle")
    public Entity newCircle(final SpawnData data) {
        return Entities.builder()
                .type(FagType.WALL)
                .viewFromNode(new Circle(32, Color.BLUE))
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();

    }

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
