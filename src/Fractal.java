import java.io.FileWriter;
import java.io.IOException;

/**
 * Fractal is an abstract class that holds all the escape counts in an array of either Mandebrot and Julia.
 * All the field have been created in this class and are used across Julia and Mandelbrot.
 * This class is also a super class.
 */
public abstract class Fractal {
    Complex low, high;
    int nrows, ncols;
    int maxIters;
    int[][] escapeVals;
    int numIterations = 0;
    Complex c;

    /**
     * abstract method and is computed in Julia and Mandelbrot.
     * @param p
     * @return number of iterations it took to escape.
     */
    public abstract int escapeCount(Complex p);

    /**
     * stores all the escape iterations in an array.
     * @return escapeVals 2D array
     */
    public int[][] escapes() {
        double Real = (high.r-low.r) / (ncols -1);
        double Imaginary = (high.i-low.i) / (nrows - 1);
        Complex Z = new Complex(0.0,0.0);
        for (int i = 0; i < nrows; i++) {
            Z.i = high.i - i*Imaginary;
            for (int j = 0; j < ncols; j++) {
                Z.r = low.r + j*Real;
                numIterations = escapeCount(Z);
                escapeVals[i][j] = numIterations;
            }
        }
        return escapeVals;
    }

    /**
     * Writes to a file
     * @param filename
     */
    public void write(String filename) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filename);
            fileWriter.write(nrows + " " + ncols + " " + maxIters + System.lineSeparator());
            fileWriter.write(low.r + " " + high.r + " " + low.i + " " + high.i + System.lineSeparator());
            fileWriter.write(c.r + " " + c.i + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
            escapeVals = this.escapes();
            String str = "";
            for (int i = 0; i < escapeVals.length; i++) {
                fileWriter.write(System.lineSeparator());
                str = "";
                for (int j = 0; j < escapeVals[i].length; j++) {
                    str = str + escapeVals[i][j] + " ";
                }
                fileWriter.write(str);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method zooms in across the center.
     * @param factor
     */
    public void zoom(double factor) {
        Complex center = new Complex(((high.r + low.r) / 2), ((high.i + low.i) / 2));
        double scale = 1.0 / factor;
        double width = high.r - low.r;
        double height = high.i - low.i;
        double x = (scale * width) / 2;
        double y = (scale * height) / 2;
        high.i = center.i + y;
        high.r = center.r + x;
        low.r = center.r - x;
        low.i = center.i - y;

    }

    /**
     * This method resets low and high.
     * @param low
     * @param high
     */
    public void updateDimensions(Complex low, Complex high) {
        this.low = low;
        this.high = high;
    }
}
