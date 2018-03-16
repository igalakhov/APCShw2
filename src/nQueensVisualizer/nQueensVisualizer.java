package nQueensVisualizer;
import java.awt.*;
import java.awt.event.*;

public class nQueensVisualizer {
    private int size;
    public nQueensVisualizer(){
        this(8);
    }
    public nQueensVisualizer(int size){
        this.size = size;
    }
    public void initialize(){
        Frame f = new Frame("nQueens Visualizer");
        Chessboard myBoard = new Chessboard();
        f.add(myBoard);
        //f.setLayout(null);
        f.setSize(500, 500);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        while(true){
            f.repaint();
        }

    }

    /*
        The way that I wrote this will give me nightmares some day
        But it works and I think that's the point
     */
    private static class Chessboard extends Canvas {
        private int[][] board; //the board
        private int size;
        private int x;
        public Chessboard(){
            setSize(500, 500);
            x = 0;
        }
        @Override
        public void paint(Graphics g){
            super.paint(g);
            System.out.println(x);
            x++;
        }
    }
}
