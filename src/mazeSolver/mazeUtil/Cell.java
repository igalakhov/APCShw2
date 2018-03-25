package mazeSolver.mazeUtil;

// imports
import java.util.Arrays;

/*
    One cell of the maze, a maze contains all these cells inside
 */
public class Cell {
    //x and y positions of the cell
    private int x, y;
    //walls (top, right, bottom, left)
    private boolean[] walls;
    //was the cell visited ? can be used for both A* and maze generation
    private boolean visited;

    /*
    Create a new cell (based on x and y position)
    The cell has walls everywhere by default
     */
    public Cell(int x, int y){
        //copy x and y
        this.x = x;
        this.y = y;

        //populate walls with true
        walls = new boolean[4];
        Arrays.fill(walls, true);

        //this cell hasn't been visited
        visited = false;

    }
    // returns the x position of the cell
    public int getX(){
        return x;
    }
    //returns the y position of the cell
    public int getY(){
        return y;
    }
    /*
    Sets the wall of the cell to whatever val...
    Index is based on the walls boolean[]
    0 <= index <= 3
    */
    public void removeWall(int index){
        walls[index] = false;
    }
    /*
    returns wall value
    Index is based on the walls boolean[]
    0 <= index <= 3
    */
    public boolean getWall(int index){
        return walls[index];
    }
    //visit the cell
    public void visit(){
        visited = true;
    }
    public boolean isVisited(){
        return visited;
    }
    public void unvisit(){
        visited = false;
    }
}
