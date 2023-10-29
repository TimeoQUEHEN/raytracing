package sae.raytracing.triplet;

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
     * @see Triplet#subtraction (Triplet)
     */
    public Triplet subtraction(Triplet triplet) {
        return coords.subtraction(triplet);
    }

    /**
     * @param  d        the double with which to multiply
     * @return          the result of the multiplication
     * @see Triplet#multiplyUsingAScalar(double)
     */
    public Triplet multiplyUsingAScalar(double d) {
        return coords.multiplyUsingAScalar(d);
    }
}