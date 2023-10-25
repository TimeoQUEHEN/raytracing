package sae.raytracing.model;

public interface IStrategy {

    public int model(Scene scene, IElements element, Point p);
}
