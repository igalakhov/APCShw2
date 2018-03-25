package mazeSolver.mazeSolver;

import mazeSolver.mazeUtil.Maze;
import mazeSolver.mazeUtil.Position;
import mazeSolver.mazeVisualizer.MazeVisualizer;

import java.awt.*;
import java.util.Random;
import java.util.Stack;

public class MazeSolver {
    //assume maze is already in visualizer
    public static Position[] solveMaze(Maze toSolve, Position start, Position end, MazeVisualizer visualizer){
        //color start and end
        toSolve.setCellColor(start.getX(), start.getY(), Color.GREEN);
        toSolve.setCellColor(end.getX(), end.getY(), Color.YELLOW);
        visualizer.saveSnippet();
        Stack<Position> tempStack = new Stack<>();
        toSolve.visit(start.getX(), start.getY());
        tempStack.push(start);
        while(tempStack.peek().getX() != end.getX() || tempStack.peek().getY() != end.getY()){
            Position cur = tempStack.peek();
            Position[] avaliable = toSolve.getFreeLegalNeighborPositions(cur.getX(), cur.getY());
            if(avaliable.length == 0){
                tempStack.pop();
                toSolve.setCellColor(cur.getY(), cur.getX(), Color.red);
            } else {
                Position randomMove = avaliable[new Random().nextInt(avaliable.length)];
                toSolve.visit(randomMove.getX(), randomMove.getY());
                toSolve.setCellColor(randomMove.getY(), randomMove.getX(), Color.blue);
                tempStack.push(randomMove);
            }
            visualizer.saveSnippet();

        }

        System.out.println("hi");


        return null;
    }
}
