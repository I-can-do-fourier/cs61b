package hw2;


import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.Stopwatch;
import org.junit.Test;

public class Time_test {






    public static void main(String[] args) {


        int n = 200;

        int total = 10000000;


        Stopwatch time=new Stopwatch();

        for (int s=0;s<total/(n*n);s++) {

            int[] random_sample = StdRandom.permutation(n * n);

        }

        double t = time.elapsedTime();

        System.out.printf("%.20f\n", t);
    }




    @Test

    public void test_open() {

        int n =100 ;

        int total = 100000000;



        Stopwatch timer = new Stopwatch();


        for (int s=0;s<total/(n*n);s++) {



            int[] random_sample= StdRandom.permutation(n*n);

            Percolation p = new Percolation(n);

            for (int i = 0; i < n * n/5; i++) {

                p.open(random_sample[i]/n,random_sample[i]%n);

            }



        }

        double t = timer.elapsedTime();

        System.out.printf("%.20f\n", t);

    }


    @Test

    public void test_isfull(){


        int n = 2000;

        int total = 100000000;




        Stopwatch timer=new Stopwatch();

        for (int s=0;s<total/(n*n);s++) {

            int[] random_sample= StdRandom.permutation(n*n);

            Percolation p = new Percolation(n);

            for (int i = 0; i < n * n/2; i++) {

                p.open(random_sample[i]/n,random_sample[i]%n);

            }


            for (int i = 0; i < n * n; i++) {

                p.isFull(i / n, i % n);

            }


        }


        double t = timer.elapsedTime();

        System.out.printf("%.20f\n", t);



    }

}
