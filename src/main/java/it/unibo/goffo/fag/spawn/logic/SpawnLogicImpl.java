package it.unibo.goffo.fag.spawner.logic;

import com.almasb.fxgl.core.math.FXGLMath;

/**
 * Concrete class realize the spawn logic.
 */
public class SpawnLogicImpl implements SpawnLogic {

    private int count;
    private int quadraticCount;
    private SpawnMode currentMode;
    private static final int LINEAR_FACTOR = 2;
    private static final int QUADRATIC_BASE = 2;

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNextCount() {
        switch (currentMode) {
            case LINEAR:
                count += LINEAR_FACTOR;
                break;
            case QUADRATIC:
                count = FXGLMath.round(FXGLMath.pow(QUADRATIC_BASE, quadraticCount++));
                break;
                default:
                    throw new IllegalArgumentException("Ordinal not present in the enum");
        }
        return count;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSpawnType(final SpawnMode mode) {
        currentMode = mode;
    }
}
