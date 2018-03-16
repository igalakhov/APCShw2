package hw_81;

/**
 test types of sorts that are polymorphic variations of Sorter
 */
public class UserOfSorts {
    public static void main(String[] commandLine) {
        // arrays to be sorted
        Integer[] numbers = new Integer[] {17,5,5,11,3,2,};
        String[] letters =  new String[]
                { "c","g","j","m","d","b","e","p","a",};

        // selection sort
        oneTest( "selection sort on numbers, from " +
                        "67_inplaceSelectionSort/OrderedArrayList_String"
                , new SelectionSorter( numbers)
        );
        oneTest( "selection sort on letters "
                , new SelectionSorter( letters)
        );

        // insertion sort
        oneTest( "insertion sort on numbers, from 69_insertionSort"
                , new InsertionSorter( numbers)
        );
        oneTest( "insertion sort on letters "
                , new InsertionSorter( letters)
        );
    }


    /**
     Run one test
     */
    private static void oneTest( String description
            ,Sorter sorter
    ) {
        System.out.println( System.lineSeparator() + description);
        sorter.sort();
        System.out.println( sorter);
        System.out.println( "sorted: " + sorter.isSorted());
    }
}
