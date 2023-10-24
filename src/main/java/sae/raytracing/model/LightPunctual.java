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

    public Point getPoint() {
        return this.point;
    }
}
