package sae.raytracing.model;

public class Plane implements IElements {
    private Point point;
    private Vector vector;

    private final Color diffuse;

    private final Color specular;

    private final int shininess;

    public Plane(Point point, Vector vector, Color diffuse, Color specular, int shininess) {
        this.point = point;
        this.vector = vector;
        this.diffuse = diffuse;
        this.specular = specular;
        this.shininess = shininess;
    }

    public Plane(double x1, double y1, double z1, double x2, double y2, double z2, Color diffuse, Color specular, int shininess) {
        this(new Point(x1,y1,z1), new Vector(x2,y2,z2), diffuse, specular, shininess);
    }

    public Point getPoint() {
        return point;
    }

    public Vector getVector() {
        return vector;
    }

    /**
     * Calculates the intersection between a given vector and the current Plane.
     * the vector constitutes the direction of the ray of light,
     * if there is an intersection, the value of the intersection is returned
     *
     * @param  d    the vector representing the direction of the ray of light
     * @param  eye  the point representing the position of the camera in the scene
     * @return      the value of the intersection point
     */
    @Override
    public double getIntersection(Vector d, Point eye) {
        Point q = this.point;
        Vector n = getIntersectNorm(null);
        return q.substraction(eye.getCoords()).scalarProduct(n.getDestDirNorm())/d.scalarProduct(n.getDestDirNorm());
    }

    /**
     * Retrieve the normalized intersection vector between the current Plane and a given point.
     *
     * @param  p  Is unused in this function, but it is required by the interface
     * @return    the normalized intersection vector
     */
    @Override
    public Vector getIntersectNorm(Point p) {
        return this.vector;
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
