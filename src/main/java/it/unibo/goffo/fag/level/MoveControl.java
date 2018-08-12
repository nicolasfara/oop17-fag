package it.unibo.goffo.fag.level;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.BoundingBoxComponent;
import com.almasb.fxgl.entity.components.PositionComponent;
import it.unibo.goffo.fag.entities.FagType;

import java.util.List;

public class MoveControl extends Component{

    private PositionComponent position;
    private BoundingBoxComponent bbox;

    private List<Entity> walls;

    private List<Entity> initWalls(){
        return FXGL.getApp().getGameWorld().getEntitiesByType(FagType.WALL);
    }

    private void move(double dx, double dy) {
        if (!getEntity().isActive())
            return;

        if (walls == null) {
            walls = initWalls();
        }

        double mag = Math.sqrt(dx * dx + dy * dy);
        long length = Math.round(mag);

        double unitX = dx / mag;
        double unitY = dy / mag;

        for (int i = 0; i < length; i++) {
            position.translate(unitX, unitY);

            boolean collision = false;

            for (int j = 0; j < walls.size(); j++) {
                if (walls.get(j).getBoundingBoxComponent().isCollidingWith(bbox)) {
                    collision = true;
                    break;
                }
            }

            if (collision) {
                position.translate(-unitX, -unitY);
                break;
            }
        }
    }

}
