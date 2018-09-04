package it.unibo.goffo.fag.entities;

import com.almasb.fxgl.entity.Entity;

/**
 * Abstract class for weapon.
 */
public abstract class AbstractWeapon extends Entity {

    private final int damage;

    /**
     * Build the object with the damage.
     * @param damage the damage.
     */
    public AbstractWeapon(final int damage) {
        super();
        this.damage = damage;
    }

    /**
     * Get the damage of this weapon.
     * @return the damage.
     */
    public int getDamage() {
        return damage;
    }
}
