package hw4.puzzle;

import edu.princeton.cs.algs4.Queue;

import java.util.LinkedList;
import java.util.List;

public class Board implements WorldState {

    /**
     * Returns the string representation of the board.
     * Uncomment this method.
     */


    private final int[][] start;

    private final int[][] goal;

    private int size;



    public Board(int[][] tiles) {



        start = new int[tiles.length][tiles.length];

        for(int i=0; i<tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++)
                start[i][j] = tiles[i][j];

        }



            goal=new int[start.length][start.length];

            size=tiles.length;

            int t=1;

        for(int i=0;i<goal.length;i++){

            for (int j=0;j<goal.length;j++){


                    goal[i][j]=t;
                    t++;

            }

        }

        goal[goal.length-1][goal.length-1]=0;


    }

    public int tileAt(int i, int j) {


            return start[i][j];
    }


    public int size() {


        return size;

    }


    @Override
    public int estimatedDistanceToGoal() {


        return manhattan();



    }

    @Override
    public Iterable<WorldState> neighbors() {

        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == 0) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = 0;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = 0;

                }


            }
        }
        return neighbors;


    }


    public int hamming(){


        int distance=0;

        for(int i=0;i<goal.length;i++){

            for (int j=0;j<goal.length;j++){


                if(goal[i][j]!=0&&goal[i][j]!=start[i][j]){

                    distance++;

                }


            }

        }


        return distance;
    }


    public int manhattan(){


        int distance=0;

        int xt;
        int yt;
        int dx;
        int dy;

        int length=start.length;


        for(int i=0;i<length;i++){

            for (int j=0;j<length;j++){

                 if(start[i][j]!=0){


                     xt=(start[i][j]-1)/length;
                     yt=(start[i][j]-1)%length;

                     dx=Math.abs(xt-i);
                     dy=Math.abs(yt-j);

                     distance=distance+dx+dy;

                 }



            }

        }


        return distance;


    }


    @Override

    public int hashCode(){


        int code=0;

        for(int i=0;i<start.length;i++){

            code=code+(int) Math.pow(start[0][i],i);


        }

        for(int i=0;i<start.length;i++){

            code=code+10*((int) Math.pow(start[1][i],i));


        }

        for(int i=0;i<start.length;i++){

            code=code+100*((int) Math.pow(start[2][i],i));


        }

        return code;

    }

    public boolean equals(Object o){

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Board b = (Board) o;

        if(this.start==null||b.start==null){

                return false;

        }


        if(this.start.length!=b.start.length){

                return false;

        }



         for(int i=0;i<start.length;i++){

             for (int j=0;j<start.length;j++){

                   if(start[i][j]!=b.start[i][j]){

                            return false;


                    }

                }

            }


         return true;


    }




    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i, j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }



}
