package sae.raytracing.model;

import java.sql.Array;
import java.util.ArrayList;

public class SceneBuilder implements IBuilder{
    private int height, width;
    private Camera camera;
    private final ArrayList<ILight> lights = new ArrayList<>(0);
    private final ArrayList<IElements> elements = new ArrayList<>(0);
    private Color ambient;

    // Implement Interface Methods
    @Override
    public void setDimensions(int height, int width) {
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
    public void addLights(ILight lights) {
        this.lights.add(lights);
    }

    @Override
    public void addElements(IElements elements) {
        this.elements.add(elements);
    }

    @Override
    public Scene Scene() {
        return new Scene(this.height,this.width,this.camera,this.ambient,this.lights,this.elements);
    }
}