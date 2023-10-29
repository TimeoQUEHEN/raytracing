package sae.raytracing.elements;

import sae.raytracing.triplet.Color;
import sae.raytracing.triplet.Point;
import sae.raytracing.triplet.Vector;

public interface IElements {
    double getIntersection(Vector d, Point eye);

    Vector getIntersectNorm(Point p);

    Color getDiffuse();

    Color getSpecular();

    int getShininess();

}
