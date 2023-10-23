package sae.lanceurderayons.model;

public class Point {

    private Triplet coords;

    public Point(double x, double y, double z) {
        this.coords = new Triplet(x,y,z);
    }

    public double getX(){
        return coords.getX();
    }

    public double getY(){
        return coords.getY();
    }

    public double getZ(){
        return coords.getZ();
    }

    public Triplet substraction(Triplet triplet) {
        return new Triplet(this.getX()-triplet.getX(),this.getY()-triplet.getY(),this.getZ()-triplet.getZ());
    }

    public Triplet multiplyUsingAScalar(double d) {
        return new Triplet(this.getX()*d,this.getY()*d,this.getZ()*d);
    }
}