package it.unibo.goffo.fag.entities.builders;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import com.almasb.fxgl.entity.RenderLayer;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.texture.AnimatedTexture;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Utility class for create Fag entities.
 * Example usage:
 * <pre>
 *     {@code
 *     Player player = (Player) FagEntities.builder(Player.class)
 *          .at(100, 100)
 *          .type(EntitiesType.PLAYER)
 *          .buildAndAttach(getGameWorld);
 *
 *     Zombie zombie = (Zombie) FagEntities.builder(Zombie.class)
 *          .at(200, 200)
 *          .type(EntitiesType.ZOMBIE)
 *          .buildAndAttach(getGameWorld);
 *      }
 * </pre>
 * Note: The cast is mandatory a wrong cast cause a ClassCastException.
 */
public final class FagEntities {

    private FagEntities() { }

    /**
     * return a player builder specify a type for building the entity.
     * @param types entity type.
     * @param <T> Object type to create.
     * @return player builder.
     */
    public static <T extends Entity> EntityBuilder<T> builder(final Class<T> types) {
        return new EntityBuilder<>(types);
    }

    /**
     * Generic class to create entity by given class.
     * @param <U> Object type to be created (The specified class MUST extend Entity).
     */
    public static final class EntityBuilder<U extends Entity> {

        private U player;

