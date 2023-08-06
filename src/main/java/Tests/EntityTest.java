
package Tests;


import EnterpriseBusiness.GameEntity;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EntityTest {

    @Test
    public void testAllEntities(){
        GameEntity entEasy = new GameEntity("e");
        GameEntity entMid = new GameEntity("m");
        GameEntity entHard = new GameEntity("h");

        // This is to check if the game entity initialized the positive and negative objects correctly
        assertTrue(entEasy.getDecrement() <= 0);
        assertTrue(entEasy.getIncrement() > 0);

        assertTrue(entMid.getDecrement() <= 0);
        assertTrue(entMid.getIncrement() > 0);

        assertTrue(entHard.getDecrement() < 0);
        assertTrue(entHard.getIncrement() > 0);
    }


}
