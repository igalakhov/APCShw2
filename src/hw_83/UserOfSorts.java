package hw_83;

public class UserOfSorts {
    public static void main(String[] commandLine) {
        // indexes:  0  1   2 3 4   5 6 7 8 9 0  1
        Integer[] source = new Integer[]{-1,-1, 1,3,5,  2,4,5,7,8,9, -1,};
        oneMerge( "merge the positive numbers"
                , new SubSortThenMerge_Sorter( source)
                , 0, 5, 11
        );
        // expecting [-1,-1,1,2,3,4,5,5,7,8,9,-1,]
    }


    /**
     Run one test
     */
    private static void oneMerge( String desc
            , SubSortThenMerge_Sorter merger
            , int aBeginAt
            , int bBeginAt
            , int endBefore
    ) {
        System.out.println( System.lineSeparator() + desc);
        merger.merge( aBeginAt, bBeginAt, endBefore);;
        System.out.println( merger);
    }
}
