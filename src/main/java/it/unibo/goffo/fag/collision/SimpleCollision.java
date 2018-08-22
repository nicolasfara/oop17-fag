package it.unibo.goffo.fag.collision;

import com.almasb.fxgl.entity.Entity;


public class SimpleCollision extends AbstractCollision {

    private final Entity oneEntity, twoEntity;

    SimpleCollision(final Entity firstEntity, final Entity secondEntity) {
        super();
        this.oneEntity = firstEntity;
        this.twoEntity = secondEntity;
    }

    /**
     *
     * @param one first entity
     * @param two second entity
     */
    @Override
    protected void onCollision(final Entity one, final Entity two) {
        // qualcosa che al momento mi sfugge, forse inutile in questa modalità
    }

    /**
     *
     * @param player player entity
     * @param zombie zombie entity
     */
    protected void playerZombieCollision(final Entity player, final Entity zombie) {
        // player perde vita
    }

    /**
     *
     * @param bullet bullet entity
     * @param zombie zombie entity
     */
    protected void bulletZombieCollision(final Entity bullet, final Entity zombie) {
        zombie.removeFromWorld();
    }

    /**
     *
     * @param player player entity
     * @param border wall entity
     */
    protected void playerBorderCollision(final Entity player, final Entity border) {
        // player non può oltrepassare il mure
    }

    /*
    public void onCollision(EntityType first, EntityType second) {
        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(first, second) {
                    @Override
                    protected void onCollisionBegin(Entity bullet, Entity zombie) {
                        zombie.removeFromWorld();
                    }
                });
    }
    */
}
