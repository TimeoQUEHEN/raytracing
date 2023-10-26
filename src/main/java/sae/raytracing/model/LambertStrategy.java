package sae.raytracing.model;

public class LambertStrategy implements IStrategy{

    private IStrategy childStrat;

    @Override
    public Color model(Scene scene, IElements element, Point p) {
        childStrat = new BaseStrategy();
        Color ld = new Color(0,0,0);
        Vector n = element.getIntersectNorm(p);
        for (ILight light : scene.getLights()) {
            ld = new Color( ld.getRgb().addition(light.getColor().multiplyUsingAScalar(Math.max(n.scalarProduct(light.getLdir(p).getDestDirNorm()), 0)).schursProduct(element.getDiffuse().getRgb())));
        }
        return new Color(childStrat.model(scene,element,p).addition(ld.getRgb()));
    }
}
