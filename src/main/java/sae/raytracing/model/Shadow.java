package sae.raytracing.model;

public class Shadow implements IStrategy {

    private IStrategy childStrat;

    public Shadow(IStrategy childStrat) {
        this.childStrat = childStrat;
    }

    @Override
    public Color model(Scene scene, IElements element, Point p, Vector d, ILight light) {
        double t = -1;
        if (light instanceof LightPunctual lightPunctual) {
            double tl = lightPunctual.getPoint().substraction(p.getCoords()).length();
            for (IElements elementScene : scene.getElements()) {
                if (! element.equals(elementScene)) {
                    t = elementScene.getIntersection(light.getLdir(p),p);
                    if (t > 0 && t < tl) return new Color(0, 0, 0);
                } else {
                    t = -element.getIntersection(light.getLdir(p), lightPunctual.getPoint());
                    if (t + 0.0000001 < tl) return new Color(0,0,0);
                }
            }
        } else {
            for (IElements elementScene : scene.getElements()) {
                if (element.equals(elementScene) && element instanceof Sphere sphere) {
                    Point pLight = new Point(light.getLdir(p).multiplyUsingAScalar(sphere.getR()*2).addition(p.getCoords()));
                    double tl = pLight.substraction(p.getCoords()).length();
                    t = -element.getIntersection(light.getLdir(p), pLight);
                    if (t + 0.0000001 < tl) return new Color(0,0,0);
                }
                else {
                    t = elementScene.getIntersection(light.getLdir(p), p);
                    if (t > 0 && ! element.equals(elementScene)) return new Color(0,0,0);
                }
            }
        }
        return childStrat.model(scene, element, p, d, light);
    }
}
