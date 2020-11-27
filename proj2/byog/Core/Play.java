package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
import java.io.*;

public class Play {



    private static int j=0;

    private static int WIDTH;
    private static int HEIGHT;

    private static World_generation_v2 W;

    private static TERenderer ter = new TERenderer();

    private static TETile[][] finalWorldFrame;

    public static int[] p;  //man_position


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

            StdDraw.pause(200);

        }


    }


    public static void playing() throws IOException {

        p=W.man_position;

        char letter='/';

        int direction=4;

        int i=0;


        while(true) {

            if(i>=1000){

                    i=0;

            }


            if(i%4==0){
                Bullet.bullet_show(finalWorldFrame);
            }

            if(i%3==0){


                    direction=move(direction);

                }


            if (StdDraw.hasNextKeyTyped()) {

                letter = StdDraw.nextKeyTyped();




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

                }else if(letter =='j'){

                    Bullet bu=new Bullet(p[0],p[1],direction);

                    if(!finalWorldFrame[bu.p_x()][bu.p_y()].description().equals("a")){

                        Bullet.add(bu);

                        finalWorldFrame[bu.p_x()][bu.p_y()]=Tileset.BULLET;

                    }

                  /*  if(StdDraw.isKeyPressed(KeyEvent.VK_W)){

                        if(direction!=4){

                            Bullet bu=new Bullet(p[0],p[1],4);

                            if(!finalWorldFrame[bu.p_x()][bu.p_y()].description().equals("a")){

                                Bullet.add(bu);

                                finalWorldFrame[bu.p_x()][bu.p_y()]=Tileset.BULLET;}
                       }


                    }else if(StdDraw.isKeyPressed(KeyEvent.VK_S)){


                        if(direction!=1){

                            Bullet bu=new Bullet(p[0],p[1],1);

                            if(!finalWorldFrame[bu.p_x()][bu.p_y()].description().equals("a")){

                                Bullet.add(bu);

                                finalWorldFrame[bu.p_x()][bu.p_y()]=Tileset.BULLET;}
                        }

                    }else if(StdDraw.isKeyPressed(KeyEvent.VK_A)){


                        if(direction!=3){

                            Bullet bu=new Bullet(p[0],p[1],3);

                            if(!finalWorldFrame[bu.p_x()][bu.p_y()].description().equals("a")){

                                Bullet.add(bu);

                                finalWorldFrame[bu.p_x()][bu.p_y()]=Tileset.BULLET;}
                        }

                    }else if(StdDraw.isKeyPressed(KeyEvent.VK_D)){


                        if(direction!=2){

                            Bullet bu=new Bullet(p[0],p[1],2);

                            if(!finalWorldFrame[bu.p_x()][bu.p_y()].description().equals("a")){

                                Bullet.add(bu);

                                finalWorldFrame[bu.p_x()][bu.p_y()]=Tileset.BULLET;}
                        }else{

                            Bullet bu=new Bullet(p[0],p[1],direction);

                            if(!finalWorldFrame[bu.p_x()][bu.p_y()].description().equals("a")){

                                Bullet.add(bu);

                                finalWorldFrame[bu.p_x()][bu.p_y()]=Tileset.BULLET;}


                        }

                    }*/



                }



            }



            ter.renderFrame(finalWorldFrame);

            i++;

            StdDraw.pause(5);

        }


    }


    public static int move(int direction) {




        if(StdDraw.isKeyPressed(KeyEvent.VK_W)&&finalWorldFrame[p[0]][p[1]+1].description().equals("floor")){

            j++;

            if(j>=3) {

                finalWorldFrame[p[0]][p[1]] = Tileset.FLOOR;
                p[1] = p[1] + 1;
                finalWorldFrame[p[0]][p[1]] = Tileset.PLAYER;



            }

            return 4;

        }else if(StdDraw.isKeyPressed(KeyEvent.VK_S)&&finalWorldFrame[p[0]][p[1]-1].description().equals("floor")){

            j++;

            if(j>=3) {
                finalWorldFrame[p[0]][p[1]] = Tileset.FLOOR;

                p[1] = p[1] - 1;

                finalWorldFrame[p[0]][p[1]] = Tileset.PLAYER;

            }
                return 1;


        }else if(StdDraw.isKeyPressed(KeyEvent.VK_A)&&finalWorldFrame[p[0]-1][p[1]].description().equals("floor")){

            j++;

            if(j>=3){

                finalWorldFrame[p[0]][p[1]]=Tileset.FLOOR;
                p[0]=p[0]-1;
                finalWorldFrame[p[0]][p[1]]=Tileset.PLAYER;

            }



            return 3;

        }else if(StdDraw.isKeyPressed(KeyEvent.VK_D)&&finalWorldFrame[p[0]+1][p[1]].description().equals("floor")){

            j++;

            if(j>=3){

                finalWorldFrame[p[0]][p[1]]=Tileset.FLOOR;
                p[0]=p[0]+1;
                finalWorldFrame[p[0]][p[1]]=Tileset.PLAYER;

            }


            return 2;
        }

        j=0;

        return direction;
    }

}
