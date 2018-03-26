package mazeSolver;

import mazeSolver.mazeGenerator.mazeGenerator;
import mazeSolver.mazeSolver.MazeSolver;
import mazeSolver.mazeUtil.Maze;
import mazeSolver.mazeUtil.Position;
import mazeSolver.mazeVisualizer.MazeVisualizer;

import java.awt.*;
import java.util.Arrays;

public class userOfMazeSolver {
    public static void main(String[] args){
        int testId = 0;
        switch(testId){
            case 0:
                int size = 1;
                Maze tempMaze = mazeGenerator.GenerateMaze(size, size);
                MazeVisualizer tempVisualizer = new MazeVisualizer(tempMaze);
                MazeSolver.solveMaze(tempMaze, new Position(0, 0), new Position(size - 1, size - 1), tempVisualizer);
                break;
            default:

                break;
        }
    }
}
