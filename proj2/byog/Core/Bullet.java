package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.LinkedList;
import java.util.List;

public class Bullet {


    private int p_x;
    private int p_y;

    private int direction;

    public static List<Bullet> bullets=new LinkedList<>();


    public Bullet(int x,int y,int d){


        p_x=x;p_y=y;

        direction=d;

        update(this);


    }

    public static void add(Bullet bullet){



            bullets.add(bullet);

    }

    public static void update(Bullet b){

        switch (b.direction){

            case 1:
                b.p_y=b.p_y-1;
                return;
            case 2:
                b.p_x=b.p_x+1;
                return;
            case 3:
                b.p_x=b.p_x-1;
                return;
            case 4:
                b.p_y=b.p_y+1;
                return;


        }


    }

    public static void bullet_show(TETile[][] t){

        List<Bullet> temp=new LinkedList<>();
        //List<Integer> remove=new LinkedList<>();

        for(Bullet b:bullets){



            t[b.p_x()][b.p_y()]= Tileset.FLOOR;

            update(b);

            if(t[b.p_x()][b.p_y()].description().equals("a")){

                        //bullets.remove(b);

            }else{t[b.p_x()][b.p_y()]= Tileset.BULLET;

                    temp.add(b);
            }

            bullets=temp;


        }


    }


    public int p_x(){

        return p_x;


    }

    public int p_y(){


        return p_y;

    }



}
