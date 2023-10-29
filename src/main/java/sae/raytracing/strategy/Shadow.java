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

    /**
     * Return the color of an intersection point of a checker element
     *
     * @param scene the current scene
     * @param element the element of the intersection
     * @param p the intersection point
     * @param d the vector from the point of view
     * @param light the current light
     * @return the color of the point
     */
    @Override
    public Color model(Scene scene, IElements element, Point p, Vector d, ILight light) {
        double t;
        if (light instanceof LightPunctual lightPunctual) { // Verify if the light is an instance of LightPunctual and if it's so cast it
            double tl = lightPunctual.getPoint().subtraction(p.getCoords()).length();
            for (IElements elementScene : scene.getElements()) {
                if (! element.equals(elementScene)) { // If the element isn't the current element used for the research of intersection
                    t = elementScene.getIntersection(light.getLdir(p),p);
                    if (t > 0 && t < tl) return new Color(0, 0, 0); // Verify if there is another element is between the light point and the intersection point
                } else { // Else the element is the current element used for the research of intersection
                    t = -element.getIntersection(light.getLdir(p), lightPunctual.getPoint());
                    if (t + 0.0000001 < tl) return new Color(0,0,0); // Verify if the current element is between the light point and the intersection point
                }
            }
        } else { // Else it used it as a LightDirectional
            for (IElements elementScene : scene.getElements()) {
                if (element.equals(elementScene) && element instanceof Sphere sphere) { // If the element is the current element used for the research of intersection
                    Point pLight = new Point(light.getLdir(p).multiplyUsingAScalar(sphere.getR()*2).addition(p.getCoords())); // Creation of a fake point on the vector light to see if the element has another intersection more closely
                    double tl = pLight.subtraction(p.getCoords()).length();
                    t = -element.getIntersection(light.getLdir(p), pLight);
                    if (t + 0.0000001 < tl) return new Color(0,0,0); // Verify if the current element is between the light point and the intersection point
                } else { // Else the element isn't the current element used for the research of intersection
                    t = elementScene.getIntersection(light.getLdir(p), p);
                    if (t > 0 && ! element.equals(elementScene)) return new Color(0,0,0); // Verify if there is another element is between the light point and the intersection point
                }
            }
        }
        return childStrat.model(scene, element, p, d, light);
    }
}
