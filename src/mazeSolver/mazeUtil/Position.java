package mazeSolver.mazeUtil;


/*
    Just a simple position class
    (for stacks and so on, since we can store two values)
    (Java has no good tuple classes)
 */
public class Position {
    private int x, y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        return ("(" + x + ", " + y + ")");
    }
}
