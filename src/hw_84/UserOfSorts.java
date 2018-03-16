package hw_84;

/**
 test merge sort aka sub-sort-then-merge sort
 */

public class UserOfSorts {
    public static void main(String[] commandLine) {
        // arrays to be sorted
        Integer[] numbers = new Integer[] {17,5,5,11,3,2,};
        String[] letters =  new String[]
                { "c","g","j","m","d","b","e","p","a",};

        oneSort( "sub-sort-then-merge sort on numbers"
                , new SubSortThenMerge_Sorter( numbers)
        );
        oneSort( "sub-sort-then-merge sort on letters"
                , new SubSortThenMerge_Sorter( letters)
        );
    }


    /**
     Run one SORT test
     */
    private static void oneSort( String description
            , Sorter sorter
    ) {
        System.out.println( System.lineSeparator() + description);
        sorter.sort();
        System.out.println( sorter);
        System.out.println( "sorted: " + sorter.isSorted());
    }
}
