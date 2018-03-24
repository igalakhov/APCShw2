package hw_89;

/**
 test BoardForNQueens
 */

public class UserOfBoard {

    public static void main(String[] commandLine) {
        System.out.println();

        System.out.println( "construct a BoardForNQueens");
        BoardForNQueens b = new BoardForNQueens( 3);
         System.out.println( "size: "  + b.size()
         + " ...expecting 3"
         + System.lineSeparator());

        System.out.println( "toString on an empty board:");
         System.out.println( b
         + System.lineSeparator());


        System.out.println( "queen in top left corner");
        b.populate( 0);
        System.out.println( "minEmptyRank: " + b.minEmptyRank
         + " ...expecting 1");
         System.out.println( b
         + System.lineSeparator());


        System.out.println( "Test isfull() on a partially-full board.");
        System.out.println( "isFull: " + b.isFull()
        + " ...expecting false"
        + System.lineSeparator());


        System.out.println("fill the board");
        b.populate( 2);
        b.populate( 1);
        System.out.println( "minEmptyRank: " + b.minEmptyRank
        + " ...expecting 3");
        System.out.println( b
        + System.lineSeparator());


         System.out.println( "Test isfull() on a full board.");
         System.out.println( "isFull: " + b.isFull()
         + " ...expecting true"
         + System.lineSeparator());


         System.out.println("remove the queen from the most-recently-populated rank");
         b.depopulate( );
         System.out.println( "minEmptyRank: " + b.minEmptyRank
         + " ...expecting 2");
         System.out.println( b
         + System.lineSeparator());


        System.out.println("test lastIsOk");
        System.out.println( "lastIsOk: " + b.lastIsOk()
        + " ...expecting true"
        + System.lineSeparator());


         System.out.println("Does lastIsOk detect an attack along a file?");
         b.populate( 0);
         System.out.println( b);
         System.out.println( "lastIsOk: " + b.lastIsOk()
         + " ...expecting false"
         + System.lineSeparator());
         b.depopulate();


        System.out.println("Does lastIsOk detect an attack along a NE diagonal?");
        b.populate( 1);
         System.out.println( b);
         System.out.println( "lastIsOk: " + b.lastIsOk()
         + " ...expecting false"
         + System.lineSeparator());
        b.depopulate();


        // System.out.println("Does lastIsOk detect an attack along a NW diagonal?");
        // b.depopulate( ); // leaving only NW corner
        // b.populate( 1);
        // System.out.println( b);
        // System.out.println( "lastIsOk: " + b.lastIsOk()
        // + " ...expecting false"
        // + System.lineSeparator());
        // b.depopulate( );
    }
}