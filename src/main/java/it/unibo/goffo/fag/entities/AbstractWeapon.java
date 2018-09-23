package it.unibo.goffo.fag.entities;

import com.almasb.fxgl.entity.Entity;

/**
 * Abstract class for weapon.
 */
public abstract class AbstractWeapon extends Entity {

    private double damage;

    /**
     * Get the damage of this weapon.
     * @return the damage.
     */
    public double getDamage() {
        return damage;
    }

    /**
     *
      * @param newDamage Damage of the weapon
     */
    public void setDamage(final double newDamage) {
        this.damage = newDamage;
    }
}
