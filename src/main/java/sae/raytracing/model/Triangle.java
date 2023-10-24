package sae.raytracing.model;

public class Triangle {
    private Point pX;

    private Point pY;

    private Point pZ;

    public Triangle(Point x, Point y, Point z) {
        this.pX = x;
        this.pY = y;
        this.pZ = z;
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
}
