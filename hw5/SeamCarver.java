
import java.lang.Math;
import edu.princeton.cs.algs4.Picture;

public class SeamCarver {


    Picture picture;

    public SeamCarver(Picture picture){

        this.picture=picture;


    }

    public Picture  picture(){


        return picture;

    }


    public int width(){


        return picture.width();

    }

    public int height(){


        return picture.height();

    }




    public double energy(int x,int y){

        //x:width y:height
        int x_l=(x-1+width())%width();
        int x_r=(x+1+width())%width();

        int y_u=(y-1+height())%height();
        int y_l=(y+1+height())%height();

        int Rx=picture.get(x_r,y).getRed()-picture.get(x_l,y).getRed();
        int Gx=picture.get(x_r,y).getGreen()-picture.get(x_l,y).getGreen();
        int Bx=picture.get(x_r,y).getBlue()-picture.get(x_l,y).getBlue();

        int Ry=picture.get(x,y_l).getRed()-picture.get(x,y_u).getRed();
        int Gy=picture.get(x,y_l).getGreen()-picture.get(x,y_u).getGreen();
        int By=picture.get(x,y_l).getBlue()-picture.get(x,y_u).getBlue();

        int e= Rx*Rx+Gx*Gx+Bx*Bx+Ry*Ry+Gy*Gy+By*By;

        return (double) e;




    }

    private int[] findVertical_helper(Picture picture){

        int[] removed_seam=new int[picture.height()];
        double[][] total_energy=new double[picture.height()][picture.width()];
        int[][] path=new int[picture.height()][picture.width()];

        for(int t=0;t<picture.width();t++){

            total_energy[0][t]=energy(t,0);

        }

        for(int i=1;i<picture.height();i++){

            for(int j=0;j<picture.width();j++){

                int parent=sam_helper2(j,i,total_energy[i-1],picture);
                total_energy[i][j]=energy(j,i)+total_energy[i-1][parent];
                path[i][j]=parent;

            }


        }

        int min=0;

        for(int t=0;t<picture.width();t++){

            if(total_energy[picture.height()-1][t]<total_energy[picture.height()-1][min]){

                min=t;

            }

        }

        removed_seam[picture.height()-1]=min;

        for(int t=picture.height()-2;t>=0;t--){

            removed_seam[t]=path[t+1][removed_seam[t+1]];

        }

        return removed_seam;


    }

    public  int[] findVerticalSeam() {

        return findVertical_helper(picture);

    }

    //help to find the pixel with the minimal energy in above three pixel
/*    private double seam_helper(int x, int y,double[] totalEnergyAbove){

      if(x==0){

          return Math.min(totalEnergyAbove[x],totalEnergyAbove[x+1]);

      }

      if(x==width()-1){

          return Math.min(totalEnergyAbove[x],totalEnergyAbove[x-1]);

      }

      return Math.min(Math.min(totalEnergyAbove[x],totalEnergyAbove[x-1]),totalEnergyAbove[x+1]);


    }*/

    private int sam_helper2(int x, int y,double[] totalEnergyAbove,Picture picture){


        if(x==0){


            return (totalEnergyAbove[x]<totalEnergyAbove[x+1]? x:x+1);

        }

        if(x==picture.width()-1){

            return (totalEnergyAbove[x]<totalEnergyAbove[x-1]? x:x-1);

        }

        int t=totalEnergyAbove[x]<totalEnergyAbove[x-1]? x:x-1;

        return totalEnergyAbove[t]<totalEnergyAbove[x+1]? t:x+1;

    }

    public  int[] findHorizontalSeam(){

        Picture p=new Picture(height(),width());

        for(int i=0;i<width();i++){

            for(int j=0;j<height();j++){

                p.set(j,i,picture.get(i,j));

            }


        }

        Picture temp=picture;
        picture=p;

        int[] to_return=findVertical_helper(picture);
        picture=temp;

        return to_return;


    }


    public void removeVerticalSeam(int[] minSeam) {

           picture=SeamRemover.removeVerticalSeam(picture,findVerticalSeam());



    }


    public void removeHorizontalSeam(int[] minSeam) {

        picture=SeamRemover.removeHorizontalSeam(picture,findHorizontalSeam());

    }
}
