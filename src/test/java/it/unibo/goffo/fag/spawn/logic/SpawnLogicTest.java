package it.unibo.goffo.fag.spawn.logic;

import org.junit.Before;
import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class SpawnLogicTest {


    @Test
    public void testLinearLogic() {
        final SpawnLogic spawnLogic = new SpawnLogicImpl();
        for (int i = 0; i < 10; i++) {
            spawnLogic.getNextCount();
        }
        assertThat(spawnLogic.getNextCount()).isEqualTo(22);
    }

    @Test
    public void testQuadraticLogic() {
        final SpawnLogic spawnLogic = new SpawnLogicImpl();
        spawnLogic.setSpawnType(SpawnLogic.SpawnMode.EXPONENTIAL);
        for (int i = 0; i < 3; i++) {
            spawnLogic.getNextCount();
        }
        //After 3 iteration: 2^0 2^1 2^2 = 4
        //Next call must produce 2^3 = 8
        assertThat(spawnLogic.getNextCount()).isEqualTo(8);
    }

    @Test
    public void testSwitchMode() {
        final SpawnLogic spawnLogic = new SpawnLogicImpl();
        spawnLogic.setSpawnType(SpawnLogic.SpawnMode.LINEAR);
        for (int i = 0; i < 3; i++) {
            spawnLogic.getNextCount();
        }
        spawnLogic.setSpawnType(SpawnLogic.SpawnMode.EXPONENTIAL);
        int count = spawnLogic.getNextCount();
        assertThat(count).isEqualTo(8);
        for (int i = 0; i < 4; i++) {
            spawnLogic.getNextCount();
        }
        count = spawnLogic.getNextCount();
        assertThat(count).isEqualTo(256);
    }

}
