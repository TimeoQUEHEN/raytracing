package sae.raytracing.model;

public class LambertStrategy implements IStrategy{

    @Override
    public int model(Scene scene, IElements element, Point p) {
        Triplet ld = new Triplet(0,0,0);
        Vector n = element.getIntersectNorm(p);
        for (ILight light : scene.getLights()) {
            ld = ld.addition(light.getColor().multiplyUsingAScalar(Math.max(n.scalarProduct(light.getLdir(p).getDestDirNorm()), 0)).schursProduct(element.getDiffuse().getRgb()));
        }
        Color col = new Color(scene.getAmbient().addition(ld));
        return col.getIntRgb();
        //Color la = scene.getAmbient();
        //return col.getIntRgb();
    }
}
