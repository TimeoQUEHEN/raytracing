package sae.raytracing.model;

public class LambertStrategy implements IStrategy{

    private IStrategy childStrat;

    /**
     * Calculate the color of a pixel in the scene using the Lambert model.
     * this model is used when the keyword diffuse is used in the input file
     *
     * @param  scene    the scene in which the model is rendered
     * @param  element  the element being rendered
     * @param  p        the coordinates of the pixel
     * @param  d        the direction of the pixel
     * @param  light    the light source in the scene
     * @return          the color of the pixel
     */
    @Override
    public Color model(Scene scene, IElements element, Point p, Vector d, ILight light) {
        childStrat = new BaseStrategy();
        Vector n = element.getIntersectNorm(p);
        Color ld = new Color(light.getColor().multiplyUsingAScalar(Math.max(n.scalarProduct(light.getLdir(p).getDestDirNorm()), 0)).schursProduct(element.getDiffuse().getRgb()));
        return new Color(childStrat.model(scene,element,p, d, light).addition(ld.getRgb()));
    }
}
