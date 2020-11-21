package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Game {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 40;

    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public void playWithKeyboard() {
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

        TETile[][] finalWorldFrame;

        finalWorldFrame = new TETile[WIDTH][HEIGHT];

        String seed = "";

        boolean seed_finished = false;


        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            if (ch == 'N' || ch == 'n') {

                //String seed = input.replaceAll("\\D+", "");

                //World_generation_v2 W = new World_generation_v2(Integer.valueOf(seed), WIDTH, HEIGHT);

                //finalWorldFrame = W.returnworld();

                finalWorldFrame = new TETile[WIDTH][HEIGHT];

            } else if (Character.isDigit(ch) && seed_finished == false) {


                seed = seed + ch;


            } else if ((ch == 'S' || ch == 's') && seed_finished == false) {


                World_generation_v2 W = new World_generation_v2(Integer.valueOf(seed), WIDTH, HEIGHT);
                finalWorldFrame = W.returnworld();

                seed_finished = true;

            }

            if ((ch == 'q' || ch == 'Q') && input.charAt(i - 1) == ':') {

                ObjectOutputStream oos = null;
                FileOutputStream fout = null;

                try {
                    fout = new FileOutputStream("data.txt", true);
                    oos = new ObjectOutputStream(fout);
                    oos.writeObject(finalWorldFrame);
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