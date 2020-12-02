package hw2;


import edu.princeton.cs.introcs.StdRandom;

import edu.princeton.cs.introcs.StdStats;
import jdk.jfr.Threshold;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class PercolationStats {



        private int N;

        private int T;

        private PercolationFactory pf;

        private Percolation pr;

        private int[] random_sample;

        private double Mean;

        private double Dev;

        List<Double> thresholds;

    public static void main(String[] args) {




        PercolationStats p= new PercolationStats(20,30000,new PercolationFactory());


/*
       int i=20;
       int pp=6;


       double result= ((double) i)/pp;
*/

       System.out.println(p.mean());

       System.out.println(p.stddev());

       System.out.println(p.confidenceLow());

       System.out.println(p.confidenceHigh());

    }


        public PercolationStats(int N,int T, PercolationFactory pf){


            //StdRandom.setSeed(232);

            if(N<=0||T<=0){

                throw new java.lang.IllegalArgumentException();

            }


            this.N=N;
            this.T=T;
            this.pf=pf;

            thresholds=new LinkedList<>();
            //this.pr=pf.make(N);




        }


     private double threshold(){

         pr=pf.make(N);

         random_sample=StdRandom.permutation(N*N);

         double threshold=0;

         for(int i=0;i<random_sample.length;i++){


             pr.open(random_sample[i]/N,random_sample[i]%N);


             if(pr.percolates()){

                 threshold=((double) i+1)/(N*N);

                 thresholds.add(threshold);

                 break;

             }


         }

         return threshold;
     }



     public double mean(){

        double sum=0;
        double mean;

        for(int i=0;i<T;i++){

             sum=sum+threshold();

        }

            mean=sum/T;

            Mean=mean;

        return mean;

     }

     public double stddev(){

        mean();


        double sum=0;
        double dev;


            for(double i:thresholds){

                sum=sum+(i-Mean)*(i-Mean);

            }


            dev=Math.sqrt(sum/(T-1));

            Dev=dev;

            return dev;

     }


    public double confidenceLow(){

        stddev();

         double low=Mean-1.96*Dev/Math.sqrt(T);

         return low;

     }

    public double confidenceHigh(){

         stddev();

         double high=Mean+1.96*Dev/Math.sqrt(T);

          return  high;

    }




}
