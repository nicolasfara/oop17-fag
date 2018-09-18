package it.unibo.goffo.fag.entities.spawn.logic;

import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

/**
 * Test all spawn mode.
 */
public class SpawnLogicTest {

    /**
     *  Test only the linear spawn logic.
     */
    @Test
    public void testLinearLogic() {
        final int expected = 22;
        final SpawnLogic spawnLogic = new SpawnLogicImpl();
        for (int i = 0; i < 10; i++) {
            spawnLogic.getNextCount();
        }
        assertThat(spawnLogic.getNextCount()).isEqualTo(expected);
    }

    /**
     * Test exponential logic.
     */
    @Test
    public void testExponentialLogic() {
        final int expected = 8;
        final SpawnLogic spawnLogic = new SpawnLogicImpl();
        spawnLogic.setSpawnType(SpawnLogic.SpawnMode.EXPONENTIAL);
        for (int i = 0; i < 3; i++) {
            spawnLogic.getNextCount();
        }
        //After 3 iteration: 2^0 2^1 2^2 = 4
        //Next call must produce 2^3 = 8
        assertThat(spawnLogic.getNextCount()).isEqualTo(expected);
    }

    /**
     * Test the switch between modes.
     */
    @Test
    public void testSwitchMode() {
        final int expectedLinear = 8;
        final int expectedExponential = 256;
        final SpawnLogic spawnLogic = new SpawnLogicImpl();
        spawnLogic.setSpawnType(SpawnLogic.SpawnMode.LINEAR);
        for (int i = 0; i < 3; i++) {
            spawnLogic.getNextCount();
        }
        spawnLogic.setSpawnType(SpawnLogic.SpawnMode.EXPONENTIAL);
        int count = spawnLogic.getNextCount();
        assertThat(count).isEqualTo(expectedLinear);
        for (int i = 0; i < 4; i++) {
            spawnLogic.getNextCount();
        }
        count = spawnLogic.getNextCount();
        assertThat(count).isEqualTo(expectedExponential);
    }
}
