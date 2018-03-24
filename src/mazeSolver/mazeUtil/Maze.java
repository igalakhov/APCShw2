package mazeSolver.mazeUtil;

public class Maze {
    //size of maze
    private int myWidth, myHeight;

    //cells
    private Cell[][] mazeCells;

    /*
    Creates a new maze of a certain size
     */
    public Maze(int myWidth, int myHeight){
        //copy params
        this.myWidth = myWidth;
        this.myHeight = myHeight;

        //create the cells
        mazeCells = new Cell[myHeight][myWidth];
        for(int i = 0; i < myHeight; i++){
            for(int j = 0; j < myWidth; j++){
                mazeCells[i][j] = new Cell(j, i);
            }
        }
    }
    //self obvious
    public int getWidth(){
        return myWidth;
    }
    public int getHeight(){
        return myHeight;
    }
    /*
    Returns a reference to a cell
    (assume that the cell x and y are valid)
     */
    public Cell getCell(int x, int y){
        return mazeCells[y][x];
    }

}
