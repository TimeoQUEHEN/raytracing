package sae.raytracing.model;

public class Triangle implements IElements {
    private final Point pX;

    private final Point pY;

    private final Point pZ;

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
