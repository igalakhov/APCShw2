package hw_74;

/**
 test the Sorts class
 */

public class UserOfSorts {
    public static void main(String[] commandLine) {
        System.out.println( System.lineSeparator());

        // tests for bubbling the SMALLEST as-yet-unsorted element leftwards
        System.out.println( "scrambled input");
        Integer[] scrambled = {9,7,1,5,3,};
        oneTest( scrambled, Sorts.BUBBLE_SMALL_METHOD);

        System.out.println( "backwards input");
        oneTest(
                new Integer[]{9,7,5,3,1,}  // funky: anonymous array
                , Sorts.BUBBLE_SMALL_METHOD);

        System.out.println( "mostly-sorted input");
        oneTest( new Integer[]{1,3,5,9,7,}, Sorts.BUBBLE_SMALL_METHOD);

        System.out.println( "the ties that blind");
        oneTest( new Integer[]{8,8,8},     Sorts.BUBBLE_SMALL_METHOD);

        // abandoned:
        // // tests for bubbling the LARGEST as-yet-unsorted element rightwards
        // System.out.println( "scrambled input");
        // oneTest( new Integer[]{7,5,12,1,3}, Sorts.BUBBLE_LARGE_METHOD);
        // System.out.println( "mostly-sorted input");
        // oneTest( new Integer[]{3,1,5,7,12}, Sorts.BUBBLE_LARGE_METHOD);
    }


    /**
     Run one test
     */
    private static void oneTest( Comparable[] sortMe, final int sortMethod) {
        Sorts sorts = new Sorts( sortMe);
        System.out.println( sorts);
        System.out.println( "sorted: " + sorts.isSorted());
        sorts.sort( sortMethod);
        System.out.println( "sorted: " + sorts.isSorted());
        System.out.println();
    }
}

