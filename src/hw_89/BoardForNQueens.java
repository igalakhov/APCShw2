package hw_89;

import java.util.Arrays;

/**
 Represent an nxn board for use with the n-queens problem.
 Since each rank needs exactly 1 queen, represent the state of the
 board by a one-dimensional array, where the element at index @rank
 is the file number that holds a queen in that rank.
 */

public class BoardForNQueens {

    private int[] filesForQueens; /* filesForQueens[ rank] holds the
       file number for the queen in that rank */
    public int minEmptyRank;  /* the smallest-numbered rank that
       lacks a queen, or the board size if all ranks have been populated.

       Values in filesForQueens are meaningless for ranks >= minEmptyRank.

       This field should be private, since NQueensSover should not
       use it. It is public here only for testing in UserOfBoard. */


    /**
     Construct an instance for a board of the given @size.
     */
    public BoardForNQueens( int size) {
        minEmptyRank = 0;
        filesForQueens = new int[size];
        for(int i = 0; i < filesForQueens.length; i++){
            filesForQueens[i] = -1;
        }
    }


    /**
     @return the size of the board
     */
    public int size() {
        return filesForQueens.length;
    }


    /**
     @return the boolean value of the statement...
     "The board is full"
     Equivalently, "No more queens are required."
     */
    public boolean isFull() {
        for(int i = 0; i < filesForQueens.length; i++){
            if(filesForQueens[i] == -1) return false;
        }
        return true;
    }


    /**
     Populate the next rank with a queen in position @file
     */
    public void populate( int file) {
        filesForQueens[minEmptyRank++] = file;
    }


    /**
     Reset the board to have no queen in the last-populated rank.
     @precondition: Some rank(s) have been populated.
     */
    public void depopulate() {
        filesForQueens[--minEmptyRank] = -1;
    }


    /**
     @return the boolean value of the statement
     "the last-added queen attacks no other"
     We can limit checking to the last-added queen because...
     @precondition: the board was ok before the last addition,
     with no queen attacking another.
     */
    public boolean lastIsOk() {
        //make a board
        int[][] tempBoard = new int[filesForQueens.length][filesForQueens.length];
        for(int i = 0; i < filesForQueens.length; i++){
            if(filesForQueens[i] != -1){
                tempBoard[i][filesForQueens[i]] = 1;
            }
        }

        int queenRow = minEmptyRank - 1;
        int queenCol = filesForQueens[minEmptyRank - 1];
        for(int i = 0; i < tempBoard.length; i++){
            if(i != queenCol){
                if(tempBoard[queenRow][i] == 1){
                    return false;
                }
            }
        }
        for(int i = 0; i < tempBoard.length; i++){
            if(i != queenRow){
                if(tempBoard[i][queenCol] == 1){
                    return false;
                }
            }
        }
        for(int i = 1; (queenRow - i) >= 0 && (queenCol + i) < tempBoard.length; i++ ){
            if(tempBoard[queenRow- i][queenCol + i] == 1){
               return false;
            }
        }
        for(int i = 1; (queenRow - i) >= 0 && (queenCol - i) >= 0; i++ ){
            if(tempBoard[queenRow - i][queenCol - i] == 1){
                return false;
            }
        }
        for(int i = 1; (queenRow + i) < tempBoard.length && (queenCol - i) >= 0; i++ ){
            if(tempBoard[queenRow + i][queenCol - i] == 1){
                return false;
            }
        }
        for(int i = 1; (queenRow + i) < tempBoard.length && (queenCol + i) < tempBoard.length; i++ ){
            if(tempBoard[queenRow + i][queenCol + i] == 1){
                return false;
            };
        }
        return true;

    }


    // --------- skeletal code below here needs no modification ---------
    /**
     @return a string representation of this board
     */
    public String toString() {
        int n = filesForQueens.length; // just for shorthand

        /* Make a header containing file numbers like
               files
               0  1  2  3 ...
               __________ ...
         */
        String indent = "         ";
        String pic =   indent + "files" + System.lineSeparator()
                + indent;
        String underscores = "";

        // append a file number, in a 3-column field
        for( int file = 0; file < n; file++) {
            pic += String.format("%-3d", file);
            underscores += "___"; // there's gotta be a better way
        }

        pic+=   System.lineSeparator()
                + indent + underscores + System.lineSeparator();

        // picture each rank
        for( int rank = 0; rank < n; rank++){
            pic += // right-justified rank number:
                    String.format("rank %2d|", rank);
            for( int file = 0; file < n; file++)
                if(    rank >= minEmptyRank      // no queen in this rank yet
                        || filesForQueens[rank] != file) // no queen in this file
                    pic += " _ ";
                else pic += " Q ";
            pic += System.lineSeparator();
        }
        return pic;
    }
}