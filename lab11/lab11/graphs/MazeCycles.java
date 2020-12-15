package lab11.graphs;

import edu.princeton.cs.algs4.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private int[] edgeto_temp;


    /**the stack version of DFS**/

    private int s;
    private int t;
    private boolean findTheCycle = false;
    private Maze maze;

    private int popped=-1;

    private Stack<Integer> stack= new Stack();

    public MazeCycles(Maze m) {
        super(m);
        maze = m;

        edgeto_temp=new int[maze.V()];
        s = 34;
        t = maze.V()-1;
        //distTo[s] = 0;
        edgeTo[s] = s;

        stack.push(s);

    }

    public void dfs(){


        int circleSide=0;

        marked[s]=true;

        distTo[s]=s;
        announce();

        while(!stack.isEmpty()){

            int p=stack.peek();

            int adj_num=0;

            for(int i:maze.adj(p)){



                if(!marked[i]){

                    marked[i] = true;
                    edgeto_temp[i] =p;

                    stack.push(i);
                    adj_num++;

                    distTo[i]=i;

                }else if(marked[i]&&(i==edgeto_temp[p]||p==edgeto_temp[i])){/**找到cycle的位置一定不再父亲和儿子
                                                                              （虽然父类和儿子可以在cycle中）**/


                        continue;


                }else {



                    findTheCycle=true;

                    circleSide=i;


                    int temp=edgeto_temp[circleSide];

                    edgeto_temp[temp]=circleSide;

                    break;

                }

                announce();

            }


            if(findTheCycle==true){


                edgeTo[circleSide]=p;

                int member=p;

                //popped=stack.pop();

                announce();

                while(member!=circleSide) {

                    int temp=edgeto_temp[member];

                    edgeTo[member] =temp;

                    //popped = stack.pop();

                    member=temp;

                    announce();

                }

                return;

            }

            if(adj_num==0){

                popped=stack.pop();

            }


        }



    }


    @Override
    public void solve() {
        // TODO: Your code here!

        dfs();
    }

    // Helper methods go here
}

