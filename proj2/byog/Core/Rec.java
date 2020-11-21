package byog.Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.spi.AbstractResourceBundleProvider;

public class Rec {


    private int[] position;
    private int width;
    private int height;

    private Random random;

    private int j1_x;
    private int j1_y;

    private int j2_x;
    private int j2_y;

    private int j3_x;
    private int j3_y;

    private int j4_x;
    private int j4_y;


    private int[] j1;
    private int[] j2;
    private int[] j3;
    private int[] j4;

    private int blocked_side=0;

    private List<int[]> juncs=new ArrayList<>();


    public Rec(Random random){


            this.random=random;

            int p_x=15+random.nextInt(10);
            int p_y=5+random.nextInt(10);

            this.position=new int[]{p_x,p_y};

            this.width=4+random.nextInt(10);

            this.height=4+random.nextInt(10);;



            j1_x=position[0]+1+random.nextInt(width-2);
            j1_y=position[1];
            j2_x=position[0]+width-1;
            j2_y=position[1]+1+random.nextInt(height-2);
            j3_x=position[0];
            j3_y=position[1]+1+random.nextInt(height-2);
            j4_x=position[0]+1+random.nextInt(width-2);
            j4_y=position[1]+height-1;

        j1=new int[]{j1_x,j1_y,1,position[0],position[0]+width-1};
        j2=new int[]{j2_x,j2_y,2,position[1],position[1]+height-1};
        j3=new int[]{j3_x,j3_y,3,position[1],position[1]+height-1};
        j4=new int[]{j4_x,j4_y,4,position[0],position[0]+width-1};



    }




    public Rec(int[] position,int width,int height,int bloked_side,Random random){


        this.random=random;

        this.width=width;

        this.height=height;

        this.blocked_side=bloked_side;

        this.position=position;

        j1_x=position[0]+1+random.nextInt(width-2);
        j1_y=position[1];
        j2_x=position[0]+width-1;
        j2_y=position[1]+1+random.nextInt(height-2);
        j3_x=position[0];
        j3_y=position[1]+1+random.nextInt(height-2);
        j4_x=position[0]+1+random.nextInt(width-2);
        j4_y=position[1]+height-1;

        j1=new int[]{j1_x,j1_y,1,position[0],position[0]+width-1};
        j2=new int[]{j2_x,j2_y,2,position[1],position[1]+height-1};
        j3=new int[]{j3_x,j3_y,3,position[1],position[1]+height-1};
        j4=new int[]{j4_x,j4_y,4,position[0],position[0]+width-1};



    }


    public List<int[]> hollow_rec(){

        List<int[]> rec=new ArrayList<>();

        for(int i=position[0];i<position[0]+width;i++){

            int[] temp=new int[2];
            temp[0]=i;temp[1]=position[1];
            rec.add(temp);

        }


        for(int i=position[1]+1;i<position[1]+height;i++){

            int[] temp=new int[2];
            temp[0]=position[0]+width-1; temp[1]=i;
            rec.add(temp);

        }

        for(int i=position[1]+1;i<position[1]+height;i++){

            int[] temp=new int[2];
            temp[0]=position[0]; temp[1]=i;
            rec.add(temp);

        }


        for(int i=position[0]+1;i<position[0]+width-1;i++){

            int[] temp=new int[2];
            temp[0]=i;temp[1]=position[1]+height-1;
            rec.add(temp);

        }

        return rec;


    }

    public void set_junctions(){


            switch (blocked_side){

                case 1:

                    juncs.add(j1);
                    juncs.add(j2);
                    juncs.add(j3);
                    //juncs.add(j4);
                    break;


                case 2:
                    juncs.add(j1);
                    juncs.add(j2);
                    //juncs.add(j3);
                    juncs.add(j4);
                    break;


                case 3:

                    juncs.add(j1);
                    //juncs.add(j2);
                    juncs.add(j3);
                    juncs.add(j4);

                    break;


                case 4:
                    //juncs.add(j1);
                    juncs.add(j2);
                    juncs.add(j3);
                    juncs.add(j4);

                    break;


                case 0:

                    juncs.add(j1);
                    juncs.add(j2);
                    juncs.add(j3);
                    juncs.add(j4);

                    break;



            }




    }


    public int[] parameters(){

            int[] pa=new int[4];
            pa[0]=position[0];
            pa[1]=position[1];
            pa[2]=width;
            pa[3]=height;

          return pa;

    }

    public List<int[]> junctions(){

    /*    int[][] junc=new int[4][2];

        junc[0][0]=j1_x;junc[0][1]=j1_y;
        junc[1][0]=j2_x;junc[1][1]=j2_y;
        junc[2][0]=j3_x;junc[2][1]=j3_y;
        junc[3][0]=j4_x;junc[3][1]=j4_y;


*/

        //List<int[]> juncs=new ArrayList<>();

        set_junctions();

        return juncs;
    }





}
