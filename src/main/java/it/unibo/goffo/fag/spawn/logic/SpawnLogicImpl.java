package it.unibo.goffo.fag.spawn.logic;

import com.almasb.fxgl.core.math.FXGLMath;

/**
 * Concrete class realize the spawn logic.
 */
public class SpawnLogicImpl implements SpawnLogic {

    private int linearCount;
    private int quadraticCount;
    private SpawnMode currentMode;
    private static final int LINEAR_FACTOR = 2;
    private static final int EXPONENTIAL_BASE = 2;

    /**
     * Initialize all property.
     */
    public SpawnLogicImpl() {
        linearCount = 0;
        quadraticCount = 0;
        currentMode = SpawnMode.LINEAR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNextCount() {
        switch (currentMode) {
            case LINEAR:
                linearCount += LINEAR_FACTOR;
                break;
            case EXPONENTIAL:
                linearCount = FXGLMath.round(FXGLMath.pow(EXPONENTIAL_BASE, quadraticCount++));
                break;
                default:
                    throw new IllegalArgumentException("Ordinal not present in the enum");
        }
        return linearCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSpawnType(final SpawnMode mode) {
        switchMode(mode);
        currentMode = mode;
    }

    private void switchMode(final SpawnMode mode) {
        if (currentMode == SpawnMode.LINEAR && mode == SpawnMode.EXPONENTIAL) {
            quadraticCount = FXGLMath.round(FXGLMath.log(EXPONENTIAL_BASE, linearCount));
        } else if (currentMode == SpawnMode.EXPONENTIAL && mode == SpawnMode.LINEAR) {
            linearCount = quadraticCount;
        }
    }
}
