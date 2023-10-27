package sae.raytracing.model;

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

    public Camera(double x, double y, double z, double u, double v, double w, double m, double n, double o, double fov) {
        this(new Point(x,y,z), new Point(u,v,w), new Vector(m,n,o) ,fov);
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
