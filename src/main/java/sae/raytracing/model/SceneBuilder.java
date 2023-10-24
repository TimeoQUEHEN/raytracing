package sae.lanceurderayons.model;

public class SceneBuilder implements IBuilder{
    private int height, width;
    private Camera camera;
    private ILight[] lights;
    private IElements[] elements;
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
    public void addLights(ILight[] lights) {
        this.lights = lights;
    }

    @Override
    public void addElements(IElements[] elements) {
        this.elements = elements;
    }

    @Override
    public Scene Scene() {
        return new Scene(this.height,this.width,this.camera,this.lights,this.elements);
    }
}