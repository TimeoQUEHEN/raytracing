package sae.raytracing.model;

public class BlinnPhongStrategy implements IStrategy{

    private IStrategy childStrat;

    @Override
    public Color model(Scene scene, IElements element, Point p) {
        childStrat = new LambertStrategy();
        Color ld = new Color(0,0,0);
        for (ILight lightSource : scene.getLights()) {
            Vector n = element.getIntersectNorm(p);
            Vector h = new Vector(lightSource.getLdir(p).getDestDirNorm().addition(scene.getCamera().getLookFrom().getCoords()).norm());
            ld = new Color(
                    ld.addition(lightSource.getColor().multiplyUsingAScalar(Math.pow(Math.max(n.scalarProduct(h.getDestDirNorm()),0),element.getShininess()))
                    .schursProduct(element.getSpecular().getRgb()))
            );
        }
        return new Color(childStrat.model(scene,element,p).addition(ld.getRgb()));
    }
}
