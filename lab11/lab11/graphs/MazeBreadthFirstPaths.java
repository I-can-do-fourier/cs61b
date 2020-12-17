package lab11.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */


    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    private Queue<Integer> fifo=new LinkedList();

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;

        fifo.add(s);
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()


        while(!fifo.isEmpty()){


            int position=fifo.poll();

            if(position==t){

                return;
            }

            marked[position]=true;

            announce();

            for(int i:maze.adj(position)){

                if(!marked[i]) {


                    marked[i] = true;
                    fifo.add(i);
                    edgeTo[i] = position;
                    distTo[i] = distTo[position] + 1;

                    announce();

                    if (position == t) {

                        return;

                    }

                }

            }


        }


    }


    @Override
    public void solve() {
        bfs();
    }
}

