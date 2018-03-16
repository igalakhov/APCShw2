package hw_83;

import java.util.Arrays;

public class SubSortThenMerge_Sorter extends Sorter {

    /**
     construct an instance
     */
    public SubSortThenMerge_Sorter( Comparable[] usersData) {
        super( usersData);
    }


    /**
     selection sort
     */
    public void sort() {
        // soon
    }


    /**
     Merge two ordered sub-lists.
     The sublists are adjacent portions of the @elements field of this object,
     identified by
     aBeginAt     the index into @elements of the first element in
     the first list to be merged
     bBeginAt     like aBeginAt,   but for the second list to be merged
     Since the sublists are adjacent, this is also
     the index into @elements that is one greater than
     the index of the last element in the first list to be merged.
     endBefore    the index into @elements that is one greater than
     the index of the last element in the second list to be merged
     @precondition: sub-lists are sorted in ascending order

     The merged version replaces the sublists in @elements.
     Based on work in 79_merge/

     This merge method should be private, but I'm starting it as public
     so that it is convenient to test from UserOfSorts.java.
     */
    public void merge( int aBeginAt
            , int bBeginAt
            , int endBefore
    ) {
        // temporary storage for the merged list
        Comparable[] result = new Comparable[endBefore - aBeginAt];
        int pointer1 = aBeginAt;
        int pointer2 = bBeginAt;
        for(int i = 0; i < result.length; i++){
            if(pointer1 >= bBeginAt){
                result[i] = elements[pointer2];
                pointer2++;
                continue;
            }
            if(pointer2 >= endBefore){
                result[i] = elements[pointer1];
                pointer1++;
                continue;
            }
            if(elements[pointer1].compareTo(elements[pointer2]) < 0){
                result[i] = elements[pointer1];
                pointer1++;
            } else {
                result[i] = elements[pointer2];
                pointer2++;
            }
        }
        for(int i = aBeginAt; i < endBefore; i++){
            elements[i] = result[i - aBeginAt];
        }




    }
}
