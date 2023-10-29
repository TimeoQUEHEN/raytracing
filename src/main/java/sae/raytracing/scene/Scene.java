package sae.raytracing.scene;

import sae.raytracing.elements.IElements;
import sae.raytracing.lights.ILight;
import sae.raytracing.triplet.Color;

import java.util.List;

public class Scene {
    private final boolean checker;
    private final Color checkerC1;
    private final Color checkerC2;
    private final double checkerSize;
    private final boolean shadow;
    private final int height;
    private final int width;
    private final Camera camera;
    private final Color ambient;
    private final int maxDepth;
    private final List<ILight> lights;
    private final List<IElements> elements;

    public Scene(int width, int height, Camera camera, Color ambient, boolean shadow, int maxDepth, List<ILight> lights, List<IElements> elements, boolean checker,Color c1,Color c2, double size) {
        this.height = height;
        this.width = width;
        this.camera = camera;
        this.ambient = ambient;
        this.shadow = shadow;
        this.maxDepth = maxDepth;
        this.lights = lights;
        this.elements = elements;
        this.checker=checker;
        this.checkerC1 = c1;
        this.checkerC2 = c2;
        this.checkerSize = size;
    }

    public boolean getChecker() {return checker;}

    public Color getCheckerC1() {return checkerC1;}

    public Color getCheckerC2() {return checkerC2;}

    public double getCheckerSize() {return checkerSize;}

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Camera getCamera() {
        return camera;
    }

    public Color getAmbient() { return ambient; }

    public boolean getShadow() { return shadow; }

    public int getMaxDepth() { return maxDepth; }

    public List<ILight> getLights() {
        return lights;
    }

    public List<IElements> getElements() {
        return elements;
    }
}
