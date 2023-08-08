package EnterpriseBusiness;

public class PositiveObj {
    private int point;

    /**
     * create and instance of positive object
     * @param point what this object is worth when a click happens
     */
    PositiveObj(int point) {
        this.point = point;
    }

    /**
     * getter for point
     * @return point
     */
    public int getPoint() {
        return this.point;
    }
}
