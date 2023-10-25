package sae.raytracing.model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triplet {

    private double x;

    private double y;

    private double z;

    public Triplet(double x, double y, double z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    @Override
    public String toString() {
        return getX()+", "+getY()+", "+getZ();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    protected Triplet addition(Triplet triplet) {
        return new Triplet(this.x+triplet.getX(),this.y+triplet.getY(),this.z+triplet.getZ());
    }

    protected Triplet substraction(Triplet triplet) {
        return new Triplet(this.x-triplet.getX(),this.y-triplet.getY(),this.z-triplet.getZ());
    }

    protected Triplet multiplyUsingAScalar(double d) {
        return new Triplet(this.x*d,this.y*d,this.z*d);
    }

    protected double scalarProduct(Triplet triplet) {
        return this.x*triplet.getX() + this.y*triplet.getY() + this.z*triplet.getZ();
    }

    protected Triplet vectorProduct(Triplet triplet) {
        return new Triplet(this.y*triplet.getZ() - this.z*triplet.getY(), this.z*triplet.getX() - this.x*triplet.getZ(), this.x*triplet.getY() - this.y*triplet.getX());
    }

    protected Triplet schursProduct(Triplet triplet) {
        return new Triplet(this.x * triplet.getX(), this.y * triplet.getY(), this.z * triplet.getZ());
    }

    protected double length() {
        return sqrt(pow(this.x,2)+pow(this.y,2)+pow(this.z,2));
    }

    protected Triplet norm() {
        return multiplyUsingAScalar(1/length());
    }

    /*public static void main(String[] args) {
        Triplet t1 = new Triplet(3,4,5);
        Triplet t2 = new Triplet(3,4,5);
        System.out.println("addition : "+t1.addition(t2));
        System.out.println("Scalar product : "+t1.scalarProduct(t2));
        System.out.println("Vector product : "+t1.vectorProduct(t2));
        System.out.println("Schurs Product : "+t1.schursProduct(t2));
        System.out.println("Length : "+t1.length());
        System.out.println("Norm : "+t1.norm());
    }*/
}
