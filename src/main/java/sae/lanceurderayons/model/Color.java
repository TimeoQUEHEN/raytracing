package sae.lanceurderayons.model;

public class Color {

    private Triplet rgb;

    public Color(double r, double g, double b) {
        this.rgb = new Triplet(r,g,b);
    }

    public double getRValue() {
        return this.rgb.getX();
    }

    public double getGValue() {
        return this.rgb.getY();
    }

    public double getBValue() {
        return this.rgb.getZ();
    }

    public Triplet addition(Triplet triplet) {
        return new Triplet(this.getRValue()+triplet.getX(),this.getBValue()+triplet.getY(),this.getBValue()+triplet.getZ());
    }

    public Triplet multiplyUsingAScalar(double d) {
        return new Triplet(this.getRValue()*d,this.getGValue()*d,this.getBValue()*d);
    }

    public Triplet schursProduct(Triplet triplet) {
        return new Triplet(this.getRValue() * triplet.getX(), this.getGValue() * triplet.getY(), this.getBValue() * triplet.getZ());
    }
}
