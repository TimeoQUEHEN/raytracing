package sae.raytracing.model;

public class LambertStrategy implements IStrategy{

    private IStrategy childStrat;

    @Override
    public Color model(Scene scene, IElements element, Point p, Vector d, ILight light) {
        childStrat = new BaseStrategy();
        Vector n = element.getIntersectNorm(p);
        Color ld = new Color(light.getColor().multiplyUsingAScalar(Math.max(n.scalarProduct(light.getLdir(p).getDestDirNorm()), 0)).schursProduct(element.getDiffuse().getRgb()));
        return new Color(childStrat.model(scene,element,p, d, light).addition(ld.getRgb()));
    }
}
