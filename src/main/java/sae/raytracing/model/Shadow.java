package sae.raytracing.model;

public class Shadow implements IStrategy {

    private IStrategy childStrat;

    public Shadow(IStrategy childStrat) {
        this.childStrat = childStrat;
    }

    @Override
    public Color model(Scene scene, IElements element, Point p, Vector d, ILight light) {
        double t = -1;
        for (IElements elementScene : scene.getElements()) {
            t = elementScene.getIntersection(light.getLdir(p), p);
            if (! element.equals(elementScene) && t > 0) {
                return new Color(0,0,0);
            }
        }
        return childStrat.model(scene, element, p, d, light);
    }
}
