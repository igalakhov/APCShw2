package mazeSolver.mazeUtil;

import javafx.geometry.Pos;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    //size of maze
    private int myWidth, myHeight;

    //cells
    private Cell[][] mazeCells;

    //cell colors
    private Color[][] cellColors;

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

        cellColors = new Color[myHeight][myWidth];
        for(int i = 0; i < myHeight; i++){
            for(int j = 0; j < myWidth; j++){
                cellColors[i][j] = Color.WHITE;
            }
        }
    }
    public Color[][] copyColors(){
        Color[][] toReturn = new Color[myHeight][myWidth];
        for(int i = 0; i < myHeight; i++){
            for(int j = 0; j < myWidth; j++){
                Color cur = cellColors[i][j];
                toReturn[i][j] = new Color(cur.getRGB());
            }
        }
        return toReturn;
    }
    public void unvisitAll(){
        for(int i = 0; i < myHeight; i++){
            for(int j = 0; j < myWidth; j++){
                mazeCells[i][j].unvisit();
            }
        }
    }
    public Color getCellColor(int x, int y){
        return cellColors[y][x];
    }
    public void setCellColor(int x, int y, Color color){
        cellColors[y][x] = color;
    }
    /*
    Removes a wall from a cell to a certain direction
    also checks if everything is fine
     */
    public void removeWall(int x1, int y1, int x2, int y2){
        if(x2 - x1 == 1 && y1 == y2){
            getCell(x1, y1).removeWall(1);
            getCell(x2, y2).removeWall(3);
        }
        if(x2 - x1 == -1 && y1 == y2){
            getCell(x1, y1).removeWall(3);
            getCell(x2, y2).removeWall(1);
        }
        if(x1 == x2 && y2 - y1 == 1){
            getCell(x1, y1).removeWall(2);
            getCell(x2, y2).removeWall(0);
        }
        if(x1 == x2 && y2 - y1 == -1){
            getCell(x1, y1).removeWall(0);
            getCell(x2, y2).removeWall(2);
        }
    }
    //self obvious
    public int getWidth(){
        return myWidth;
    }
    public int getHeight(){
        return myHeight;
    }
    public void visit(int x, int y){
        getCell(x, y).visit();
    }
    /*
    Returns the positions of all nonVisited cells that have walls
     */
    public Position[] getFreeLegalNeighborPositions(int x, int y){
        List<Position> tempList = new ArrayList<>();
        Cell target = getCell(x, y);
        //top neighbor?
        if(y != 0 && !target.getWall(0) && !getCell(x, y - 1).isVisited()){
            tempList.add(new Position(x, y - 1));
        }
        //bottom neighbor
        if(y != myHeight - 1 && !target.getWall(2) && !getCell(x, y + 1).isVisited()){
            tempList.add(new Position(x, y + 1));
        }
        //right
        if(x != myWidth - 1 && !target.getWall(1) && !getCell(x + 1, y).isVisited()) {
            tempList.add(new Position(x + 1, y));
        }
        //left
        if(x != 0 && !target.getWall(3) && !getCell(x - 1, y ).isVisited()){
            tempList.add(new Position(x - 1, y));
        }

        Position[] toReturn = new Position[tempList.size()];
        for(int i = 0; i < tempList.size(); i++){
            toReturn[i] = tempList.get(i);
        }
        return toReturn;
    }
    /*
    Returns the positions of all nonVisited cells
     */
    public Position[] getFreeNeighborPositions(int x, int y){
        List<Position> tempList = new ArrayList<>();
        //top neighbor?
        if(y != 0){
            if(!getCell(x, y - 1).isVisited()){
                tempList.add(new Position(x, y-1));
            }
        }
        //bottom neighbor?
        if(y != myHeight - 1){
            if(!getCell(x, y + 1).isVisited()){
                tempList.add(new Position(x, y+1));
            }
        }
        //left neighbor
        if(x != 0){
            if(!getCell(x - 1, y).isVisited()){
                tempList.add(new Position(x - 1, y));
            }
        }
        //right neighbor
        if(x != myWidth - 1){
            if(!getCell(x + 1, y).isVisited()){
                tempList.add(new Position(x + 1, y));
            }
        }
        Position[] toReturn = new Position[tempList.size()];
        for(int i = 0; i < tempList.size(); i++){
            toReturn[i] = tempList.get(i);
        }
        return toReturn;
    }
    /*
    Returns a reference to a cell
    (assume that the cell x and y are valid)
     */
    public Cell getCell(int x, int y){
        return mazeCells[y][x];
    }

}
