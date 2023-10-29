package sae.raytracing.model;

import sae.raytracing.Main;
import sae.raytracing.elements.IElements;
import sae.raytracing.elements.Plane;
import sae.raytracing.lights.ILight;
import sae.raytracing.scene.Scene;
import sae.raytracing.strategy.*;
import sae.raytracing.triplet.Color;
import sae.raytracing.triplet.Point;
import sae.raytracing.triplet.Vector;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class RayTracing {

    public static void generateImage(Scene scene, File outputfile) {
        try {
            BufferedImage image = new BufferedImage(scene.getWidth(), scene.getHeight(), BufferedImage.TYPE_INT_RGB);
            IStrategy strategy;
            List<IElements> elements = scene.getElements();
            if (!elements.isEmpty() && elements.get(0).getSpecular() != null) {
                strategy = new BlinnPhongStrategy();
            } else if (!elements.isEmpty() && elements.get(0).getDiffuse() != null) {
                strategy = new LambertStrategy();
            } else {
                strategy = new BaseStrategy();
            }
            if (scene.getShadow()) {
                strategy = new Shadow(strategy);
            }
            Vector w = new Vector(scene.getCamera().getLookFrom().subtraction(scene.getCamera().getLookAt().getCoords()).norm());
            Vector u = new Vector(scene.getCamera().getUp().vectorProduct(w.getDestDirNorm()).norm());
            Vector v = new Vector(w.vectorProduct(u.getDestDirNorm()).norm());
            double fovr = scene.getCamera().getFov() * Math.PI / 180;
            double realHeight = 2 * Math.tan(fovr/2);
            double pixelSize = realHeight/scene.getHeight();
            double realWidth = scene.getWidth() * pixelSize;
            for (int line = 0 ; line < scene.getWidth() ; line++) {
                for (int column = 0 ; column < scene.getHeight() ; column++) {
                    double a = (-1) * realWidth/2 + (line + 0.5) * pixelSize;
                    double b = realHeight/2 - (column + 0.5) * pixelSize;
                    Vector d = new Vector(u.multiplyUsingAScalar(a).addition(v.multiplyUsingAScalar(b)).subtraction(w.getDestDirNorm()).norm());
                    double mint = -1;
                    double t = -1;
                    IElements lastElement = null;
                    for (IElements element : elements) {
                        t = element.getIntersection(d, scene.getCamera().getLookFrom());
                        if (t >= 0 && (mint < 0 || t < mint)) {
                            mint = t;
                            lastElement = element;
                        }
                    }
                    int rgb = 0;
                    if (mint >= 0) {
                        Point p = new Point(scene.getCamera().getLookFrom().getCoords().addition(d.multiplyUsingAScalar(mint)));
                        if (scene.getChecker() && lastElement instanceof Plane) {
                            rgb = calculateCheckerColor(scene,p,lastElement,d).getIntRgb();
                        } else {
                            rgb = calculateReflectColor(scene,p,d,strategy,lastElement,1).getIntRgb();
                        }
                    }
                    image.setRGB(line,column,rgb);
                }
            }
            ImageIO.write(image, "png", outputfile);
            } catch (IOException e) {
                Main.logger.warning("Error : " + e.getMessage());
            }
    }

    private static Color calculateCheckerColor(Scene scene, Point p, IElements elem, Vector d) {
        IStrategy childstrat = new Checker();
        if (scene.getShadow()) {
            childstrat = new Shadow(childstrat);
            Color c = new Color(0,0,0);
            for (ILight light : scene.getLights()) {
                c = new Color(c.addition(childstrat.model(scene,elem,p,d,light).getRgb()));
            }
            return c;
        }
        return childstrat.model(scene,elem,p,null,null);
    }

    public static Color calculateReflectColor(Scene scene, Point p, Vector d, IStrategy strategy, IElements element,int depth) {
        Color c = new Color(0,0,0);
        for (ILight light : scene.getLights()) {
            c = new Color(c.addition(strategy.model(scene,element,p,d,light).getRgb()));
        }
        if (depth < scene.getMaxDepth() && element.getSpecular().getIntRgb() > 0) {
            Vector n = element.getIntersectNorm(p);
            Vector r = new Vector(d.addition(n.multiplyUsingAScalar(2 * n.scalarProduct(d.multiplyUsingAScalar(-1)))));
            double mint = -1;
            double t = -1;
            IElements lastElement = null;
            for (IElements elementScene : scene.getElements()) {
                t = elementScene.getIntersection(r, p);
                if (! element.equals(elementScene) && t >= 0 && (mint < 0 || t < mint)) {
                    mint = t;
                    lastElement = elementScene;
                }
            }
            if (mint > 0) {
                Point p2 = new Point(p.getCoords().addition(r.multiplyUsingAScalar(mint)));
                if (scene.getChecker() && lastElement instanceof Plane) {
                    return new Color(c.addition(RayTracing.calculateCheckerColor(scene,p2,lastElement,r).addition(scene.getAmbient().getRgb()).multiplyUsingAScalar(0.5)));
                } else {
                    depth++;
                    Color c2 = calculateReflectColor(scene, p2, r, strategy, lastElement, depth);
                    c = new Color(c.addition(element.getSpecular().schursProduct(c2.getRgb())));
                }
            }
        }
        return c;
    }
}