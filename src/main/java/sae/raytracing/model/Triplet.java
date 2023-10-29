package sae.raytracing.model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triplet {

    private double x;

    private double y;

    private double z;

    public Triplet(double x, double y, double z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    @Override
    public String toString() {
        return getX()+", "+getY()+", "+getZ();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    /**
     * Adds each component of this Triplet to the corresponding component of the given Triplet
     *
     * @param  triplet  the Triplet to perform the addition with
     * @return          a new Triplet with the results of the addition
     */
    protected Triplet addition(Triplet triplet) {
        return new Triplet(this.x+triplet.getX(),this.y+triplet.getY(),this.z+triplet.getZ());
    }

    /**
     * Subtracts each component of this Triplet from the corresponding component of the given Triplet
     *
     * @param  triplet  the Triplet to perform the subtraction with
     * @return          a new Triplet with the results of the subtraction
     */
    protected Triplet substraction(Triplet triplet) {
        return new Triplet(this.x-triplet.getX(),this.y-triplet.getY(),this.z-triplet.getZ());
    }

    /**
     * Multiplies each component of this Triplet with the corresponding component of the given Triplet
     *
     * @param  d        the scalar value used to multiply the current triplet
     * @return          a new Triplet with the results of the product using the scalar d
     */
    protected Triplet multiplyUsingAScalar(double d) {
        return new Triplet(this.x*d,this.y*d,this.z*d);
    }

    /**
     * Multiplies each component of this Triplet with the corresponding component of the given Triplet
     *
     * @param  triplet  the Triplet to perform the Scalar product with
     * @return          a new double resulting of the Scalar product
     */
    protected double scalarProduct(Triplet triplet) {
        return this.x*triplet.getX() + this.y*triplet.getY() + this.z*triplet.getZ();
    }

    /**
     * Multiplies each component of this Triplet with the corresponding component of the given Triplet
     *
     * @param  triplet  the Triplet to perform the vector's product with
     * @return          a new Triplet with the results of the Vector's product
     */
    protected Triplet vectorProduct(Triplet triplet) {
        return new Triplet(this.y*triplet.getZ() - this.z*triplet.getY(), this.z*triplet.getX() - this.x*triplet.getZ(), this.x*triplet.getY() - this.y*triplet.getX());
    }

    /**
     * Multiplies each component of this Triplet with the corresponding component of the given Triplet
     *
     * @param  triplet  the Triplet to perform the Schur's product with
     * @return          a new Triplet with the results of the Schur's product
     */
    protected Triplet schursProduct(Triplet triplet) {
        return new Triplet(this.x * triplet.getX(), this.y * triplet.getY(), this.z * triplet.getZ());
    }

    /**
     * Returns the postive length of the Triplet
     * @return          The length of the Triplet
     */
    protected double length() {
        return sqrt(pow(this.x,2)+pow(this.y,2)+pow(this.z,2));
    }

    /**
     * Divides each component of this Triplet by the corresponding component of the current Triplet
     * @return          The normalized version of the current Triplet
     */
    protected Triplet norm() {
        return multiplyUsingAScalar(1/length());
    }

    /*public static void main(String[] args) {
        Triplet t1 = new Triplet(3,4,5);
        Triplet t2 = new Triplet(3,4,5);
        System.out.println("addition : "+t1.addition(t2));
        System.out.println("Scalar product : "+t1.scalarProduct(t2));
        System.out.println("Vector product : "+t1.vectorProduct(t2));
        System.out.println("Schurs Product : "+t1.schursProduct(t2));
        System.out.println("Length : "+t1.length());
        System.out.println("Norm : "+t1.norm());
    }*/
}
