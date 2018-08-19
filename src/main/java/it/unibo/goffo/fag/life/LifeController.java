package it.unibo.goffo.fag.life;

import com.almasb.fxgl.app.FXGL;

public class LifeController {

    private final LifeImpl life;

    private static final int MAX_LIFE = 100;

    private LifeController() {
        life = new LifeImpl.Builder()
                .setMaxLife(MAX_LIFE)
                .startFrom(MAX_LIFE)
                .build();
    }

    public void bindLife() {
        life.lifeProperty().bind(FXGL.getApp().getGameState().intProperty("life"));
    }
}
