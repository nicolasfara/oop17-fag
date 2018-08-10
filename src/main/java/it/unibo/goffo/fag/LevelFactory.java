package it.unibo.goffo.fag;

import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import it.unibo.goffo.fag.animation.FagControl;
import it.unibo.goffo.fag.entities.FagType;

//@SetEntityFactory
public class LevelFactory implements EntityFactory {

    @Spawns("collidable")
    public Entity newCollidable(SpawnData data) {
        return Entities.builder()
                .type(FagType.WALL)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new CollidableComponent(true))
                .build();
    }
    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        return Entities.builder()
                .type(FagType.PLAYER)
                .at(400,300)
                .with(new CollidableComponent(true))
                .with(new FagControl())
                .build();
    }
}
