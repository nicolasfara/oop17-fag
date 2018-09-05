package it.unibo.goffo.fag.life;

import com.almasb.fxgl.entity.component.Component;

/**
 * Damage component.
 */
public class Damage extends Component {
    private double damage;

    /**
     * Build the damage object with a damage.
     * @param damage the damage.
     */
    public Damage(final double damage) {
        this.damage = damage;
    }

    /**
     * Get the damage.
     * @return the damage.
     */
    public double getDamage() {
        return damage;
    }

    /**
     * Set a new damage.
     * @param newDamage the new damage.
     */
    public void setDamage(final double newDamage) {
        this.damage = newDamage;
    }
}
