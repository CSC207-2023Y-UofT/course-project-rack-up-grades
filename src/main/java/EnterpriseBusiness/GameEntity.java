package EnterpriseBusiness;

import java.util.Objects;


public class GameEntity {
    private PositiveObj posObj;
    private NegativeObj negObj;

    /**
     * create an instance of GameEntity, it will create positive and negative objects
     * @param level the difficulty of the game where this is called
     */
    public GameEntity(String level){
        // thinking of using a factory here to create the types

        //for easy mode
        if(Objects.equals(level, "e")){
        // Only makes the positive objects
            this.posObj = new PositiveObj(5);
            this.negObj = new NegativeObj(0);
        }

        //for medium mode
        else if(Objects.equals(level, "m")){

            //this.posObj = new Entities.PositiveObj(5);
            this.posObj = new PositiveObj(5);
            this.negObj = new NegativeObj(0);
        }
        //for hard mode
        else if(Objects.equals(level, "h")){

            this.posObj = new PositiveObj(5);
            this.negObj = new NegativeObj(10);
        }
    }

    /**
     * getter for how much to add for click good object
     * @return positive objects point
     */
    public int getIncrement() {return this.posObj.getPoint();}

    /**
     * getter for how much a bomb should subtract
     * @return negative object's point
     */
    public int getDecrement() {return this.negObj.getPoint();}

}
