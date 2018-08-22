package it.unibo.goffo.fag.life;

import com.almasb.fxgl.app.FXGL;
import javafx.beans.property.DoubleProperty;

public class LifeController {

    private final LifeModel<Double> life;

    private static final Double MAX_LIFE = 1.0;

    public LifeController() {
        life = new LifeModelImpl.Builder()
                .setMaxLife(MAX_LIFE)
                .startFrom(MAX_LIFE)
                .build();
    }

    /*
    public void bindLife() {
        FXGL.getApp().getGameState().doubleProperty("life").bind(this.getLifeProperty());
/*        this.getLifeProperty().bind(FXGL.getApp().getGameState().intProperty("life"));
    }*/

    /*public DoubleProperty getLifeProperty() {
        return this.life.getProperty();
    }*/

    public double getLife() {
        return this.life.getLife();
    }

    public void decreaseLife(final double amount) throws GameOverException {
        this.life.setLife(this.life.getLife() - Math.abs(amount));
        System.out.println(this.life.getLife());
        if (Double.compare(this.life.getLife(), 0) < 0) {
            throw new GameOverException();
        }
    }
}
