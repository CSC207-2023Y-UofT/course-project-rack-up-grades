public class NegativeObj {
    // This is the class that creates the negative objects and its getter and setters
    private double PRIVATE = 1.2;
    private float point;

    private String name;

    public NegativeObj(String name, int point){
        //the point has to be negative
        this.name = name;
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

    public String getName(){
        return this.name;
    }
}

abstract class PositiveObj{
    private double PRIVATE = 1.2;
    private float point;

    private String name;
}
