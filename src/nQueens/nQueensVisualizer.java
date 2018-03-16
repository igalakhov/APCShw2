package nQueens;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class nQueensVisualizer{
    private int size;
    private Chessboard board;
    public nQueensVisualizer(int size){
        board = new Chessboard(size);
        this.size = size;
        JFrame jp = new JFrame();
        jp.getContentPane().add(board, BorderLayout.CENTER);
        jp.setSize(800, 800);
        jp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jp.setVisible(true);
    }
    public void updateBoard(int[][] newBoard){
        //create a copy of the board
        int[][] toAdd = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                toAdd[i][j] = newBoard[i][j];
            }
        }
        board.addBoard(toAdd);
    }
    private static class Chessboard extends Canvas implements Runnable{
        private int size;
        private ArrayList<int[][]> layoutQueue;
        public int[][] curLayout;
        private int squareWidth;
        private int squareHeight;
        public Chessboard(int size){
            this.size = size; //haha yes
            squareWidth = this.getWidth()/size;
            squareHeight = this.getHeight()/size;
            curLayout = new int[size][size];
            layoutQueue = new ArrayList<>();
            Thread u = new Thread(this);
            u.start();
        }
        public void addBoard(int[][] newBoard){
            layoutQueue.add(newBoard);
        }
        private void nextBoard(){
            if(layoutQueue.size() != 0) {
                curLayout = layoutQueue.get(0);
                layoutQueue.remove(0);
            }
        }
        //run (basically keep repainting when we can)
        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(250);
                } catch (InterruptedException e) {}
                nextBoard();
                repaint();
            }
        }
        public void paint(Graphics g){
            super.paint(g); //clear everything
            squareWidth = this.getWidth()/size;
            squareHeight = this.getHeight()/size;
            drawChessboard(g);
            drawQueens(g);
            drawAllAttacks(g);
        }
        private void drawAllAttacks(Graphics g){
            for(int i = 0; i < curLayout.length; i++){
                for(int j = 0; j < curLayout.length; j++){
                    if(curLayout[i][j] == 1){
                        drawAllAttacksFromQueen(g, i, j);
                    }
                }
            }
        }
        private void drawAllAttacksFromQueen(Graphics g, int row, int col){
            //check attacks left and right
            //drawArrow(g, row * squareWidth, col * squareHeight, 0, 0);
            for(int i = 0; i < size; i++){
                if(curLayout[row][i] == 1 && i != col){
                    g.setColor(Color.RED);
                    drawArrow(g, col * squareWidth + squareWidth/2, row * squareHeight + squareHeight/2,
                            i * squareWidth + squareWidth/2, row * squareHeight + squareHeight/2);
                    g.setColor(Color.BLACK);
                }
            }
            //check attacks top and bottom
            for(int i = 0; i < size; i++){
                if(curLayout[i][col] == 1 && i != row){
                    g.setColor(Color.RED);
                    drawArrow(g, col * squareWidth + squareWidth/2, row * squareHeight + squareHeight/2,
                            col * squareWidth + squareWidth/2, i * squareHeight + squareHeight/2);
                    g.setColor(Color.BLACK);
                }
            }
            //check the 4 existing diagonals
            for(int i = 1; (row - i) >= 0 && (col + i) < size; i++){
                if(curLayout[row - i][col + i] == 1){
                    g.setColor(Color.RED);
                    drawArrow(g, col * squareWidth + squareWidth/2, row * squareHeight + squareHeight/2,
                            (col + i) * squareWidth + squareWidth/2, (row - i) * squareHeight + squareHeight/2);
                    g.setColor(Color.BLACK);
                }
            }
            for(int i = 1; (row - i) >= 0 && (col - i) >= 0; i++){
                if(curLayout[row - i][col - i] == 1){
                    g.setColor(Color.RED);
                    drawArrow(g, col * squareWidth + squareWidth/2, row * squareHeight + squareHeight/2,
                            (col - i) * squareWidth + squareWidth/2, (row - i) * squareHeight + squareHeight/2);
                    g.setColor(Color.BLACK);
                }
            }
            for(int i = 1; (row + i) < size && (col - i) >= 0; i++){
                if(curLayout[row + i][col - i] == 1){
                    g.setColor(Color.RED);
                    drawArrow(g, col * squareWidth + squareWidth/2, row * squareHeight + squareHeight/2,
                            (col - i) * squareWidth + squareWidth/2, (row + i) * squareHeight + squareHeight/2);
                    g.setColor(Color.BLACK);
                }
            }
            for(int i = 1; (row + i) < size && (col + i) < size; i++){
                if(curLayout[row + i][col + i] == 1){
                    g.setColor(Color.RED);
                    drawArrow(g, col * squareWidth + squareWidth/2, row * squareHeight + squareHeight/2,
                            (col + i) * squareWidth + squareWidth/2, (row + i) * squareHeight + squareHeight/2);
                    g.setColor(Color.BLACK);
                }
            }



        }
        void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {
            Graphics2D g = (Graphics2D) g1.create();

            double dx = x2 - x1, dy = y2 - y1;
            double angle = Math.atan2(dy, dx);
            int len = (int) Math.sqrt(dx*dx + dy*dy);
            AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
            at.concatenate(AffineTransform.getRotateInstance(angle));
            g.transform(at);

            // Draw horizontal arrow starting in (0, 0)
            g.drawLine(0, 0, len, 0);
            g.fillPolygon(new int[] {len, len-4, len-4, len},
                    new int[] {0, -4, 4, 0}, 4);
        }

        private void drawQueens(Graphics g){
            for(int i = 0; i < curLayout.length; i++){
                for(int j = 0; j < curLayout.length; j++){
                    if(curLayout[j][i] == 1) {
                        g.setColor(Color.GRAY);
                        g.fillOval(i * squareWidth + squareWidth/4, j * squareHeight + squareHeight/4, squareWidth/2, squareHeight/2);
                        g.setColor(Color.BLACK);
                    }
                }
            }
        }
        private void drawChessboard(Graphics g){
            for(int i = 0; i < (this.getWidth()/squareWidth); i += 1){
                for(int j = 0; j < (this.getHeight()/squareHeight); j += 1){
                    if((i + j) % 2 == 0) {
                        g.setColor(Color.BLACK);
                        g.fillRect(i * squareWidth, j * squareHeight, squareWidth, squareHeight);
                        g.setColor(Color.WHITE);
                    }
                }
            }
        }
    }

}
