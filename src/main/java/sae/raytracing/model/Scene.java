package sae.raytracing.model;

import java.util.ArrayList;

public class Scene {
    private boolean checker;
    private Color checkerC1;
    private Color checkerC2;
    private double checkersize;
    private final boolean shadow;
    private int height;
    private int width;
    private Camera camera;
    private Color ambient;
    private int maxDepth;
    private ArrayList<ILight> lights;
    private ArrayList<IElements> elements;

    public Scene(int width, int height, Camera camera, Color ambient, boolean shadow, int maxDepth, ArrayList<ILight> lights, ArrayList<IElements> elements, boolean checker,Color c1,Color c2, double size) {
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
        this.checkersize = size;
    }

    public boolean getChecker() {return checker;}

    public Color getCheckerC1() {return checkerC1;}

    public Color getCheckerC2() {return checkerC2;}

    public double getCheckerSize() {return checkersize;}

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

    public ArrayList<ILight> getLights() {
        return lights;
    }

    public ArrayList<IElements> getElements() {
        return elements;
    }
}
