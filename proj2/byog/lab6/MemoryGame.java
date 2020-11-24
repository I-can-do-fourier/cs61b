package byog.lab6;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class MemoryGame {
    private int width;
    private int height;
    private int round;
    private Random rand;
    private boolean gameOver;
    private boolean playerTurn;
    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!",
                                                   "You got this!", "You're a star!", "Go Bears!",
                                                   "Too easy for you!", "Wow, so impressive!"};



    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter a seed");
            return;
        }

        int seed = Integer.parseInt(args[0]);
        MemoryGame game = new MemoryGame(40, 40,seed);
        game.startGame();
    }

    public MemoryGame(int width, int height,int seed) {
        /* Sets up StdDraw so that it has a width by height grid of 16 by 16 squares as its canvas
         * Also sets up the scale so the top left is (0,0) and the bottom right is (width, height)
         */
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(this.width * 16, this.height * 16);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);

        StdDraw.setPenColor(10,150,200);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();

        rand=new Random(seed);



        //TODO: Initialize random number generator
    }

    public String generateRandomString(int n) {
        //TODO: Generate random string of letters of length n


        String randomString="";

        for(int i=0;i<n;i++){

                randomString=randomString+rand.nextInt(9);


        }

        return randomString;

    }

    public boolean drawFrame(String s) {
        //TODO: Take the string and display it in the center of the screen
        //TODO: If game is not over, display relevant game information at the top of the screen


          String input="";

           String expected=s;

           int i=0;

           while(true){




           StdDraw.pause(60);

           if(i>=expected.length()){break;}
           StdDraw.clear(Color.BLACK);

           //StdDraw.text(width/2,height/2,String.valueOf(expected.charAt()));

            if(StdDraw.hasNextKeyTyped()) {




                   char single_input = StdDraw.nextKeyTyped();

                   input=input+single_input;

                   if(single_input==expected.charAt(i)){


                        StdDraw.setPenColor(0,255,0);


                       i++;


                   }else{



                       StdDraw.setPenColor(255,0,0);

                       StdDraw.text(width/2,height/2,input);

                       StdDraw.text(width/2,height/3*2,"bad boy");

                       StdDraw.show();

                       StdDraw.pause(500);

                       return false;

                   }



           }

               StdDraw.text(width/2,height/2,input);

            //StdDraw.setFont();

            StdDraw.show();


           }

            return true;
    }

    public void flashSequence(String letters) {

            int i=0;

            while(i<letters.length()){



                    StdDraw.clear(Color.BLACK);

                    StdDraw.show();

                    StdDraw.pause(500);

                    StdDraw.text(width/2,height/3*2,String.valueOf(letters.charAt(i)));

                    StdDraw.show();

                    StdDraw.pause(500);

                    i++;
            }

    }

    public String solicitNCharsInput(int n) {
        //TODO: Read n letters of player input
        return null;
    }

    public void startGame() {
        //TODO: Set any relevant variables before the game starts

        //TODO: Establish Game loop

        int round=1;

        while(round<=5){


            String expected=generateRandomString(round);

            flashSequence(expected);


            boolean result=drawFrame(expected);

            if(!result){


                StdDraw.clear();


                StdDraw.text(width/2,height/2,"round:"+round);

                StdDraw.show();

                break;

            }

            round++;


        }


        StdDraw.clear();

        StdDraw.text(width/2,height/2,"end");

        StdDraw.show();



    }

}
