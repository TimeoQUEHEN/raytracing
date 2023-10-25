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

    @Override
    public double getIntersection(Vector d, Camera cam) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Vector getIntersectNorm(Point p) {
        return null;
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
