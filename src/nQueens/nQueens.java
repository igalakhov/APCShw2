package nQueens;

public class nQueens {
    public static void main(String[] args){
        nQueensSolver solver = new nQueensSolver(10);
        solver.solve();
        System.out.println("done!");
        System.out.println(solver.niceToString());
    }
}
