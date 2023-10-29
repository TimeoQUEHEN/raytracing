package sae.raytracing.model;

public class Triangle implements IElements {
    private final Point pX;

    private final Point pY;

    private final Point pZ;

    private final Color diffuse;

    private final Color specular;
    private final int shininess;

    public Triangle(Point x, Point y, Point z, Color diffuse, Color specular, int shininess) {
        this.pX = x;
        this.pY = y;
        this.pZ = z;
        this.diffuse = diffuse;
        this.specular = specular;
        this.shininess = shininess;
    }

    public Point getX() {
        return pX;
    }

    public Point getY() {
        return pY;
    }

    public Point getZ() {
        return pZ;
    }

    /**
     * Calculates the intersection between a given vector and the current Triangle.
     * the vector constitutes the direction of the ray of light,
     * if there is an intersection, the value of the intersection is returned
     * if there are none, the function returns -1
     *
     * @param  d    the vector representing the direction of the ray of light
     * @param  eye  the point representing the position of the camera in the scene
     * @return      the value of the intersection point, or -1 if there is no intersection
     */
    @Override
    public double getIntersection(Vector d, Point eye) {
        Point a = this.pX;
        Vector n = getIntersectNorm(null);
        double t = a.substraction(eye.getCoords()).scalarProduct(n.getDestDirNorm())/d.scalarProduct(n.getDestDirNorm());
        Triplet p = eye.getCoords().addition(d.multiplyUsingAScalar(t));

        if (n.scalarProduct((this.pY.getCoords().substraction(a.getCoords())).vectorProduct(p.substraction(a.getCoords()))) >= 0 &&
                n.scalarProduct((this.pZ.getCoords().substraction(this.pY.getCoords())).vectorProduct(p.substraction(this.pY.getCoords()))) >= 0 &&
                n.scalarProduct((a.getCoords().substraction(this.pZ.getCoords())).vectorProduct(p.substraction(this.pZ.getCoords()))) >= 0){
            return t;
        } else {return -1;}
    }

    /**
     * Returns the normalized vector of the intersection of the given point with the current Triangle.
     *
     * @param  p  Is unused in this function, but required by the interface
     * @return    the normalized vector used for the color's calculation.
     */
    @Override
    public Vector getIntersectNorm(Point p) {
        return new Vector((this.pY.substraction(this.pX.getCoords())).vectorProduct(this.pZ.substraction(this.pX.getCoords())).norm());
    }

    @Override
    public Color getDiffuse() {
        return diffuse;
    }

    @Override
    public Color getSpecular() {
        return specular;
    }

    @Override
    public int getShininess() {
        return shininess;
    }
}
