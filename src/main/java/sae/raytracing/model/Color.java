package sae.raytracing.model;

public class Color {

    private Triplet rgb;

    public Color(double r, double g, double b) {
        this.rgb = new Triplet(r,g,b);
    }

    public Color(Triplet rgb) {
        double r = rgb.getX();
        double g = rgb.getY();
        double b = rgb.getZ();
        if (r > 1) r = 1;
        if (g > 1) g = 1;
        if (b > 1) b = 1;
        this.rgb = new Triplet(r, g, b);
    }

    @Override
    public String toString() {
        return getRValue()+", "+getGValue()+", "+getBValue();
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

    public Triplet getRgb() { return this.rgb; }

    public int getIntRgb() {
        return ( (int) (rgb.getX() * 255)) * 65536 + ( (int) (rgb.getY() * 255)) * 256 + ( (int) (rgb.getZ() * 255));
    }

    protected Triplet addition(Triplet triplet) {
        return rgb.addition(triplet);
    }

    protected Triplet multiplyUsingAScalar(double d) {
        return rgb.multiplyUsingAScalar(d);
    }

    protected Triplet schursProduct(Triplet triplet) {
        return rgb.schursProduct(triplet);
    }
}
