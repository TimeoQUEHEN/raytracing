package sae.raytracing.scene;

import sae.raytracing.elements.IElements;
import sae.raytracing.lights.ILight;
import sae.raytracing.triplet.Color;

import java.util.ArrayList;

public class SceneBuilder implements IBuilder{
    private int height;
    private int width;
    private Camera camera;
    private final ArrayList<ILight> lights = new ArrayList<>(0);
    private final ArrayList<IElements> elements = new ArrayList<>(0);
    private Color ambient;
    private boolean shadow;
    private int maxDepth;
    private boolean checker;
    private Color checkerC1;
    private Color checkerC2;
    private double checkerSize;

    @Override
    public void setCheckerAll(boolean val, Color c1, Color c2, double size) {
        this.checker = val;
        this.checkerC1 = c1;
        this.checkerC2 = c2;
        this.checkerSize = size;
    }

    // Implement Interface Methods
    @Override
    public void setDimensions(int width, int height) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void setAmbient(Color color) { this.ambient = color; }

    @Override
    public void setShadow(boolean shadow) {
        this.shadow = shadow;
    }

    @Override
    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    @Override
    public void addLights(ILight lights) {
        this.lights.add(lights);
    }

    @Override
    public void addElements(IElements elements) {
        this.elements.add(elements);
    }

    @Override
    public Scene scene() {
        return new Scene(this.width,this.height,this.camera,this.ambient,this.shadow,this.maxDepth,this.lights,this.elements,this.checker,this.checkerC1,this.checkerC2,this.checkerSize);
    }
}