/**
 * Author: Hammad Hanif
 * We created Complex class to generate complex numbers.
 */
public class Complex {

    public double r = 0.0;
    public double i = 0.0;

    /**
     * Constructor
     * @param r as real number
     * @param i as imaginary number
     */
    public Complex(double r, double i) {
        this.r = r;
        this.i = i;
    }

    /**
     * This method adds 2 complex numbers.
     * @param a as first complex number
     * @param b as second complex number.
     * @return
     */
    public static Complex add(Complex a, Complex b) {
        double real = a.r + b.r;
        double imagine = a.i + b.i;
        Complex com = new Complex(real, imagine);
        return com;
    }

    /**
     * This method subtract 2 complex numbers.
     * @param a as first complex number.
     * @param b as second complex number.
     * @return complex number after substraction.
     */
    public static Complex sub(Complex a, Complex b) {
        double real = a.r - b.r;
        double imagine = a.i - b.i;
        Complex com = new Complex(real, imagine);
        return com;
    }
    /**
     * This method multilies 2 complex numbers.
     * @param a as first complex input.
     * @param b as second complex input.
     * @return complex number after multiplication.
     */
    public static Complex mul(Complex a, Complex b) {
        double real = ((a.r * b.r) - (a.i * b.i));
        double imagine = ((a.r * b.i) + (a.i * b.r));
        Complex com = new Complex(real, imagine);
        return com;
    }

    /**
     * @param c is a complex input
     * @return abs value of Complex number
     */
    public static double abs(Complex c) {
        double rSq = c.r * c.r;
        double iSq = c.i * c.i;
        return Math.sqrt(rSq + iSq);
    }

    /**
     * creates a copy of a Complex number.
     * @return copy of a original Complex.
     */
    public Complex copy() {
        // TODO Auto-generated method stub
        return new Complex(r, i);
    }
}
