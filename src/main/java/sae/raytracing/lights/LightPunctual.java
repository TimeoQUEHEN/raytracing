package sae.raytracing.lights;

import sae.raytracing.triplet.Color;
import sae.raytracing.triplet.Point;
import sae.raytracing.triplet.Vector;

public class LightPunctual implements ILight {
    private final Color color;
    private final Point point;

    public LightPunctual(Point point, Color color) {
        this.color = color;
        this.point = point;
    }

    public LightPunctual(double x, double y, double z, double r, double g, double b) {
        this(new Point(x,y,z), new Color(r,g,b));
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Vector getLdir(Point p) {
        return new Vector(point.subtraction(p.getCoords()).norm());
    }

    public Point getPoint() {
        return this.point;
    }
}
