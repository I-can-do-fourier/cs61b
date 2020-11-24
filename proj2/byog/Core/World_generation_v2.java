package byog.Core;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.List;

public class World_generation_v2 implements Serializable {
    private static final long serialVersionUID = 1661691259286224996L;

    //private static final long serialVersionUID = 1L;

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

    private List<int[]> junctions=new ArrayList<int[]>();

    private List<int[]> Floors=new ArrayList<>();

    public  int[] man_position;

    public World_generation_v2(int seed,int width,int height){




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


    public void set_world(TETile[][] world){

            this.world=world;


    }

    public TETile[][] return_existed_world(){


            return world;
    }


    public TETile[][] returnworld() {

        List<int[]> temp=add_rect();
        List<int[]> hole_forsingle=new ArrayList<>();

        junctions.addAll(temp);



        int j=0;

       while(junctions.size()>0) {


           temp=new ArrayList<>();

            j++;

           for (int[] junction : junctions) {

               hole_forsingle=new ArrayList<>();

               world[junction[0]][junction[1]] = Tileset.NOTHING;


               int width;
               int height;
               int x_p;
               int y_p;

               width = 3 + random_route.nextInt(7);
               height = 3 + random_route.nextInt(7);

               switch (junction[2]) {



                   case 1:

                       x_p = junction[0] - 1 - random_route.nextInt((width - 2));
                       y_p = junction[1] - (height - 1);

                       hole_forsingle=add_rect(new int[]{x_p, y_p}, width, height, junction[2],junction);

                        if (hole_forsingle!=null){
                            temp.addAll(hole_forsingle);

                        }

                     break;


                   case 2:

                       x_p = junction[0];
                       y_p = junction[1] - 1 - random_route.nextInt(height - 2);

                       hole_forsingle=add_rect(new int[]{x_p, y_p}, width, height, junction[2],junction);

                       if (hole_forsingle!=null){
                           temp.addAll(hole_forsingle);

                       }

                       break;

                   case 3:


                       x_p = junction[0] - (width - 1);
                       y_p = junction[1] - 1 - random_route.nextInt(height - 2);

                       hole_forsingle=add_rect(new int[]{x_p, y_p}, width, height, junction[2],junction);

                       if (hole_forsingle!=null){
                           temp.addAll(hole_forsingle);

                       }
                       break;


                   case 4:

                       x_p = junction[0] - 1 - random_route.nextInt((width - 2));
                       y_p = junction[1];

                       hole_forsingle=add_rect(new int[]{x_p, y_p}, width, height, junction[2],junction);

                       if (hole_forsingle!=null){
                           temp.addAll(hole_forsingle);

                       }

                       break;

               }



            if(hole_forsingle!=null) {

                world[junction[0]][junction[1]] = Tileset.FLOOR;
                Floors.add(new int[]{junction[0],junction[1]});


            }

           }
           junctions.removeAll(junctions);

           junctions.addAll(temp);



       }

       man_position =Floors.get(random_route.nextInt(Floors.size()));



       world[man_position[0]][man_position[1]]=Tileset.PLAYER;

        return world;

    }


    public boolean impede_test(int[] p){

        if(p[0]>=bound_x2-1||p[0]<=bound_x1+1||p[1]>=bound_y2-1||p[1]<=bound_y1+1){return true;}


        if(     world[p[0]+1][p[1]].equals(Tileset.a)||
                world[p[0]-1][p[1]].equals(Tileset.a)||
                world[p[0]][p[1]+1].equals(Tileset.a)||
                world[p[0]][p[1]-1].equals(Tileset.a)){   return true;  }




        return false;

    }




    public List<int[]> add_rect(int[] positions,int width,int height,int blocked_side,int[] block_position){

        boolean isdiscard=false;

        List<int[]> tiles=new ArrayList<>();


        /*int p_x=15+random_route.nextInt(WIDTH-30);

        int p_y=15+random_route.nextInt(HEIGHT-30);

        int width=4+random_route.nextInt(10);

        int height=4+random_route.nextInt(10);
*/
        Rec re= new Rec(positions,width,height,blocked_side,random_route);

        int[] parameters=re.parameters();

        List<int[]> junc=re.junctions();

        tiles=re.hollow_rec();

        for(int[] p:tiles){

          if (blocked_side==1||blocked_side==4) {

              if ((p[1]!=block_position[1]&&p[1]!=block_position[1]+1&&p[1]!=block_position[1]-1&&impede_test(p))||
                  (p[1]==block_position[1]&&(p[0]-block_position[4]>=2||-p[0]+block_position[3]>=2)&&impede_test(p))) {

                  tiles = new ArrayList<>();
                  tiles.add(block_position);
                  junc = null;

                  isdiscard=true;
                  break;

              }



          }else {

              if ((p[0]!=block_position[0]&&p[0]!=block_position[0]+1&&p[0]!=block_position[1]-1&&impede_test(p))||
                  (p[0]==block_position[0]&&(p[1]-block_position[4]>=2||-p[1]+block_position[3]>=2)&&impede_test(p))) {

                  tiles = new ArrayList<>();
                  tiles.add(block_position);
                  junc = null;

                  isdiscard=true;

                  break;

              }


          }


        }



        for(int[] p:tiles){


            world[p[0]][p[1]]=Tileset.a;


        }



        if(!isdiscard) {
            for (int i = parameters[0] + 1; i < parameters[0] + parameters[2] - 1; i++) {


                for (int j = parameters[1] + 1; j < parameters[1] + parameters[3] - 1; j++) {


                    world[i][j] = Tileset.FLOOR;
                    Floors.add(new int[]{i,j});


                }


            }

        }


        return junc;


    }


    public List<int[]> add_rect(){


        Rec re= new Rec(random_route);

        int[] parameters=re.parameters();
        for(int[] p:re.hollow_rec()){


            world[p[0]][p[1]]=Tileset.a;


        }

        for(int i=parameters[0]+1;i<parameters[0]+parameters[2]-1;i++){


            for(int j=parameters[1]+1;j<parameters[1]+parameters[3]-1;j++){


                world[i][j]=Tileset.FLOOR;

                Floors.add(new int[]{i,j});
            }


        }

        List<int[]> temp=re.junctions();

        return temp;


    }



    public static void blank_world(TETile[][] world,int WIDTH,int HEIGHT){

        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }


    }



}



class test2{

    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 40;


    public static void main(String[] args) {




        World_generation_v2 W= new World_generation_v2(876,WIDTH,HEIGHT);

        TETile[][] finalWorldFrame = W.returnworld();

    }


}