package sae.lanceurderayons.model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Vector {

    private Triplet destDirNorm;

    public Vector(double destination, double direction, double norm) {
        this.destDirNorm = new Triplet(destination,direction,norm);
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

    public Triplet addition(Triplet triplet) {
        return destDirNorm.addition(triplet);
    }

    public Triplet substraction(Triplet triplet) {
        return destDirNorm.substraction(triplet);
    }

    public Triplet multiplyUsingAScalar(double d) {
        return destDirNorm.multiplyUsingAScalar(d);
    }

    public Triplet scalarProduct(Triplet triplet) {
        return destDirNorm.scalarProduct(triplet);
    }

    public Triplet vectorProduct(Triplet triplet) {
        return destDirNorm.vectorProduct(triplet);
    }

    public double length() {
        return destDirNorm.length();
    }

    public Triplet norm() {
        return destDirNorm.norm();
    }
}