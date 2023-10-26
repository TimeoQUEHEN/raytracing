package sae.raytracing.model;

public class BaseStrategy implements IStrategy{
    @Override
    public Color model(Scene scene, IElements elements, Point p) {
        return scene.getAmbient();
    }
}
