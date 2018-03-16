package hw_84;

/**
 sort an array using merge sort / sub-sort-then-merge sort / submerge sort
 */
public class SubSortThenMerge_Sorter extends Sorter {

    /**
     Invoke the overloading sort method, passing arguments that
     specify the full extent of the list.
     */
    public void sort() {
        this.sort(0, elements.length - 1);
    }
    public void sort(int begin, int end){
        //base case
        if((end - begin) == 1 ){
            return; // we done here
        }
        sort(0, begin + ((end - begin) / 2));
        sort(begin + 1 + ((end - begin) / 2), end);

        merge(begin, begin + 1 + ((end - begin) / 2), end + 1);

    }

    //  --------- code below here has already been tested ---------
    /**
     Merge two ordered sub-lists.
     The sublists are adjacent portions of the @elements field of this object,
     identified by...
     @aBeginAt    the index into @elements of the first element in
     the first list to be merged
     @bBeginAt    like aBeginAt, but for the second list to be merged
     Since the sublists are adjacent, this is also
     the index into @elements that is one greater than
     the index of the last element in the first list to be merged.
     @endBefore   the index into @elements that is one greater than
     the index of the last element in the second list to be merged
     @precondition: sub-lists are sorted in ascending order

     The merged version replaces the sublists in @elements.
     */
    private void merge( final int aBeginAt
            , final int bBeginAt
            , final int endBefore
    ) {
        // temporary storage for the merged list
        Comparable[] result = new Comparable[ endBefore - aBeginAt];
        int resultNext = 0;  // index of next open slot in @result

        // while-style
        // merge elements until one input is exhausted
        int aNext = aBeginAt;
        int bNext = bBeginAt;
        while( aNext < bBeginAt && bNext < endBefore) {
            if( elements[ aNext].compareTo( elements[ bNext]) < 0)
                result[ resultNext] = elements[ aNext++];
            else
                result[ resultNext] = elements[ bNext++];
            resultNext++;
        }

        /* Capture the remaining elements. One input is exhausted,
           so one of the loop bodies is skipped.
         */
        while( aNext < bBeginAt)
            result[ resultNext++] = elements[ aNext++];
        while( bNext < endBefore)
            result[ resultNext++] = elements[ bNext++];

        // replace the sublists with the merged version
        int mNext = aBeginAt;
        for( Comparable r : result)
            elements[ mNext++] = r;
    }


    /**
     construct an instance
     */
    public SubSortThenMerge_Sorter( Comparable[] usersData) {
        super( usersData);
    }
}
