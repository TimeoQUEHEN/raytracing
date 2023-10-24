package sae.raytracing.model;

import java.util.ArrayList;

public class Scene {
    private int height;
    private int width;
    private Camera camera;
    private ILight[] lights;
    private IElements[] elements;

    public Scene(int height, int width, Camera camera, ArrayList<ILight> lights, ArrayList<IElements> elements) {
        this.height = height;
        this.width = width;
        this.camera = camera;
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

    public ILight[] getLights() {
        return lights;
    }

    public IElements[] getElements() {
        return elements;
    }
}
