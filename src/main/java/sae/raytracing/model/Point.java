package sae.raytracing.model;

public class Point {

    private final Triplet coords;

    public Point(double x, double y, double z) {
        this.coords = new Triplet(x,y,z);
    }

    public Point(Triplet triplet) {
        this.coords = triplet;
    }

    @Override
    public String toString() {
        return getX()+", "+getY()+", "+getZ();
    }

    public double getX(){
        return coords.getX();
    }

    public double getY(){
        return coords.getY();
    }

    public double getZ(){
        return coords.getZ();
    }

    /**
     * Returns a Triplet corresponding the coordinates of the object.
     * @return the coordinates of the object
     */
    public Triplet getCoords() { return this.coords; }

    /**
     * @param  triplet  the triplet to subtract
     * @return          the result of the subtraction
     * @see Triplet#substraction(Triplet)
     */
    protected Triplet substraction(Triplet triplet) {
        return coords.substraction(triplet);
    }

    /**
     * @param  d        the double with which to multiply
     * @return          the result of the multiplication
     * @see Triplet#multiplyUsingAScalar(double)
     */
    protected Triplet multiplyUsingAScalar(double d) {
        return coords.multiplyUsingAScalar(d);
    }

    /*public static void main(String[] args){
        Point p1 = new Point(4,2,2);
        Point p2 = new Point(3,3,1);
        Vector sub = new Vector(p1.substraction(p2.coords));
        System.out.println("sub : "+sub.toString());
        System.out.println("multiply by a scalar : "+new Point(p1.multiplyUsingAScalar(3)));
    }*/
}
