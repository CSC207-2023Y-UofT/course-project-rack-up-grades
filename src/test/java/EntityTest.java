import EnterpriseBusiness.GameEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityTest {

    /**
     * test if entities are being initialized properly
     */
    @Test
    public void testAllEntities(){
        GameEntity entEasy = new GameEntity("e");
        GameEntity entMid = new GameEntity("m");
        GameEntity entHard = new GameEntity("h");

        // This is to check if the game entity initialized the positive and negative objects correctly
        Assertions.assertTrue(entEasy.getDecrement() <= 0);
        Assertions.assertTrue(entEasy.getIncrement() > 0);

        Assertions.assertTrue(entMid.getDecrement() <= 0);
        Assertions.assertTrue(entMid.getIncrement() > 0);

        Assertions.assertTrue(entHard.getDecrement() < 0);
        Assertions.assertTrue(entHard.getIncrement() > 0);
    }


}
