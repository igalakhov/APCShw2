package mazeSolver;

import mazeSolver.mazeUtil.Maze;
import mazeSolver.mazeVisualizer.MazeVisualizer;

public class userOfMazeSolver {
    public static void main(String[] args){
        int testId = 0;
        switch(testId){
            case 0:
                Maze tempMaze = new Maze(50, 50);
                MazeVisualizer tempVisualizer = new MazeVisualizer(tempMaze);
                break;
            default:

                break;
        }
    }
}
