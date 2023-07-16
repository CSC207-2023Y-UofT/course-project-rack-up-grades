import java.util.ArrayList;
import java.util.Objects;


public class GameEntity {
    private int time;
    private ArrayList<PositiveObj> posObj;
    private ArrayList<NegativeObj> negObj;

    public GameEntity(String level){
        // thinking of using a factory here to create the types
        if(Objects.equals(level, "e")){
        // Only makes the positive objects
            this.time = 1;
            ArrayList<PositiveObj> temp = new ArrayList<PositiveObj>();
            for(int i = 0 ; i < 9; i++){
             //temp.add(new PositiveObj(Integer.toString(i), 5));
            }
            this.posObj = temp;
        }
        else if(Objects.equals(level, "m")){
            this.time = 1;
            ArrayList<PositiveObj> temp = new ArrayList<PositiveObj>();
            for(int i = 0 ; i < 9; i++){
                //temp.add(new PositiveObj(Integer.toString(i), 5));
            }
            this.posObj = temp;
        }
        else if(Objects.equals(level, "h")){
            this.time = 1;
            ArrayList<PositiveObj> temp = new ArrayList<PositiveObj>();
            for(int i = 0 ; i < 9; i++){
                //temp.add(new PositiveObj(Integer.toString(i), 5));
            }
            ArrayList<NegativeObj> temp2 = new ArrayList<NegativeObj>();
            for(int i = 0 ; i < 9; i++){
                temp2.add(new NegativeObj(Integer.toString(i), -5));
            }
            this.posObj = temp;
            this.negObj = temp2;
        }
        //else{
            // return "enter correct level";
        //}
    }

    public int getTime(){
        return this.time;
    }

}
