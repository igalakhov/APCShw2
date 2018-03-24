package mazeSolver.mazeVisualizer;

import mazeSolver.mazeUtil.*;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferStrategy;
import java.util.*;
import javax.swing.*;

public class MazeVisualizer {
    VisualMaze loadedMaze;

    public MazeVisualizer(Maze toVisualize){
        loadedMaze = new VisualMaze(toVisualize);

        JFrame jp = new JFrame();
        jp.getContentPane().add(loadedMaze, BorderLayout.CENTER);
        jp.setSize(800, 800);
        jp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jp.setVisible(true);

    }


    //internal maze
    //this is the actual operational class
    private static class VisualMaze extends Canvas implements Runnable{
        //maze cell width and height
        private int cellWidth, cellHeight;
        //loaded maze
        private Maze loadedMaze;
        /*
            Create new visual maze
         */
        public VisualMaze(Maze toVisualize){
            //copy maze
            loadedMaze = toVisualize;

            //find cell dimentions from beginning
            cellWidth = this.getWidth()/loadedMaze.getWidth();
            cellHeight = this.getHeight()/loadedMaze.getHeight();
            //start thread
            Thread u = new Thread(this);
            u.start();
        }
        @Override
        public void paint(Graphics g){
            super.paint(g);
            //update dimentions
            cellWidth = this.getWidth()/loadedMaze.getWidth();
            cellHeight = this.getHeight()/loadedMaze.getHeight();

            drawMazeWalls(g);
        }
        public void drawMazeWalls(Graphics g){
            for(int row = 0; row < loadedMaze.getWidth(); row++){
                for(int col = 0; col < loadedMaze.getHeight(); col++){
                    Cell curCell = loadedMaze.getCell(row, col);
                    g.setColor(Color.BLACK);
                    if(Math.random() > 0.5){
                        g.setColor(Color.RED);
                    }
                    g.drawRect(row*cellWidth, col*cellHeight,
                            cellWidth, cellHeight);
                }
            }
        }
        public void run(){
            this.createBufferStrategy(2);
            BufferStrategy strategy = this.getBufferStrategy();
            while(true){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                if(strategy != null) {
                    paint(getGraphics());
                }
            }
        }
    }
}
