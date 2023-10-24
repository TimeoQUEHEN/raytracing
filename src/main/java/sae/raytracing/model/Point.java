package sae.raytracing.model;

public class Point {

    private Triplet coords;

    public Point(double x, double y, double z) {
        this.coords = new Triplet(x,y,z);
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

    protected Triplet substraction(Triplet triplet) {
        return coords.substraction(triplet);
    }

    protected Triplet multiplyUsingAScalar(double d) {
        return coords.multiplyUsingAScalar(d);
    }
}
