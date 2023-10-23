package sae.lanceurderayons.model;

public class Plane {
    private Point point;
    private Vector vector;

    public Plane(Point point, Vector vector) {
        this.point = point;
        this.vector = vector;
    }

    public Plane(double x1, double y1, double z1, double x2, double y2, double z2) {
        this(new Point(x1,y1,z1), new Vector(x2,y2,z2));
    }

    public Point getPoint() {
        return point;
    }

    public Vector getVector() {
        return vector;
    }
}
