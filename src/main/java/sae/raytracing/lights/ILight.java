package sae.raytracing.lights;

import sae.raytracing.triplet.Color;
import sae.raytracing.triplet.Point;
import sae.raytracing.triplet.Vector;

public interface ILight {
    Color getColor();

    Vector getLdir(Point point);
}
