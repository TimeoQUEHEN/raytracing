package sae.raytracing.strategy;

import sae.raytracing.elements.IElements;
import sae.raytracing.lights.ILight;
import sae.raytracing.scene.Scene;
import sae.raytracing.triplet.Color;
import sae.raytracing.triplet.Point;
import sae.raytracing.triplet.Vector;

public class BlinnPhongStrategy implements IStrategy{


    /**
     * The implementation of the colorisation method created by BlinnPhong.
     * Takes into account the light reflecting on the surface of the element
     * Creates shadows of the element depending on the position of the pixel vis-à-vis the light.
     * this strategy is used when the keywords shininess and specular are specified in the input file.
     *
     * @param  scene     the scene used to represent the rayTracing
     * @param  element   the current element in the scene
     * @param  p         the Point giving the coordinates of the pixel being colorized
     * @param  d         the vector used for the colorisation
     * @param  light     the light allowing the colors to be seen
     * @return           the color of the current pixel
     */
    @Override
    public Color model(Scene scene, IElements element, Point p, Vector d, ILight light) {
        IStrategy childStrat;
        childStrat = new LambertStrategy();
        Vector dReverse = new Vector(d.multiplyUsingAScalar(-1));
        Vector h = new Vector(light.getLdir(p).getDestDirNorm().addition(dReverse.getDestDirNorm()).norm());
        Vector n = element.getIntersectNorm(p);
        Color ld = new Color(
                light.getColor().multiplyUsingAScalar(Math.pow(Math.max(n.scalarProduct(h.getDestDirNorm()),0),element.getShininess()))
                        .schursProduct(element.getSpecular().getRgb())
        );
        return new Color(childStrat.model(scene,element,p, d, light).addition(ld.getRgb()));
    }
}
