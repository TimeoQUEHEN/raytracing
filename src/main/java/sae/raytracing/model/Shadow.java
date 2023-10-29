package sae.raytracing.model;

import javax.swing.text.Element;

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
                t = elementScene.getIntersection(light.getLdir(p),p);
                if (t > 0 && t < tl && ! element.equals(elementScene)) return new Color(0,0,0);
            }
        } else {
            for (IElements elementScene : scene.getElements()) {
                t = elementScene.getIntersection(light.getLdir(p), p);
                if (t > 0 && ! element.equals(elementScene)) return new Color(0,0,0);
            }
        }
        return childStrat.model(scene, element, p, d, light);
    }
}