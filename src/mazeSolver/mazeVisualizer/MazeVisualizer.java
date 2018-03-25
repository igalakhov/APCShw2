package mazeSolver.mazeVisualizer;

import mazeSolver.mazeUtil.*;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class MazeVisualizer {
    VisualMaze loadedMaze;

    public MazeVisualizer(Maze toVisualize){
        loadedMaze = new VisualMaze(toVisualize);

        JFrame jp = new JFrame("( ͡° ͜ʖ ͡°) aren't mazes aMAZing? ( ͡° ͜ʖ ͡°)");
        jp.getContentPane().add(loadedMaze, BorderLayout.CENTER);
        jp.setSize(800, 800);
        jp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jp.setVisible(true);

    }
    public void saveSnippet(){
        loadedMaze.saveSnippet();
    }
    //internal maze
    //this is the actual operational class
    private static class VisualMaze extends JPanel implements Runnable{
        private Maze loadedMaze;
        private Color[][] curLayout;
        private int cellWidth, cellHeight;
        private List<Color[][]> mazeQueue;

        public VisualMaze(Maze toVisualize){
            //save thread
            loadedMaze = toVisualize;
            mazeQueue = new ArrayList<>();
            saveSnippet();

            //set size
            this.setSize(800, toVisualize.getHeight() * 800);

            //get components
            cellWidth = this.getWidth()/loadedMaze.getWidth();
            cellHeight = this.getHeight()/loadedMaze.getHeight();
            System.out.println(cellWidth + ", " + cellHeight);
            System.out.println(getHeight());

            //thread
            Thread u = new Thread(this);
            u.start();
        }
        public void saveSnippet(){
            mazeQueue.add(loadedMaze.copyColors());
        }
        public void paintComponent(Graphics g) {
            //clear
            super.paintComponent(g);

            //update components
            cellWidth = this.getWidth()/loadedMaze.getWidth();
            cellHeight = this.getHeight()/loadedMaze.getHeight();

            //draw maze cells
            drawCells(g);
        }
        public void drawCells(Graphics g){
            for(int x = 0; x < loadedMaze.getWidth(); x++){
                for(int y = 0; y < loadedMaze.getHeight(); y++){
                    Cell curCell = loadedMaze.getCell(x, y);
                    //draw walls
                    g.setColor(curLayout[x][y]);
                    g.fillRect(x * cellWidth, y * cellHeight,  cellWidth, cellHeight);
                    g.setColor(Color.BLACK);
                    g.fillRect(x * cellWidth, y * cellHeight,  cellWidth/3 + 1, cellHeight/3 + 1);
                    g.fillRect(x * cellWidth + (2 * cellWidth/3), y * cellHeight,  cellWidth/3 + 1, cellHeight/3 + 1);
                    g.fillRect(x * cellWidth + (2 * cellWidth/3), y * cellHeight + (2 * cellHeight/3),  cellWidth/3 + 1, cellHeight/3 + 1);
                    g.fillRect(x * cellWidth, y * cellHeight + (2 * cellHeight/3),  cellWidth/3 + 1, cellHeight/3 + 1);
                    if(curCell.getWall(0)){
                        g.fillRect(x * cellWidth + cellWidth/3, y * cellHeight,  cellWidth/3 + 1, cellHeight/3 + 1);
                    }
                    if(curCell.getWall(1)){
                        g.fillRect(x * cellWidth + (2 * cellWidth/3), y * cellHeight + cellHeight/3,  cellWidth/3 + 1, cellHeight/3 + 1);
                    }
                    if(curCell.getWall(2)){
                        g.fillRect(x * cellWidth + cellWidth/3, y * cellHeight + (2 * cellHeight/3),  cellWidth/3 + 1, cellHeight/3 + 1);
                    }
                    if(curCell.getWall(3)){
                        g.fillRect(x * cellWidth, y * cellHeight + cellHeight/3,  cellWidth/3 + 1, cellHeight/3 + 1);

                    }
                }
            }
        }
        public void run(){
            //try{Thread.sleep(1000);}catch(InterruptedException e){};
            while(true){
                if(mazeQueue.size() != 0){
                    curLayout = mazeQueue.get(0);
                    mazeQueue.remove(0);
                }
                repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
