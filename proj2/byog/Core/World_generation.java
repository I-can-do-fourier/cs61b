package byog.Core;


import java.util.ArrayList;
import java.util.Random;

import byog.SaveDemo.World;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import edu.princeton.cs.algs4.In;

import java.util.List;

public class World_generation {

    private int seed;

    private  Random random_route;

    private TETile[][] world;

    private int WIDTH;

    private int HEIGHT;

    private int bound_x1;
    private int bound_x2;
    private int bound_y1;
    private int bound_y2;

    private List<int[][]> block =new ArrayList<>();


    public World_generation(int seed,int width,int height){




            WIDTH=width;
            HEIGHT=height;

            bound_x1=5;
            bound_x2=WIDTH-5;
            bound_y1=5;
            bound_y2=HEIGHT-5;

            this.seed=seed;

            random_route= new Random(seed);

            world= new TETile[width][height];

            blank_world(world,WIDTH,HEIGHT);



    }


    public TETile[][] returnworld(){

            world_segment();



            return world;

    }




   public  List<int[]> positions_generation(){



                return null;

   }


    public int random_dxdy() {
        int tileNum =random_route.nextInt(4);
        switch (tileNum) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            default:
        }

        return 0;
    }


    public List<Tileset[][]> world_segment(){


                    block_bound();

                /*for(int x=bound_x1;x<bound_x2;x++){



                    for(int y=bound_y1;y<bound_y2;y++){



                                world[x][y]=Tileset.a;



                    }



                }*/

           /*     for(int[][] p:block){


                    for(int[] pp:p){

                        world[pp[0]][pp[1]]=Tileset.a;


                    }


                }
*/

            /*for(int[] p:hollow_rec(new int[]{40,40},20,40)){


                world[p[0]][p[1]]=Tileset.b;

            }*/


             return null;


    }


    public void block_bound(){

         //int x_prev=0;
         //int y_prev=0;

         int x_bound1=bound_x1;
         int y_bound1=bound_y1;

         int x_bound2=bound_x1;
         int y_bound2=bound_y1;

         int x_bound3=bound_x1;
         int y_bound3=bound_y1+5+random_route.nextInt((HEIGHT-10)/6);

         int x_bound4=bound_x1;
         int y_bound4=y_bound3;



         int random;


         while(true){


             //bound update;
            x_bound1=x_bound2;
            x_bound4=x_bound2;
            //y_bound1=y_bound2;

            x_bound2=x_bound2+5+random_route.nextInt((WIDTH-10)/8);
            //y_bound2=y_bound2;

            x_bound3=x_bound2;

            block.add(new int[][]{{x_bound1,y_bound1},{x_bound2,y_bound2},{x_bound3,y_bound3},{x_bound4,y_bound4}});

            //for rec

             int x_p=x_bound1+random_route.nextInt(x_bound2-x_bound1-1);
             int y_p=y_bound1+random_route.nextInt(y_bound3-y_bound1-1);

             int rec_width=3+random_route.nextInt(x_bound2-x_p-1);
             int rec_height=3+random_route.nextInt(y_bound3-y_p-1);

             //hollow_rec(random_route(x_bound2),int width, int height)

             for(int[] p:hollow_rec(new int[]{x_p,y_p},rec_width,rec_height)){


                 world[p[0]][p[1]]=Tileset.b;

             }

             if(bound_y2-y_bound3<=((HEIGHT-10)/5)&&bound_x2-x_bound2<=(5+(WIDTH-10)/5))
             {

                 break;

             }

            if(bound_x2-x_bound2<=(5+(WIDTH-10)/5)){

                x_bound1=bound_x1;
                x_bound2=bound_x1;
                x_bound3=bound_x1;
                x_bound4=bound_x1;

                y_bound1=y_bound3;
                y_bound2=y_bound3;

                y_bound3=y_bound3+3+random_route.nextInt((HEIGHT-10)/5);
                y_bound4=y_bound3;



            }





         }


         //int[][] single_block=new int[4][2];




    }



    public void points_in_blocks(){




    }


    public List<int[][]> link_points(){



            return null;


    }


    /*public void rec_inblock(){

            for()


    }
*/
    public List<int[]> hollow_rec(int[] position,int width, int height){

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






    public static void blank_world(TETile[][] world,int WIDTH,int HEIGHT){

        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }


    }





}



class test{


    public static void main(String[] args) {



    }


}