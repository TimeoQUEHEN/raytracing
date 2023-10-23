package sae.lanceurderayons.model;

public class Sphere implements IElements {
	private int x,y,z;
	private float r;
	public Sphere(int x, int y, int z, float r) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.r = r;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public float getR() {
		return r;
	}
	public void setR(float r) {
		this.r = r;
	}
	
	
}
