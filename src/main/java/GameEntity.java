import java.util.ArrayList;
import java.util.Objects;


public class GameEntity {
    private int time;
    private PositiveObj posObj;
    private NegativeObj negObj;

    public GameEntity(String level){
        // thinking of using a factory here to create the types
        if(Objects.equals(level, "e")){
        // Only makes the positive objects
            this.time = 1;
            //this.posObj = new PositiveObj(5);
        }
        else if(Objects.equals(level, "m")){
            this.time = 1;
            //this.posObj = new PositiveObj(5);
        }
        else if(Objects.equals(level, "h")){
            this.time = 1;
            //this.posObj = new PositiveObj(5);
            this.negObj = new NegativeObj(5);
        }
        //else{
            // return "enter correct level";
        //}
    }

    public int getTime(){
        return this.time;
    }

}
