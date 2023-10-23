package sae.lanceurderayons.model;

public class Color {

    private Triplet rgb;

    public Color(double r, double g, double b) {
        this.rgb = new Triplet(r,g,b);
    }

    public double getRValue() {
        return this.rgb.getX();
    }

    public double getGValue() {
        return this.rgb.getY();
    }

    public double getBValue() {
        return this.rgb.getZ();
    }

    public Triplet addition(Triplet triplet) {
        return rgb.addition(triplet);
    }

    public Triplet multiplyUsingAScalar(double d) {
        return rgb.multiplyUsingAScalar(d);
    }

    public Triplet schursProduct(Triplet triplet) {
        return rgb.schursProduct(triplet);
    }
}
