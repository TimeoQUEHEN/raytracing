package sae.raytracing.model;

public interface IElements {
    public double getIntersection(Vector d, Camera cam);

    public Color getDiffuse();

    public Color getSpecular();

    public int getShininess();

}
