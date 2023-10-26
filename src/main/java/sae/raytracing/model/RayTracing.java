package sae.raytracing.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RayTracing {

    public static void generateImage(Scene scene, File outputfile) {
        try {
            BufferedImage image = new BufferedImage(scene.getWidth(), scene.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int line = 0 ; line < scene.getWidth() ; line++) {
                for (int column = 0 ; column < scene.getHeight() ; column++) {
                    Vector d = getDistance(scene, line ,column);
                    double mint = -1;
                    double t = -1;
                    IElements lastElement = null;
                    for (IElements element : scene.getElements()) {
                        t = element.getIntersection(d, scene.getCamera());
                        if (t >= 0 && (mint < 0 || t < mint)) {
                            mint = t;
                            lastElement = element;
                        }
                    }
                    int rgb = 0;
                    if (mint >= 0) {
                        Point p = new Point(scene.getCamera().getLookFrom().getCoords().addition(d.multiplyUsingAScalar(mint)));

                        IStrategy strategy = new BlinnPhongStrategy();
                        rgb = strategy.model(scene,lastElement,p).getIntRgb();
                    }
                    image.setRGB(line,column,rgb);
                }
            }
            ImageIO.write(image, "png", outputfile);
            } catch (IOException e) {
                System.err.println("Error");
            }
    }

    public static Vector getDistance(Scene scene, int i, int j) {
        Vector w = new Vector(scene.getCamera().getLookFrom().substraction(scene.getCamera().getLookAt().getCoords()).norm());
        Vector u = new Vector(scene.getCamera().getUp().vectorProduct(w.getDestDirNorm()).norm());
        Vector v = new Vector(w.vectorProduct(u.getDestDirNorm()).norm());
        double fovr = scene.getCamera().getFov() * Math.PI / 180;
        double realHeight = 2 * Math.tan(fovr/2);
        double pixelSize = realHeight/scene.getHeight();
        double realWidth = scene.getWidth() * pixelSize;
        double a = (-1) * realWidth/2 + (i + 0.5) * pixelSize;
        double b = realHeight/2 - (j + 0.5) * pixelSize;
        return new Vector(u.multiplyUsingAScalar(a).addition(v.multiplyUsingAScalar(b)).substraction(w.getDestDirNorm()).norm());

    }
}