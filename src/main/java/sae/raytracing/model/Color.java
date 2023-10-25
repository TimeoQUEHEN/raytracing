package sae.raytracing.model;

public class Color {

    private Triplet rgb;

    public Color(double r, double g, double b) {
        try {
            this.rgb = new Triplet(r,g,b);
        } catch (Exception e) {
            System.err.println("Saisie incorrecte : la somme des couleurs des sources de lumiére dépasse 1 sur une des composantes");
        }
    }

    public Color(Triplet rgb) {
        this.rgb = rgb;
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
