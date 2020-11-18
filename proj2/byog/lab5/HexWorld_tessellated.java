package byog.lab5;
import org.junit.Test;

//import static byog.lab5.Hex_test.*;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld_tessellated extends Hex_test{


    private static final int WIDTH = 150;
    private static final int HEIGHT = 150;

    private static final long SEED = 12432;
    private static final Random RANDOM = new Random(SEED);

    public static void main(String[] args) {



        TERenderer ter = new TERenderer();

        TETile[][] world=initialization_world(WIDTH,HEIGHT,ter);


        tessellated_launch(3,2,world);

        ter.renderFrame(world);


    }




  public static void tessellated_launch(int size_singlehex,int  size_bighex, TETile[][] world){


                List<int[]> positions=Hex_settings(size_singlehex,size_bighex);

                for(int[] position:positions){

                    addHexagon(position[0],position[1],size_singlehex,world);

                }

  }

  //calculate the position of each hex;

  public static List<int[]> Hex_settings(int size_singlehex, int size_bighex){

             List<int[]> positions=new ArrayList<>();


             int x_init=WIDTH/2-size_singlehex;
             int y_init=HEIGHT/2+1;

             boolean iterate_pattern=true;

            //create the head part of the bighex
             for(int i=1;i<size_bighex;i++){

                for(int j=1;j<=i;j++) {
                    positions.add(new int[]{x_init - (i - 1) * (2 * size_singlehex - 1) + (j - 1) * (4 * size_singlehex - 2), y_init + (2 * size_bighex - 2 - i + 1) * (size_singlehex)});
                }

             }


             //create the body of the bighex

              for(int i=1;i<=size_bighex;i++){


                     for(int j=1;j<=size_bighex;j++) {

                         positions.add(new int[]{x_init-(size_bighex-1)*(2*size_singlehex-1)+(j-1)*(4*size_singlehex-2), y_init + (size_bighex - 1 - 2*i + 2) * (size_singlehex)});

                     }



                  }



                for(int i=1;i<=size_bighex-1;i++) {
                    for (int j = 1; j <= size_bighex - 1; j++) {

                        positions.add(new int[]{x_init - (size_bighex - 2) * (2 * size_singlehex - 1) + (j - 1) * (4 * size_singlehex - 2), y_init + (size_bighex - 2 - 2*i + 2) * (size_singlehex)});

                    }


                }


                for(int i=1;i<size_bighex;i++){

                    for(int j=1;j<=i;j++) {
                        positions.add(new int[]{x_init - (i - 1) * (2 * size_singlehex - 1) + (j - 1) * (4 * size_singlehex - 2), y_init-(2 * size_bighex - 2 - i + 1) * (size_singlehex)});
                    }

                }



              return positions;

  }


    public static void addHexagon(int x_position,int y_position, int size,TETile[][] world){



        TETile t=randomTile();

        for(int[] position:Hex_creation(size)){

            try {

                world[position[0] + x_position][position[1] + y_position] =t;

            }catch(ArrayIndexOutOfBoundsException e ){


            }


        }



    }



  private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.TREE;
            case 3: return Tileset.SAND;
            case 4: return Tileset.UNLOCKED_DOOR;
            default: return Tileset.NOTHING;
        }
    }


}
