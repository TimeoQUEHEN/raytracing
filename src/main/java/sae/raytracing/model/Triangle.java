package sae.raytracing.model;

public class Triangle implements IElements {
    private final Point pX;

    private final Point pY;

    private final Point pZ;

    private final Color diffuse;

    private final Color specular;

    private final int shininess;

    public Triangle(Point x, Point y, Point z, Color diffuse, Color specular, int shininess) {
        this.pX = x;
        this.pY = y;
        this.pZ = z;
        this.diffuse = diffuse;
        this.specular = specular;
        this.shininess = shininess;
    }

    public Point getX() {
        return pX;
    }

    public Point getY() {
        return pY;
    }

    public Point getZ() {
        return pZ;
    }

    @Override
    public double getIntersection(Vector d, Camera cam) {
        Point eye = cam.getLookFrom();
        Point a = this.pX;
        Vector n = new Vector((this.pY.substraction(a.getCoords())).vectorProduct(this.pZ.substraction(a.getCoords())).norm());
        double t = a.substraction(eye.getCoords()).scalarProduct(n.getDestDirNorm())/d.scalarProduct(n.getDestDirNorm());
        Triplet p = eye.getCoords().addition(d.multiplyUsingAScalar(t));

        if (n.scalarProduct((this.pY.getCoords().substraction(a.getCoords())).vectorProduct(p.substraction(a.getCoords()))) >= 0 &&
                n.scalarProduct((this.pZ.getCoords().substraction(this.pY.getCoords())).vectorProduct(p.substraction(this.pY.getCoords()))) >= 0 &&
                n.scalarProduct((a.getCoords().substraction(this.pZ.getCoords())).vectorProduct(p.substraction(this.pZ.getCoords()))) >= 0){
            return t;
        } else {return -1;}
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
