package sae.raytracing.model;

import java.util.ArrayList;

public class Scene {
    private final boolean shadow;
    private int height;
    private int width;
    private Camera camera;
    private Color ambient;
    private ArrayList<ILight> lights;
    private ArrayList<IElements> elements;

    public Scene(int width, int height, Camera camera, Color ambient, boolean shadow, ArrayList<ILight> lights, ArrayList<IElements> elements) {
        this.height = height;
        this.width = width;
        this.camera = camera;
        this.ambient = ambient;
        this.shadow = shadow;
        this.lights = lights;
        this.elements = elements;
    }

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

    public ArrayList<ILight> getLights() {
        return lights;
    }

    public ArrayList<IElements> getElements() {
        return elements;
    }
}
