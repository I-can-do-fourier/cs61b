package byog.lab5;


//create single hexagon

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.ArrayList;
import java.util.List;

public class Hex_test {


      private static final int WIDTH = 50;
      private static final int HEIGHT = 50;



    public static void main(String[] args) {

        TERenderer ter = new TERenderer();

        TETile[][] world=initialization_world(WIDTH,HEIGHT,ter);

        addHexagon(34,3,3,world);

        ter.renderFrame(world);

    }


   public static TETile[][] initialization_world(int WIDTH,int HEIGHT,TERenderer ter){

                //TERenderer ter = new TERenderer();
                ter.initialize(WIDTH, HEIGHT);


                TETile[][] world = new TETile[WIDTH][HEIGHT];


                blank_world(world,WIDTH,HEIGHT);

                return world;

    }

    public static void blank_world(TETile[][] world,int WIDTH,int HEIGHT){

        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }


    }


    //add a Hexagon to the digital world

    public static void addHexagon(int x_position,int y_position, int size,TETile[][] world){




        for(int[] position:Hex_creation(size)){




          try {
              world[position[0] + x_position][position[1] + y_position] = Tileset.a;

          }catch(ArrayIndexOutOfBoundsException e ){




          }


        }



    }


    //create the hexagon

    public static List<int[]> Hex_creation(int size){

           List<int[]> positions =new ArrayList<>();

           for(int i=0;i<size;i++) {

               for (int j = 0; j < size + i * 2; j++) {

                   positions.add(new int[]{(size - 1 - i + j), (size - 1 - i)});


               }

           }

           for(int i=0;i<size;i++){

                for(int j=0;j<size+i*2;j++){

                   positions.add(new int[]{(size-1-i+j),-(size-1-i)-1});


                }


           }

           return positions;


    }







}
