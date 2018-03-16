package nQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nQueensSolver {
    private int[][] board;
    private int[] queenPositions;
    /*
       Algorithm
       0. Randomly place all queens in each row
       1. Find the queen with most conflicts
       2. Move that queen (in its row) to a position with least conflicts)
       3. Rinse and repeat until no conflicts
     */
    public nQueensSolver(){
       this(8);
    }
    public nQueensSolver(int size){
        if(size < 4){
            size = 4;
        }
        board = new int[size][size];
        queenPositions = new int[size];
        //place queens randomly in each row
        for(int i = 0; i < board.length; i++){
            int newPos = (int)(Math.random() * size);
            board[i][newPos] = 1;
            queenPositions[i] = newPos;
        }
    }
    //finds the total number of attacks for all queens
    public int countAllAttacks(){
        int total = 0;
        for(int i = 0; i < board.length; i++){
            total += findAttacks(i, queenPositions[i]);
        }
        return total;
    }

    //moves queen to new position
    public void moveQueen(int row, int newPos){
        board[row][queenPositions[row]] = 0;
        board[row][newPos] = 1;
        queenPositions[row] = newPos;
    }
    //find the number of attacks for a certain point
    private int findAttacks(int row, int column){
        int numAttacks = 0;
        //find attacks horizontally
        for(int i = 0; i < board.length; i++){
            if(i != column && board[row][i] == 1){
                numAttacks++;
            }
        }
        //find attacks vertically
        for(int i = 0; i < board.length; i++){
            if(i != row && board[i][column] == 1){
                numAttacks++;
            }
        }
        //iterate through the 4 diagonals
        for(int i = 1; (row - i) >= 0 && (column + i) < board.length; i++ ){
            if(board[row - i][column + i] == 1){
                numAttacks++;
            }
        }
        for(int i = 1; (row - i) >= 0 && (column - i) >= 0; i++ ){
            if(board[row - i][column - i] == 1){
                numAttacks++;
            }
        }
        for(int i = 1; (row + i) < board.length && (column - i) >= 0; i++ ){
            if(board[row + i][column - i] == 1){
                numAttacks++;
            }
        }
        for(int i = 1; (row + i) < board.length && (column + i) < board.length; i++ ){
            if(board[row + i][column + i] == 1){
                numAttacks++;
            };
        }




        return numAttacks;
    }
    public void solve(){
        int iterNum = 0;
        int lastMoved = -1;
        while(true){
            //break if we solved everything
            if(countAllAttacks() == 0){
                break;
            }

            //find most attacked queen
            int curChamp = 0;
            int curMostAttacks = findAttacks(0, queenPositions[0]);
            for(int i = 0; i < board.length; i++){
                if(i == lastMoved) continue;
                int tempAttacks  = findAttacks(i, queenPositions[i]);
                if(tempAttacks >= curMostAttacks){
                    curMostAttacks = tempAttacks;
                }
            }

            //list of most attacked queens
            List<Integer> allQueens = new ArrayList<Integer>();
            for(int i = 0; i < board.length; i++){
                int tempAttacks  = findAttacks(i, queenPositions[i]);
                if(tempAttacks == curMostAttacks){
                    allQueens.add(i);
                }
            }
            curChamp = allQueens.get((int)(Math.random() * allQueens.size()));

            //find least attacked square in that row (not counting the one the queen is in)
            int curAttackChamp = 0;
            int curAttackChampNum = board.length + 1; //always overwritten
            for(int i = 0; i < board.length; i++){
                if(i == queenPositions[curChamp]) continue;
                int curAttackNum = findAttacks(curChamp, i);
                if(curAttackNum < curAttackChampNum){
                    curAttackChamp = i;
                    curAttackChampNum = curAttackNum;
                }
            }
            //move the queen to the least attacked spot in its row
            moveQueen(curChamp, curAttackChamp);
            //System.out.println(toString());
            System.out.println("Iteration Number: " + iterNum);
            System.out.println("Number of Attacks: " + countAllAttacks());
            iterNum++;
            System.out.println(" ");

            //reset if needed (to prevent local minimum)
            if(iterNum > 5000){
                for(int i = 0; i < board.length; i++){
                    int newPos = (int)(Math.random() * board.length);
                    board[i][newPos] = 1;
                    queenPositions[i] = newPos;
                }
                iterNum = 0;
            }
        }
    }
    public String niceToString(){
        String toReturn = "";
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board.length; column++){
                if(board[row][column] == 1){
                    toReturn += "Q";
                } else if((row + column) % 2 == 0){
                    toReturn += "+";
                } else {
                    toReturn += "-";
                }
                toReturn += " ";
            }
            toReturn += "\n";
        }
        return toReturn;
    }
    public String toString(){
        String toReturn = "";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                toReturn += " " + board[i][j];
            }
            toReturn += "\n";
        }
        return toReturn;
    }
}
