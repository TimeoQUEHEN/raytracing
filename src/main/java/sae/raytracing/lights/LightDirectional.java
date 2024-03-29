package sae.raytracing.lights;

import sae.raytracing.triplet.Color;
import sae.raytracing.triplet.Point;
import sae.raytracing.triplet.Vector;

public class LightDirectional implements ILight {
    private final Color color;
    private final Vector vector;

    public LightDirectional(Vector vector, Color color) {
        this.color = color;
        this.vector = vector;
    }

    public LightDirectional(double x, double y, double z, double r, double g, double b) {
        this(new Vector(x,y,z), new Color(r,g,b));
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * Retrieves the direction vector from a given point to the current point.
     *
     * @param  p  the point to calculate the direction from
     * @return    the direction vector from p to the current point
     */
    @Override
    public Vector getLdir(Point point) {
        return new Vector(vector.norm());
    }

    public Vector getVector() {
        return this.vector;
    }
}
