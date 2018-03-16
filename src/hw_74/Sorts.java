package hw_74;

import java.util.Arrays;

/**
 Implementations of sorting an array
 */

public class Sorts {

    private Comparable[] data;  // avoid changing the user's data
    public final static int SELECTION_METHOD = 0;
    public final static int INSERTION_METHOD = 1;

    // bubble sort variants
    public final static int BUBBLE_LARGE_METHOD      = 2; // common 2018-02-09
    public final static int BUBBLE_SMALL_METHOD      = 3; // recommended 2018-02-10
    public final static int BUBBLE_EARLY_EXIT_METHOD = 4; // upcoming demo
    public final static int BUBBLE_DO_WHILE_METHOD   = 5; // upcoming demo


    /**
     bubble sort
     */
    private void bubbleSort_small() {
        while(true){
            boolean notSwapped = true;
            for(int i = 0; i < data.length - 1; i++){
             if(data[i].compareTo(data[i + 1]) > 0){
                 notSwapped = false;
                 Comparable temp = data[i];
                 data[i] = data[i + 1];
                 data[i + 1] = temp;
             }
            }
            if(notSwapped){
                break;
            }
            System.out.println(Arrays.toString(data));
        }
    }

    /**
     Sort the data, invoking the specified method.
     */
    public void sort( final int method) {
        if(      method == SELECTION_METHOD)    selectionSort();
        else if( method == INSERTION_METHOD)    insertionSort();

            // bubble sort variants
        else if( method == BUBBLE_SMALL_METHOD) bubbleSort_small();
            // else if( method == BUBBLE_EARLY_EXIT_METHOD) bubbleSort_earlyExit();
            // else if( method == BUBBLE_DO_WHILE_METHOD  ) bubbleSort_doWhile();

        else System.out.println( "sort not yet implemented");
    }


    // ------ code already tested in 69_insertionSort ------
    // constructor: make a private copy of the user's data
    public Sorts( Comparable[] usersData) {
        data = new Comparable[ usersData.length];
        for( int i = 0; i < usersData.length; i++)
            data[i] = usersData[i];
    }


    /**
     @return a string representation of the data
     */
    public String toString() {
        String result = "[";
        for( Comparable d : data)
            result += d + ",";
        return result + "]";
    }


    /**
     @return the boolean value of the statement
     "the data is in ascending order"
     */
    public boolean isSorted() {
        for( int i = 0
             ; i < data.length-1 // stop early, because comparing to next
                ; i++
                )
            if( data[i].compareTo( data[ i+1]) > 0) return false;
        return true;
    }


    /**
     insertion sort
     */
    private void insertionSort() {
        //  outer loop through the indexes whose values need sorting.
        for( int indexOfValueToBeSorted = 1 // 0 is already sorted, trivially
             ; indexOfValueToBeSorted < data.length
                ; indexOfValueToBeSorted++
                ) {
            Comparable valueToBeSorted = data[ indexOfValueToBeSorted];

            // destination hunt inner loop: Where among the already-sorted
            // values does valueToBeSorted belong? Look left.
            int indexAlreadySorted;  // The index is used after the loop.
            for( indexAlreadySorted = indexOfValueToBeSorted -1
                 ; indexAlreadySorted >= 0
                    ; indexAlreadySorted--
                    )
                if( valueToBeSorted.compareTo( data[ indexAlreadySorted]) <= 0)
                    // Shift the already-sorted value to the right,
                    // to open a hole.
                    data[ indexAlreadySorted +1] = data[indexAlreadySorted];
                else break; // found the destination

            // When we get here (after the destination-hunting loop), the
            // destination is known, so drop the valueToBeSorted in the hole.
            data[ indexAlreadySorted +1] = valueToBeSorted;

            // for debugging, after each insertion
            System.out.println( "  debugging: boundary follows index "
                    + indexOfValueToBeSorted
                    + "  data: " + toString()
            );
        } // end of "outer loop through the indexes whose values need sorting"
    }


    /**
     selection sort
     */
    private void selectionSort() {
        System.out.println( "sort not yet implemented");
    }


    /**
     someday: To be useful, the class probably require a .get method.
     But testing it requires an .equals method.
     That complication seems not worthwhile at this point.
     This code is retained as a placeholder of good intentions.
     @return a reference to the data
     */
    // public Comparable[] get() {
    // }
}