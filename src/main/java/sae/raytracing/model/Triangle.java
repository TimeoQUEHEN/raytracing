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

    @Override
    public double getIntersection(Vector d, Camera cam) {
        return 0;
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
