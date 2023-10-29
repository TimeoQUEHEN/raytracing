package sae.raytracing.model;

public class LightPunctual implements ILight {
    private Color color;
    private Point point;

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

    /**
     * Retrieves the direction vector from a given point to the current point.
     *
     * @param  p  the point to calculate the direction from
     * @return    the direction vector from p to the current point
     */
    @Override
    public Vector getLdir(Point p) {
        return new Vector(point.substraction(p.getCoords()).norm());
    }

    public Point getPoint() {
        return this.point;
    }
}
