
public class Mandelbrot extends Fractal{
    /**
     * This is a constructor.
     * @param low
     * @param high
     * @param nrows
     * @param ncols
     * @param maxlters
     */
    public Mandelbrot(Complex low, Complex high, int nrows, int ncols, int maxlters) {
        this.low = low;
        this.high = high;
        this.nrows = nrows;
        this.ncols = ncols;
        this.maxIters = maxlters;
        this.escapeVals = new int[nrows][ncols]; //determines the size of an array
        this.escapeVals = this.escapes(); //stors all the iterations in the array.
        this.c = new Complex(0.0,0.0); //Mandelbrot class, c is always 0.0, 0.0.
    }

    /**
     * This method is called from Fractal Class, this method calculates number of iterations.
     * @param p as point
     * @return iterations count
     */
    public int escapeCount(Complex p) {
        numIterations = 0;
        Complex temp = new Complex(p.r,p.i);
        for (int i = 0; i < maxIters; i++) {
            double check = Complex.abs(temp);
            if (check <= 2) {
                temp = Complex.mul(temp, temp);
                temp = Complex.add(temp, p);
                numIterations = i;
            } else {
                return i;
            }
        }
        return numIterations+1;
    }

    /**
     * Main method takes all the arguments from command line and creates Mandelbrot object and writes into a file.
     * @param args
     */

    public static void main(String[] args){
        //get arguments from command line.
        Complex low = new Complex(Double.parseDouble(args[0]), Double.parseDouble(args[2]));
        Complex high = new Complex(Double.parseDouble(args[1]), Double.parseDouble(args[3]));
        int nrows = Integer.parseInt(args[4]);
        int ncols = Integer.parseInt(args[5]);
        int maxiters = Integer.parseInt(args[6]);
        String filename = args[7];
        Mandelbrot mandelbrot = new Mandelbrot(low, high, nrows, ncols,maxiters);
        mandelbrot.write(filename);
    }
}
