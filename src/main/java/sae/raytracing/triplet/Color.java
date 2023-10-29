package sae.raytracing.triplet;

public class Color {

    private final Triplet rgb;

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

    /**
     * Returns a Triplet corresponding to the rgb value of the current color
     * @return a Triplet corresponding to the different values of the RGB color.
     */
    public Triplet getRgb() { return this.rgb; }
    /**
     * Returns the integer representation of the RGB color.
     * the RGB value is originally stored in the Triplet
     *
     * @return the integer value of the RGB color
     */
    public int getIntRgb() {
        return ( (int) (rgb.getX() * 255)) * 65536 + ( (int) (rgb.getY() * 255)) * 256 + ( (int) (rgb.getZ() * 255));
    }

    /**
     * @param triplet the triplet added to the current triplet
     * @see Triplet#addition (Triplet)
     */
    public Triplet addition(Triplet triplet) {
        return rgb.addition(triplet);
    }

    /**
     * @param d the double used to multiply the current triplet
     * @see Triplet#multiplyUsingAScalar(double)
     */
    public Triplet multiplyUsingAScalar(double d) {
        return rgb.multiplyUsingAScalar(d);
    }

    /**
     * @param triplet the triplet used to multiply the current triplet
     * @see Triplet#schursProduct(Triplet)
     */
    public Triplet schursProduct(Triplet triplet) {
        return rgb.schursProduct(triplet);
    }
}
