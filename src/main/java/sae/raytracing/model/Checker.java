package sae.raytracing.model;

public class Checker implements IStrategy{

    /**
     * Calculates the color of a point in a plane using a checkerboard pattern.
     * Gathers the coordinates x and z, and normalises them.
     * if both are inferior to 0.5, the color is scene.getCheckerC1()
     * or, if both are superior to 0.5, the color is scene.getCheckerC1()
     * Otherwise, the color is scene.getCheckerC2()
     *
     * the parameters d and light are not used, but need to be implemented due to the development pattern used.
     *
     * @param  scene    the scene being rendered
     * @param  element  the elements in the scene
     * @param  p        the point in the scene
     * @param  d        the direction vector
     * @param  light    the light source
     * @return          the color of the point
     */
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
