package sae.raytracing.model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Vector {

    private Triplet destDirNorm;

    public Vector(double destination, double direction, double norm) {
        this.destDirNorm = new Triplet(destination,direction,norm);
    }

    public Vector(Triplet triplet) {
        this.destDirNorm = triplet;
    }

    @Override
    public String toString() {
        return getDestination()+", "+getDirection()+", "+getNorm();
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

    /**
     * Returns the Triplet corresponding to the different values of the Vector : Destination, direction and norm.
     * @return the Vector's Triplet
     */
    public Triplet getDestDirNorm() { return this.destDirNorm; }

    /**
     * @param triplet the triplet added to the current triplet
     * @see Triplet#addition(Triplet)
     */
    protected Triplet addition(Triplet triplet) {
        return destDirNorm.addition(triplet);
    }

    /**
     * @param triplet the triplet substracted from the current triplet (creates a Point)
     * @see Triplet#substraction(Triplet)
     */
    protected Triplet substraction(Triplet triplet) {
        return destDirNorm.substraction(triplet);
    }

    /**
     * @param d the scalar value used to multiply the current triplet
     * @see Triplet#multiplyUsingAScalar(double)
     */
    protected Triplet multiplyUsingAScalar(double d) {
        return destDirNorm.multiplyUsingAScalar(d);
    }

    /**
     * @param triplet the triplet used to multiply the current triplet
     * @see Triplet#scalarProduct(Triplet)
     */
    protected double scalarProduct(Triplet triplet) {
        return destDirNorm.scalarProduct(triplet);
    }

    /**
     * @param triplet the triplet used to multiply the current triplet
     * @see Triplet#vectorProduct(Triplet)
     */
    protected Triplet vectorProduct(Triplet triplet) {
        return destDirNorm.vectorProduct(triplet);
    }

    /**
     * @see Triplet#length()
     */
    protected double length() {
        return destDirNorm.length();
    }

    /**
     * @see Triplet#norm()
     */
    protected Triplet norm() {
        return destDirNorm.norm();
    }
}