        private EntityBuilder(final Class<U> types) {
            try {
                player = types.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }

        /**
         * Set the type at the player entity.
         * @param type the entity type.
         * @return instance class.
         */
        public EntityBuilder type(final Enum type) {
            player.setType(type);
            return this;
        }

        /**
         * Set the position of the entity.
         * @param x x coordinate.
         * @param y y coordinate
         * @return instance class.
         */
        public EntityBuilder at(final double x, final double y) {
            player.setPosition(x, y);
            return this;
        }

        /**
         * Set the position of the entity.
         * @param position position.
         * @return instance class.
         */
        public EntityBuilder at(final Point2D position) {
            at(position.getX(), position.getY());
            return this;
        }

        /**
         * Set the position of the entity.
         * @param position position.
         * @return instance class.
         */
        public EntityBuilder at(final Vec2 position) {
            at(position.x, position.y);
            return this;
        }

        /**
         * Rotate the entity by the given angle.
         * @param angle the angle to rotate.
         * @return instance class.
         */
        public EntityBuilder rotate(final double angle) {
            player.setRotation(angle);
            return this;
        }

        /**
         * Set a bounding box to the entity.
         * @param box the bounding box.
         * @return instance class.
         */
        public EntityBuilder bbox(final HitBox box) {
            player.getBoundingBoxComponent().addHitBox(box);
            return this;
        }

        /**
         * Attach the entity to a JavFX node, typical a shape.
         * @param view the node view.
         * @return instance class.
         */
        public EntityBuilder viewFromNode(final Node view) {
            player.getViewComponent().setView(view);
            return this;
        }

        /**
         * Attach the entity to a JavFX node, typical a shape with bounding box.
         * @param view the node.
         * @return instance class.
         */
        public EntityBuilder viewFromNodeWithBBox(final Node view) {
            player.getViewComponent().setView(view, true);
            return this;
        }

        /**
         * Set a texture to the entity.
         * @param textureName texture name (in resources folder).
         * @return instance class.
         */
        public EntityBuilder viewFromTexture(final String textureName) {
            player.getViewComponent().setTexture(textureName);
            return this;
        }

        /**
         * Set a texture to the entity with bounding box.
         * @param textureName texture name.
         * @return instance class.
         */
        public EntityBuilder viewFromTextureWithBBox(final String textureName) {
            player.getViewComponent().setTexture(textureName, true);
            return this;
        }

        /**
         * Set an animated texture to the entity.
         * @param texture texture object.
         * @return instance class.
         */
        public EntityBuilder viewFromAnimatedTexture(final AnimatedTexture texture) {
            player.getViewComponent().setAnimatedTexture(texture, true, false);
            return this;
        }

        /**
         * Set an animated texture to the entity, loop mode.
         * @param texture texture object.
         * @param loop loop mode, true loop the animation, otherwise static texture is used.
         * @return instance class.
         */
        public EntityBuilder viewFromAnimatedTexture(final AnimatedTexture texture, final boolean loop) {
            player.getViewComponent().setAnimatedTexture(texture, loop, false);
            return this;
        }

        /**
         * Set an animated texture to the entity, loop mode. On animation finish the entity can be removed.
         * @param texture texture object.
         * @param loop loop mode.
         * @param removeEntityOnFinish true if on finish the entity will removed, false otherwise.
         * @return instance class.
         */
        public EntityBuilder viewFromAnimatedTexture(final AnimatedTexture texture, final boolean loop, final boolean removeEntityOnFinish) {
            player.getViewComponent().setAnimatedTexture(texture, loop, removeEntityOnFinish);
            return this;
        }

        /**
         * Set an animated texture to the entity with frame number and the duration of the animation.
         * @param textureName texture name.
         * @param numFrames number of frames.
         * @param duration duration of the animation.
         * @return instance class.
         */
        public EntityBuilder viewFromAnimatedTexture(final String textureName, final int numFrames, final Duration duration) {
            player.getViewComponent().setAnimatedTexture(textureName, numFrames, duration, true, false);
            return this;
        }

        /**
         * Set an animated texture to the entity with frame number and the duration of the animation and the loop mode.
         * @param textureName texture name;
         * @param numFrames number of frames.
         * @param duration duration of animation.
         * @param loop true for loop animation, false otherwise.
         * @return instance class.
         */
        public EntityBuilder viewFromAnimatedTexture(final String textureName, final int numFrames, final Duration duration, final boolean loop) {
            player.getViewComponent().setAnimatedTexture(textureName, numFrames, duration, loop, false);
            return this;
        }

        /**
         * Set an animated texture to the entity with frame number and the duration of the animation and the loop mode.
         * Is possible to remove the entity on animation finished.
         * @param textureName texture name.
         * @param numFrames number of frames.
         * @param duration duration of the animation.
         * @param loop true for loop animation, false otherwise.
         * @param removeEntityOnFinish true remove the entity on finish, false never remove the entity.
         * @return instance class.
         */
        public EntityBuilder viewFromAnimatedTexture(final String textureName, final int numFrames, final Duration duration, final boolean loop, final boolean removeEntityOnFinish) {
            player.getViewComponent().setAnimatedTexture(textureName, numFrames, duration, loop, removeEntityOnFinish);
            return this;
        }

        /**
         * Render the entity on specific layer.
         * @param layer the layer.
         * @return instance class.
         */
        public EntityBuilder renderLayer(final RenderLayer layer) {
            player.getViewComponent().setRenderLayer(layer);
            return this;
        }

        /**
         * Set a component to the entity.
         * @param components the components.
         * @return instance class.
         */
        public EntityBuilder with(final Component... components) {
            for (Component c : components)
                player.addComponent(c);
            return this;
        }

        /**
         * Add a property to entity being built.
         * @param propertyKey property key.
         * @param propertyValue propertyValue.
         * @return instance class.
         */
        public EntityBuilder with(final String propertyKey, final Object propertyValue) {
            player.setProperty(propertyKey, propertyValue);
            return this;
        }

        /**
         * Finishes building entity.
         * @return entity
         */
        public U build() {
            return player;
        }

        /**
         * Finishes building the entity and attaches it to default game world.
         * @return entity
         */
        public U buildAndAttach() {
            return buildAndAttach(FXGL.getApp().getGameWorld());
        }

        /**
         * Finishes building the entity and attaches it to given world.
         * @param world the world to attach entity to
         * @return entity
         */
        public U buildAndAttach(final GameWorld world) {
            world.addEntity(player);
            return player;
        }
    }
}
