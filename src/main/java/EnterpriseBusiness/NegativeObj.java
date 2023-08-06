package EnterpriseBusiness;

public class NegativeObj {
    // This is the class that creates the negative objects and its getter and setters

    private int point;

    /**
     * create an instance of this class and point is always negative for any param
     * @param point the amount to subtract when a bomb is clicked
     */
    public NegativeObj(int point){
        //the point has to be negative
        if(Math.signum(point) >= 0){
            this.point = - point;
        }
        else{
            this.point = point;
        }

    }

    /**
     * getter for pouint
     * @return point
     */
    public int getPoint(){
        return this.point;
    }
}
