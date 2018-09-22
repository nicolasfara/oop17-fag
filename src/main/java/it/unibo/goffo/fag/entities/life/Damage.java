package it.unibo.goffo.fag.entities.life;

import com.almasb.fxgl.entity.component.Component;

/**
 * Damage component.
 */
public class Damage extends Component {
    private double dmg;

    /**
     * Build the dmg object with a dmg.
     * @param damage the dmg.
     */
    public Damage(final double damage) {
        super();
        this.dmg = damage;
    }

    /**
     * Get the dmg.
     * @return the dmg.
     */
    public double getDamage() {
        return dmg;
    }

    /**
     * Set a new dmg.
     * @param newDamage the new dmg.
     */
    public void setDamage(final double newDamage) {
        this.dmg = newDamage;
    }
}
