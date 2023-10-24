package sae.lanceurderayons.model;

public interface IBuilder {
    void setDimensions(int height, int width);
    void setCamera(Camera camera);
    void addLights(ILight[] lights);
    void addElements(IElements[] elements);
    Scene Scene();
}
