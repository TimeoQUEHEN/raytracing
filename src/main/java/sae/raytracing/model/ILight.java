package sae.raytracing.model;

public interface ILight {
    Color getColor();

    Vector getLdir(Point point);
}
