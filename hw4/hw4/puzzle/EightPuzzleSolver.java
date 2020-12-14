package hw4.puzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.introcs.Stopwatch;

import java.util.Timer;

public class EightPuzzleSolver {
    /***********************************************************************
     * Test routine for your Solver class. Uncomment and run to test
     * your basic functionality.
    **********************************************************************/
    public static void main(String[] args) {

        Timer timer=new Timer();
        Stopwatch timer1 = new Stopwatch();

        long startTime = System.nanoTime();

        In in = new In(args[0]);
        int N = in.readInt();
        int[][] tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        Board initial = new Board(tiles);
        Solver solver = new Solver(initial);
        StdOut.println("Minimum number of moves = " + solver.moves());
        for (WorldState ws : solver.solution()) {
            StdOut.println(ws);
        }


        long endTime   = System.nanoTime();

        long totalTime = endTime - startTime;
        System.out.println(totalTime/1000000);

        System.out.println(timer1.elapsedTime());
    }
}
