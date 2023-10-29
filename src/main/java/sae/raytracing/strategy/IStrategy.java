package sae.raytracing.strategy;

import sae.raytracing.elements.IElements;
import sae.raytracing.lights.ILight;
import sae.raytracing.scene.Scene;
import sae.raytracing.triplet.Color;
import sae.raytracing.triplet.Point;
import sae.raytracing.triplet.Vector;

public interface IStrategy {

    Color model(Scene scene, IElements element, Point p, Vector d, ILight light);
}
