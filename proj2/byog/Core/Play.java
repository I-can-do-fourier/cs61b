package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import edu.princeton.cs.introcs.StdDraw;

import java.io.*;

public class Play {



    private static int WIDTH;
    private static int HEIGHT;

    private static World_generation_v2 W;

    private static TERenderer ter = new TERenderer();

    private static TETile[][] finalWorldFrame;


    public Play(World_generation_v2 W,int WIDTH,int HEIGHT){



            this.W=W;
            this.WIDTH=WIDTH;
            this.HEIGHT=HEIGHT;


    }




    public static void Load_game() {

        ter.initialize(WIDTH,HEIGHT);


        try {

            FileInputStream streamIn = new FileInputStream("./data.txt");
            ObjectInputStream in = new ObjectInputStream(streamIn);
            W = (World_generation_v2) in.readObject();
            finalWorldFrame=W.return_existed_world();


        } catch (Exception e) {
            e.printStackTrace();
        }


        ter.renderFrame(finalWorldFrame);



        //StdDraw.pause(20);

    }



    public static void  create_world(TETile[][] world) {

        String seed = "";

        while (true) {

            StdDraw.clear();

            StdDraw.text(0.5, 0.7, "New Game(N)");
            StdDraw.text(0.5, 0.6, "Load Game(L)");
            StdDraw.text(0.5, 0.5, "Quit Game(Q)");


            if (StdDraw.hasNextKeyTyped()) {

                char letter = StdDraw.nextKeyTyped();

                if (letter == 's' || letter == 'S') {

                    ter.initialize(WIDTH, HEIGHT);

                    W = new World_generation_v2(Integer.valueOf(seed), WIDTH, HEIGHT);
                    finalWorldFrame = W.returnworld();

                    ter.renderFrame(finalWorldFrame);
                    break;

                }
                seed = seed + letter;

            }


            StdDraw.text(0.5, 0.4, seed);


            StdDraw.show();

            StdDraw.pause(20);

        }


    }


    public static void playing() throws IOException {


        int[] man_position=W.man_position;

        char letter='/';


        while(true) {

            if (StdDraw.hasNextKeyTyped()) {

                letter = StdDraw.nextKeyTyped();

                move(letter);

                if(letter =='q'){


                    ObjectOutputStream oos = null;
                    FileOutputStream fout = null;

                    try {
                        fout = new FileOutputStream("./data.txt");
                        oos = new ObjectOutputStream(fout);
                        oos.writeObject(W);
                    } catch (Exception ex) {
                        ex.printStackTrace();


                    } finally {
                        if (oos != null) {
                            oos.close();
                        }

                    }


                    break;

                }

            }


            ter.renderFrame(finalWorldFrame);

            //StdDraw.pause(20);

        }


    }


    public static void move(char letter) {

        int[] p=W.man_position;

        switch(letter){

            case 'w':
                if(finalWorldFrame[p[0]][p[1]+1].description().equals("floor")){

                    finalWorldFrame[p[0]][p[1]]= Tileset.FLOOR;
                    p[1]=p[1]+1;
                    finalWorldFrame[p[0]][p[1]]=Tileset.PLAYER;

                }

                return;

            case 's':
                if(finalWorldFrame[p[0]][p[1]-1].description().equals("floor")){


                    finalWorldFrame[p[0]][p[1]]=Tileset.FLOOR;

                    p[1]=p[1]-1;

                    finalWorldFrame[p[0]][p[1]]=Tileset.PLAYER;

                }

                return;

            case 'a':
                if(finalWorldFrame[p[0]-1][p[1]].description().equals("floor")){
                    finalWorldFrame[p[0]][p[1]]=Tileset.FLOOR;
                    p[0]=p[0]-1;
                    finalWorldFrame[p[0]][p[1]]=Tileset.PLAYER;

                }

                return;

            case 'd':

                if(finalWorldFrame[p[0]+1][p[1]].description().equals("floor")){
                    finalWorldFrame[p[0]][p[1]]=Tileset.FLOOR;
                    p[0]=p[0]+1;
                    finalWorldFrame[p[0]][p[1]]=Tileset.PLAYER;
                }

                return;

            default:return;


        }

    }

}
