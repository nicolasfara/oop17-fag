package it.unibo.goffo.fag.entities;

import com.almasb.fxgl.entity.Entity;

/**
 * Abstract class for weapon.
 */
public abstract class AbstractWeapon extends Entity {

    private double damage;

    /**
     * Build the object with the damage.
     */
    public AbstractWeapon() {
        super();
    }

    /**
     * Get the damage of this weapon.
     * @return the damage.
     */
    public double getDamage() {
        return damage;
    }

    /**
     *
      * @param newDamage
     */
    public void setDamage(final double newDamage) {
        this.damage = newDamage;
    }
}
