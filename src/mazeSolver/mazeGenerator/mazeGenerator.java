package mazeSolver.mazeGenerator;

import mazeSolver.mazeUtil.*;

import java.util.Random;
import java.util.Stack;

public class mazeGenerator {
    public static Maze GenerateMaze(int mazeWidth, int mazeHeight){
        Maze toReturn = new Maze(mazeWidth, mazeHeight);
        Stack<Position> positionStack = new Stack<>();
        //push the first cell to the stack
        toReturn.visit(0, 0);
        positionStack.push(new Position(0, 0));
        while(!positionStack.empty()){
            Position curCell = positionStack.peek();

            //get all neighbors from the current cell
            Position[] avaliableMoves = toReturn.getFreeNeighborPositions(curCell.getX(), curCell.getY());
            if(avaliableMoves.length == 0){
                //we can't move anywhere
                positionStack.pop();
            } else {
                Position randomMove = avaliableMoves[new Random().nextInt(avaliableMoves.length)];
                toReturn.visit(randomMove.getX(), randomMove.getY());
                toReturn.removeWall(curCell.getX(), curCell.getY(), randomMove.getX(), randomMove.getY());
                positionStack.push(randomMove);
            }
        }
        //reset the maze so its clean to return
        toReturn.unvisitAll();

        return toReturn;
    }
}
