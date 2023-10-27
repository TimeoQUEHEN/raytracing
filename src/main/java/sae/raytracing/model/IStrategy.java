package sae.raytracing.model;

public interface IStrategy {

    public Color model(Scene scene, IElements element, Point p, Vector d, ILight light);
}
