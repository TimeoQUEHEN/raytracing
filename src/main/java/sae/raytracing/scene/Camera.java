package sae.raytracing.scene;

import sae.raytracing.triplet.Point;
import sae.raytracing.triplet.Vector;

public class Camera {
    private final Point lookFrom;
    private final Point lookAt;
    private final Vector up;
    private final double fov;

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
