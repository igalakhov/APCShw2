package nQueensVisualizer;

import java.util.Arrays;

public class userOfVisualizer {
    public static void main(String[] args){
        System.out.println("hai");
        nQueensVisualizer visualizer = new nQueensVisualizer(8);
        int[][] test = new int[8][8];
        visualizer.updateBoard(test);
    }
}
