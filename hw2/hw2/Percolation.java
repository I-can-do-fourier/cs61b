package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Percolation {


    private WeightedQuickUnionUF pr;

    private  int size;

    private int [] status_open;

    private int opensite_number=0;

    private int[] status_full;

    private int[] status_bottom;


    private boolean percolation=false;

    private List<int[]> full_pool=new ArrayList<>();     //each item is an object which is used to be pointed at, all the sites in the same
                                                         // component needs to point at the same object in full_poll
                                                         // in oder to get the isfull status

    private List<int[]> bottom_pool=new ArrayList<>();

    public Percolation(int N) {


        if(N<=0){

            throw new java.lang.IllegalArgumentException();

        }
        size=N;

        pr = new WeightedQuickUnionUF(N*N);

        status_full=new int[N*N];

        status_open=new int[N*N];

        status_bottom=new int[N*N];


    }

    private int to_num(int row, int col){

        return row*size+col;

    }


    public void open(int row, int col) {     // open the site (row, col) if it is not open already

            boolean isolation= true;


            if(isOpen(row,col)){


                return;
            }

            int number= to_num(row,col);


            status_open[number]=1;

            opensite_number++;

            int parent_prev=pr.find(number);



            if(col!=size-1&&isOpen(row, col+1)){

                isolation=false;

                int temp=pr.find(number+1);

                pr.union(number,number+1);

                status_full[pr.find(number)]=status_full[temp]|status_full[parent_prev];
                status_bottom[pr.find(number)]=status_bottom[temp]|status_bottom[parent_prev];



            }

            if(col!=0&&isOpen(row, col-1)){

                isolation=false;


                parent_prev=pr.find(number);
                int temp=pr.find(number-1);
                pr.union(number,number-1);
                status_full[pr.find(number)]=status_full[temp]|status_full[parent_prev];
                status_bottom[pr.find(number)]=status_bottom[temp]|status_bottom[parent_prev];
            }

            if(row!=size-1&&isOpen(row+1, col)){

                isolation=false;

                parent_prev=pr.find(number);

                int temp=pr.find(number+size);
                pr.union(number,number+ size);
                status_full[pr.find(number)]=status_full[temp]|status_full[parent_prev];
                status_bottom[pr.find(number)]=status_bottom[temp]|status_bottom[parent_prev];
            }

            if(row!=0&&isOpen(row-1, col)){

                isolation=false;

                parent_prev=pr.find(number);

                int temp=pr.find(number-size);
                pr.union(number,number- size);
                status_full[pr.find(number)]=status_full[temp]|status_full[parent_prev];
                status_bottom[pr.find(number)]=status_bottom[temp]|status_bottom[parent_prev];
            }

        /*    if(isolation==true){

                full_pool.add(new int[]{0});

                status_full[number]=full_pool.get(full_pool.size()-1);


            }
*/


            if(row==0){

                status_full[pr.find(number)]=1;

            }

            if(row==size-1){

               status_bottom[pr.find(number)]=1;

           }

            if(status_full[pr.find(number)]==1&&status_bottom[pr.find(number)]==1){

                percolation=true;

            }



    }


    public boolean isOpen(int row, int col) {


        if(status_open[to_num(row,col)]==1){

            return true;
        }


        return false;

    }

    public boolean isFull(int row, int col) {

       if(status_full[pr.find(to_num(row, col))]==1){



           return  true;
       }

            return false;

    }

    public int numberOfOpenSites() {

        return opensite_number;

    }

    public boolean percolates() {


            return percolation;



    }




}
