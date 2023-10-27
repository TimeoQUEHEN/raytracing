package sae.raytracing.model;

import java.util.ArrayList;

public class SceneBuilder implements IBuilder{
    private int height, width;
    private Camera camera;
    private final ArrayList<ILight> lights = new ArrayList<>(0);
    private final ArrayList<IElements> elements = new ArrayList<>(0);
    private Color ambient;
    private boolean shadow;

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
    public void addLights(ILight lights) {
        this.lights.add(lights);
    }

    @Override
    public void addElements(IElements elements) {
        this.elements.add(elements);
    }

    @Override
    public Scene Scene() {
        return new Scene(this.width,this.height,this.camera,this.ambient,this.shadow,this.lights,this.elements);
    }
}