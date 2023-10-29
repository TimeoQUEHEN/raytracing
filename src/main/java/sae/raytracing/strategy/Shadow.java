package sae.raytracing.strategy;

import sae.raytracing.elements.IElements;
import sae.raytracing.elements.Sphere;
import sae.raytracing.lights.ILight;
import sae.raytracing.lights.LightPunctual;
import sae.raytracing.scene.Scene;
import sae.raytracing.triplet.Color;
import sae.raytracing.triplet.Point;
import sae.raytracing.triplet.Vector;

public class Shadow implements IStrategy {

    private final IStrategy childStrat;

    public Shadow(IStrategy childStrat) {
        this.childStrat = childStrat;
    }

    @Override
    public Color model(Scene scene, IElements element, Point p, Vector d, ILight light) {
        double t;
        if (light instanceof LightPunctual lightPunctual) {
            double tl = lightPunctual.getPoint().subtraction(p.getCoords()).length();
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
                    double tl = pLight.subtraction(p.getCoords()).length();
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
