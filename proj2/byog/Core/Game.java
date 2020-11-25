package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import edu.princeton.cs.introcs.StdDraw;

import java.io.*;

import static byog.Core.Play.*;


public class Game {
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 40;

    //ter.initialize(WIDTH, HEIGHT);
    private TETile[][] finalWorldFrame = new TETile[WIDTH][HEIGHT];
    private World_generation_v2 W;

    private Play play=new Play(W,WIDTH,HEIGHT);




    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public void playWithKeyboard() throws IOException {


        String seed = "";


        StdDraw.setCanvasSize(512, 512);
        StdDraw.text(0.5, 0.7, "New Game(N)");
        StdDraw.text(0.5, 0.6, "Load Game(L)");
        StdDraw.text(0.5, 0.5, "Quit Game(Q)");

        StdDraw.enableDoubleBuffering();

        while (true) {

            StdDraw.clear();

            StdDraw.text(0.5, 0.7, "New Game(N)");
            StdDraw.text(0.5, 0.6, "Load Game(L)");
            StdDraw.text(0.5, 0.5, "Quit Game(Q)");


            if (StdDraw.hasNextKeyTyped()) {
                char letter = StdDraw.nextKeyTyped();
                if (letter == 'N' || letter == 'n') {

                    create_world(finalWorldFrame);
                    break;

                } else if (letter == 'L' || letter == 'l') {


                   Load_game();

                   break;

                } else if (letter == 'q' || letter == 'Q') {


                }

            }
            StdDraw.text(0.5, 0.4, seed);

            StdDraw.pause(20);

            StdDraw.show();

        }


        playing();

    }


    /**
     * Method used for autograding and testing the game code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The game should
     * behave exactly as if the user typed these characters into the game after playing
     * playWithKeyboard. If the string ends in ":q", the same world should be returned as if the
     * string did not end with q. For example "n123sss" and "n123sss:q" should return the same
     * world. However, the behavior is slightly different. After playing with "n123sss:q", the game
     * should save, and thus if we then called playWithInputString with the string "l", we'd expect
     * to get the exact same world back again, since this corresponds to loading the saved game.
     *
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] playWithInputString(String input) throws IOException {
        // TODO: Fill out this method to run the game using the input passed in,
        // and return a 2D tile representation of the world that would have been
        // drawn if the same inputs had been given to playWithKeyboard().


        String seed = "";

        boolean seed_finished = false;


        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            if (ch == 'N' || ch == 'n') {

                //String seed = input.replaceAll("\\D+", "");

                //World_generation_v2 W = new World_generation_v2(Integer.valueOf(seed), WIDTH, HEIGHT);

                //finalWorldFrame = W.returnworld();

                finalWorldFrame = new TETile[WIDTH][HEIGHT];

            } else if (ch == 'L' || ch == 'l') {


                try {

                    FileInputStream streamIn = new FileInputStream("./data.txt");
                    ObjectInputStream in = new ObjectInputStream(streamIn);
                     W= (World_generation_v2) in.readObject();

                     finalWorldFrame=W.return_existed_world();


                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else if (Character.isDigit(ch) && seed_finished == false) {


                seed = seed + ch;


            } else if ((ch == 'S' || ch == 's') && seed_finished == false) {


                W = new World_generation_v2(Integer.valueOf(seed), WIDTH, HEIGHT);
                finalWorldFrame = W.returnworld();

                seed_finished = true;

            }

            if ((ch == 'q' || ch == 'Q') && input.charAt(i - 1) == ':') {

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

        return finalWorldFrame;

    }


}