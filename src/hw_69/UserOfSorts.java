import hw_69.*;

/**
 test the Sorts class
 */

public class UserOfSorts {
    public static void main(String[] commandLine) {
        System.out.println( System.lineSeparator());
        Comparable[] fromNotes_20180131 = {"C", "F", "J", "M", "D", "B", "E", "P", "A"};
        Sorts sorts = new Sorts( fromNotes_20180131);
        System.out.println(sorts);
        System.out.println( sorts.isSorted() + " ...expecting false");
        sorts.sort(sorts.SORTS_METHOD_INSERTION);
        System.out.println( sorts.isSorted() + " ...expecting true");
        System.out.println( sorts);
    }
}