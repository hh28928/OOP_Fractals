
public class Julia extends Fractal{
    /**
     * Constructor
     * @param low
     * @param high
     * @param nrows
     * @param ncols
     * @param maxIters
     * @param c
     */
    public Julia (Complex low, Complex high, int nrows, int ncols, int maxIters, Complex c) {
        this.low = low;
        this.high = high;
        this.nrows = nrows;
        this.ncols = ncols;
        this.maxIters = maxIters;
        this.c = c;
        escapeVals = new int[nrows][ncols]; //determines the size of an array
        this.escapeVals = this.escapes(); //stores all the values in the 2D array.
    }

    /**
     * This method uses the methods from Fractal class and finds each iteration counts
     * @param p as point
     * @return Number of iterations
     */
    @Override
    public int escapeCount(Complex p) {
        // TODO Auto-generated method stub
        numIterations = 0;
        Complex temp = new Complex(p.r,p.i);
        for (int i = 0; i <= maxIters; i++) {
            double check = Complex.abs(temp);
            if (check <= 2) {
                numIterations = i;
                temp = Complex.mul(temp, temp);
                temp = Complex.add(temp, c);
            }
        }
        return numIterations;
    }

    /**
     * Main method takes all the arguments from command line and creates Julia object and writes into a file.
     * @param args
     */
    public static void main(String[] args) {
        Complex low = new Complex(Double.parseDouble(args[0]),  Double.parseDouble(args[2]));
        Complex high = new Complex(Double.parseDouble(args[1]),Double.parseDouble(args[3]));
        int nrows = Integer.parseInt(args[4]);
        int ncols = Integer.parseInt(args[5]);
        int maxIters = Integer.parseInt(args[6]);
        Complex com = new Complex(Double.parseDouble(args[7]), Double.parseDouble(args[8]));
        String filename = args[9];
        Julia julia = new Julia(low, high, nrows,ncols,maxIters,com);
        julia.write(filename);
    }
}
