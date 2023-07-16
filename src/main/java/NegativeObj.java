public class NegativeObj {
    // This is the class that creates the negative objects and its getter and setters

    private float point;


    public NegativeObj(String name, int point){
        //the point has to be negative
        if(Math.signum(point) >= 0){
            this.point = - point;
        }
        else{
            this.point = point;
        }

    }

    public float getPoint(){
        return this.point;
    }
}

abstract class PositiveObj{
    private float point;

}
