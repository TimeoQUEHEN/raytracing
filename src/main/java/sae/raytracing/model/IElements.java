package sae.raytracing.model;

public interface IElements {
    public double getIntersection(Vector d, Camera cam);

    public Vector getIntersectNorm(Point p);

    public Color getDiffuse();

    public Color getSpecular();

    public int getShininess();

}
