package sae.raytracing.model;

public class BlinnPhongStrategy implements IStrategy{

    private IStrategy childStrat;

    @Override
    public Color model(Scene scene, IElements element, Point p, Vector d, ILight light) {
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
