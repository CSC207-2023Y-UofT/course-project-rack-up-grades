package EnterpriseBusiness;

import java.util.Objects;


public class GameEntity {
    private PositiveObj posObj;
    private NegativeObj negObj;

    public GameEntity(String level){
        // thinking of using a factory here to create the types
        if(Objects.equals(level, "e")){
        // Only makes the positive objects
            this.posObj = new PositiveObj(5);
            this.negObj = new NegativeObj(0);
        }
        else if(Objects.equals(level, "m")){

            //this.posObj = new Entities.PositiveObj(5);
            this.posObj = new PositiveObj(5);
            this.negObj = new NegativeObj(0);
        }
        else if(Objects.equals(level, "h")){

            this.posObj = new PositiveObj(5);
            this.negObj = new NegativeObj(5);
        }
    }

    public int getIncrement() {return this.posObj.getPoint();}

    public int getDecrement() {return this.negObj.getPoint();}

}
