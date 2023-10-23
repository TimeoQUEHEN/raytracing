package sae.lanceurderayons.model;

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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Triplet addition(Triplet triplet) {
        return new Triplet(this.x+triplet.getX(),this.y+triplet.getY(),this.z+triplet.getZ());
    }

    public Triplet substraction(Triplet triplet) {
        return new Triplet(this.x-triplet.getX(),this.y-triplet.getY(),this.z-triplet.getZ());
    }

    public Triplet multiplyUsingAScalar(double d) {
        return new Triplet(this.x*d,this.y*d,this.z*d);
    }

    public Triplet scalarProduct(Triplet triplet) {
        return new Triplet(this.x*triplet.getX(),this.y*triplet.getY(),this.z*triplet.getZ());
    }

    public Triplet vectorProduct(Triplet triplet) {
        return new Triplet(this.y*triplet.getZ() - this.z*triplet.getY(), this.z*triplet.getX() - this.x*triplet.getZ(), this.x*triplet.getY() - this.y*triplet.getX());
    }

    public Triplet schursProduct(Triplet triplet) {
        return new Triplet(this.x * triplet.getX(), this.y * triplet.getY(), this.z * triplet.getZ());
    }

    public double length() {
        return sqrt(pow(this.x,2)+pow(this.y,2)+pow(this.z,2));
    }

    public Triplet norm() {
        return multiplyUsingAScalar(1/length());
    }
}
