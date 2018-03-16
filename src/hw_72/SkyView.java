package hw_72;

import java.util.Arrays;

/**
 solutions by Stuy
 See also CoBo's solution in  apcs-a_frq_2013_sg.pdf
 */

public class SkyView{
    /** A rectangular array that holds the data representing
     a rectangular area of the sky. */
    private double[][] view;

    /** Constructs a SkyView object from a 1-dimensional array of scan data.
     * @param numRows the number of rows represented in the view
     * Precondition: numRows > 0
     * @param numCols the number of columns represented in the view
     * Precondition: numCols > 0
     * @param scanned the scan data received from the telescope,
     * stored in telescope order
     * Precondition: scanned.length == numRows * numCols
     * Postcondition: view has been created as a
     * rectangular 2-dimensional array
     * with numRows rows and numCols columns and the values in
     * scanned have been copied to view and are ordered as
     * in the original rectangular area of sky.
     */
    public SkyView(int numRows, int numCols, double[] scanned){
        // solution 0
        // Loop through each row and col of view
        view = new double[numRows][numCols];

        for(int curIndex = 0; curIndex < scanned.length; curIndex++){
            int curRow = curIndex / numCols; //haha yes integer division
            if(curRow % 2 == 0){
                view[curRow][curIndex % numCols] = scanned[curIndex];
            } else {
                view[curRow][numCols - 1 - (curIndex % numCols)] = scanned[curIndex];
            }
        }
    }


    /**
     Another constructor, to exercise the other classic approach.
     As a convenience for testing, the signature of this constructor
     omits the @numCols param that CoBo specified.

     Besides, was anyone else offended by their redundantly specifying
     the rows, the columns, and the product of those two? Yo, CoBo! NTTSTT!
     */
    public SkyView(int numRows, double[] scanned){
        // solution 1
        // Loops through each element of scanned

        // Use the modulus operator (%) and integer division
        // to calculate the destination row and column.
        this(numRows, (scanned.length / numRows), scanned);
    }


    /** Returns the average of the values in a rectangular section of view.
     * @param startRow the first row index of the section
     * @param endRow the last row index of the section
     * @param startCol the first column index of the section
     * @param endCol the last column index of the section
     * Precondition: 0 <= startRow <= endRow < view.length
     * Precondition: 0 <= startCol <= endCol < view[0].length
     * @return the average of the values in the specified section of view
     */
    public double getAverage(int startRow, int endRow,
                             int startCol, int endCol){
        double sum = 0;
        for(int row = startRow; row <= endRow; row++){
            for(int col = startCol; col <= endCol; col++){
                sum += view[row][col];
            }
        }
        return sum / ((endRow - startRow + 1) * (endCol - startCol + 1));  // Not a Number, used as a placeholder

    }


    // for testing
    public String toString() {
        return stringify2d(view);
    }


    /**
     for testing
     Should be elsewhere, not a member of this class,
     since it works on 2-D arrays in general.
     @return a string version of a 2-D array
     */
    private static String stringify2d( double[][] a) {
        String result = "";
        for( double[] row : a) {
            for( double elem : row)
                result += elem + "  ";
            result += System.lineSeparator();
        }
        return result;
    }
}
