package it.unibo.goffo.fag.spawner.logic;

/**
 * Interface used to realize the spawn logic.
 */
public interface SpawnLogic {
    /**
     * Enum to specify which mode the spawn must use.
     */
    enum SpawnMode {
        LINEAR,
        QUADRATIC
    }

    /**
     * Method that calculate the number of entity to spawn at each call of this method.
     * @return the number of entity to spawn.
     */
    int getNextCount();

    /**
     * Set the spawn mode.
     * @param mode the spawn mode.
     */
    void setSpawnType(SpawnMode mode);
}
