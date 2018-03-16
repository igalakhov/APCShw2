package hw_81;

public class InsertionSorter extends Sorter {
    InsertionSorter(Comparable[] in){
        super(in);
    }
    public void sort(){
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
}
