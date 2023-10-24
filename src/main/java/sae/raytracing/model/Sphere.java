package sae.raytracing.model;

public class Sphere implements IElements {
	private Point center;
	private double r;

	public Sphere(Point point, double r) {
		this.center = point;
		this.r = r;
	}

	public Sphere(double x, double y, double z, double r) {
		this(new Point(x,y,z),r);
	}

	public double getX() {
		return center.getX();
	}
	public double getY() {
		return center.getY();
	}
	public double getZ() {
		return center.getZ();
	}
	public double getR() {
		return r;
	}
}
