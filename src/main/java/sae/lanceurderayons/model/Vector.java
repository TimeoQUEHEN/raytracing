package sae.lanceurderayons.model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Vector {

    private Triplet destDirNorm;

    public Vector(double destination, double direction, double norm) {
        this.destDirNorm = new Triplet(destination,direction,norm);
    }

    public Vector(Triplet triplet) {
        this.destDirNorm=triplet;
    }

    public Triplet getTriplet() {
        return this.destDirNorm;
    }

    @Override
    public String toString() {
        return this.getDestination()+", "+getDirection()+", "+getNorm();
    }

    public double getDestination() {
        return this.destDirNorm.getX();
    }

    public double getDirection() {
        return this.destDirNorm.getY();
    }

    public double getNorm() {
        return this.destDirNorm.getZ();
    }

    protected Triplet addition(Triplet triplet) {
        return destDirNorm.addition(triplet);
    }

    protected Triplet subtraction(Triplet triplet) {
        return destDirNorm.subtraction(triplet);
    }

    protected Triplet multiplyUsingAScalar(double d) {
        return destDirNorm.multiplyUsingAScalar(d);
    }

    protected Triplet scalarProduct(Triplet triplet) {
        return destDirNorm.scalarProduct(triplet);
    }

    protected Triplet vectorProduct(Triplet triplet) {
        return destDirNorm.vectorProduct(triplet);
    }

    protected double length() {
        return destDirNorm.length();
    }

    protected Triplet norm() {
        return destDirNorm.norm();
    }
}