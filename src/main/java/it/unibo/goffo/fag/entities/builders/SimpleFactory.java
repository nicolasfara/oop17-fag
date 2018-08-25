package it.unibo.goffo.fag.entities.builders;

import com.almasb.fxgl.app.FXGL;
import it.unibo.goffo.fag.entities.FagType;
import it.unibo.goffo.fag.entities.Player;
import it.unibo.goffo.fag.entities.Zombie;

public class SimpleFactory {

    Player player = (Player) FagEntities.builder(Player.class)
            .at(100, 100)
            .type(FagType.PLAYER)
            .buildAndAttach(FXGL.getApp().getGameWorld());

    Zombie zombie = (Zombie) FagEntities.builder(Zombie.class)
            .at(200, 200)
            .type(FagType.SIMPLE_ZOMBIE)
            .buildAndAttach(FXGL.getApp().getGameWorld());

}
