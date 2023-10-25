package sae.raytracing.model;

public class LambertStrategy implements IStrategy{

    @Override
    public int model(Scene scene, IElements element, Point p) {
        int ld = 0;
        Vector n = element.getIntersectNorm(p);
        for (ILight light : scene.getLights()) {
            ld += Math.max(n.scalarProduct(light.getLdir(p).getDestDirNorm()),0) * light.getColor().getIntRgb();
        }
        return scene.getAmbient().getIntRgb() + ld * element.getDiffuse().getIntRgb();
        //Color la = scene.getAmbient();
        //return col.getIntRgb();
    }
}
