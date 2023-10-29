package sae.raytracing.model;

public class Checker implements IStrategy{
    @Override
    public Color model(Scene scene, IElements element, Point p, Vector d, ILight light) {
        double x = p.getX() %(2*scene.getCheckerSize());
        double z = p.getZ() %(2*scene.getCheckerSize());
        if (x < 0) x = (-x + scene.getCheckerSize() ) % (2*scene.getCheckerSize()) ;
        if (z < 0) z = (-z + scene.getCheckerSize() ) % (2*scene.getCheckerSize()) ;
        if ((x > scene.getCheckerSize() && z > scene.getCheckerSize()) || (x < scene.getCheckerSize() && z < scene.getCheckerSize())) {
            return scene.getCheckerC1();
        } else {
            return scene.getCheckerC2();
        }
    }
}
