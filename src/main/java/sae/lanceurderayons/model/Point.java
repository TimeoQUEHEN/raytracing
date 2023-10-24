package sae.lanceurderayons.model;

public class Point {

    private Triplet coords;

    public Point(double x, double y, double z) {
        this.coords = new Triplet(x,y,z);
    }

    public Point(Triplet triplet) {
        this.coords=triplet;
    }

    public Triplet getTriplet() {
        return this.coords;
    }

    @Override
    public String toString() {
        return this.getX()+", "+getY()+", "+getZ();
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

    protected Triplet subtraction(Triplet triplet) {
        return coords.subtraction(triplet);
    }

    protected Triplet multiplyUsingAScalar(double d) {
        return coords.multiplyUsingAScalar(d);
    }

    public static void main(String[] args) {
        Point p1 = new Point(4,2,2);
        Point p2 = new Point(3,3,1);
        Vector sub = new Vector(p1.subtraction(p2.coords));
        System.out.println("sub : "+sub.getTriplet().toString());
        Point multiByScalar = new Point(p1.multiplyUsingAScalar(3));
        System.out.println("multiply by a scalar : "+multiByScalar.coords.toString());
    }
}
