package sae.raytracing.elements;

import sae.raytracing.triplet.Color;
import sae.raytracing.triplet.Point;
import sae.raytracing.triplet.Vector;

public class Plane implements IElements {
    private final Point point;
    private final Vector vector;

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
    public double getIntersection(Vector d, Point eye) {
        Vector n = getIntersectNorm(null);
        return this.point.subtraction(eye.getCoords()).scalarProduct(n.getDestDirNorm())/d.scalarProduct(n.getDestDirNorm());
    }

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
