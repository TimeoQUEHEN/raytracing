package sae.raytracing.model;

public class BaseStrategy implements IStrategy{
    @Override
    public int model(Scene scene, IElements elements, Point p) {
        return scene.getAmbient().getIntRgb();
    }
}
