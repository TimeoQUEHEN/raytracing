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
        return new Triplet(this.getDestination()+triplet.getX(),this.getDirection()+triplet.getY(),this.getNorm()+triplet.getZ());
    }

    public Triplet substraction(Triplet triplet) {
        return new Triplet(this.getDestination()-triplet.getX(),this.getDirection()-triplet.getY(),this.getNorm()-triplet.getZ());
    }

    public Triplet multiplyUsingAScalar(double d) {
        return new Triplet(this.getDestination()*d,this.getDirection()*d,this.getNorm()*d);
    }

    public Triplet scalarProduct(Triplet triplet) {
        return new Triplet(this.getDestination()*triplet.getX(),this.getDirection()*triplet.getY(),this.getNorm()*triplet.getZ());
    }

    public Triplet vectorProduct(Triplet triplet) {
        return new Triplet(this.getDirection()*triplet.getZ() - this.getNorm()*triplet.getY(), this.getNorm()*triplet.getX() - this.getDestination()*triplet.getZ(), this.getDestination()*triplet.getY() - this.getDirection()*triplet.getX());
    }

    public double length() {
        return sqrt(pow(this.getDestination(),2)+pow(this.getDirection(),2)+pow(this.getNorm(),2));
    }

    public Triplet norm() {
        return multiplyUsingAScalar(1/length());
    }
}