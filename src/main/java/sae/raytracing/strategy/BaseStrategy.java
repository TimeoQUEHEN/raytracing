package sae.raytracing.strategy;

import sae.raytracing.elements.IElements;
import sae.raytracing.lights.ILight;
import sae.raytracing.scene.Scene;
import sae.raytracing.triplet.Color;
import sae.raytracing.triplet.Point;
import sae.raytracing.triplet.Vector;

public class BaseStrategy implements IStrategy{
    /**
     * Makes the pixel use the ambient color of the scene
     * <p>
     * Only the scene argument is used, the others are here because of the Strategy pattern
     *
     * @param  scene   the scene
     * @param  elements   the elements
     * @param  p   the point
     * @param  d   the vector
     * @param  light   the light
     * @return          description of return value
     */
    @Override
    public Color model(Scene scene, IElements elements, Point p, Vector d, ILight light) {
        return scene.getAmbient();
    }
}
