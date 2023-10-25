package sae.raytracing.model;

import static java.lang.Math.sqrt;

public class Sphere implements IElements {
	private final Point center;
	private final double r;

	private final Color diffuse;

	private final Color specular;

	private final int shininess;

	public Sphere(Point point, double r, Color diffuse, Color specular, int shininess) {
		this.center = point;
		this.r = r;
		this.diffuse = diffuse;
		this.specular = specular;
		this.shininess = shininess;
	}

	public Sphere(double x, double y, double z, double r, Color diffuse, Color specular, int shininess) {
		this(new Point(x,y,z),r, diffuse, specular, shininess);
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

	@Override
	public double getIntersection(Vector d, Camera cam) {
		Point eye = cam.getLookFrom();
		Point cc = this.center;
		double a = 1 ;
		double b = eye.substraction(cc.getCoords()).scalarProduct(d.getDestDirNorm()) * 2;
		double c = eye.substraction(cc.getCoords()).scalarProduct(eye.substraction(cc.getCoords()))-(r*r);

		double delta = b*b-4*a*c;
		if (delta < 0) {
			return -1;
		} else {
			if (delta == 0) {
				return -b/(2*a);
			} else {
				double t1 = (-b+sqrt(delta))/(2*a);
				double t2 = (-b-sqrt(delta))/(2*a);
				if (t2 < 0) {return t1;}
				return t2;
			}
		}
	}

	@Override
	public Color getDiffuse() {
		return diffuse;
	}

	@Override
	public Color getSpecular() {
		return specular;
	}

	@Override
	public int getShininess() {
		return shininess;
	}
}
