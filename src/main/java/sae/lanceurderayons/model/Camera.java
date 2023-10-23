package sae.lanceurderayons.model;

public class Camera {
    private Point lookFrom;
    private Point lookAt;
    private Vector up;
    private double fov;

    public Camera(Point lookFrom, Point lookAt, Vector up, double fov) {
        this.lookFrom = lookFrom;
        this.lookAt = lookAt;
        this.up = up;
        this.fov = fov;
    }

    public Camera(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3, double fov) {
        this(new Point(x1,y1,z1), new Point(x2,y2,z2), new Vector(x3,y3,z3) ,fov);
    }

    public Point getLookFrom() {
        return lookFrom;
    }

    public Point getLookAt() {
        return lookAt;
    }

    public Vector getUp() {
        return up;
    }

    public double getFov() {
        return fov;
    }
}
