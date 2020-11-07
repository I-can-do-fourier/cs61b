

public class NBody{


	public static void main(String[] args) {
		
      //read the information of the universe
		double T=Double.parseDouble(args[0]);

        double dt=Double.parseDouble(args[1]);

        String filename=args[2];

        In in=new In(filename);

        int n=in.readInt();

        Double r=in.readDouble();


      //draw the background of the universe



        StdDraw.setCanvasSize(512,512);

        StdDraw.setXscale(-r,r);
        StdDraw.setYscale(-r,r);
        StdDraw.picture(0,0,"./images/starfield.jpg");

        
       //draw planets 

       
        Planet[] p=new Planet[n];

        int i=n;

        //read all the data of the planets into the code;

         while(i-1>=0){

           p[i-1]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),
                             in.readDouble(),in.readDouble(),in.readString());
           
             StdDraw.picture(p[i-1].xxPos,p[i-1].yyPos,"./images/"+p[i-1].imgFileName);
           //StdDraw.picture(0,0,"./images/"+p[i-1].imgFileName);
            i--;
         }


         StdDraw.enableDoubleBuffering();


         
	}


	//create the animation

	


  public static double readRadius(String s){

        In in=new In(s);


        int number=in.readInt();

        Double r_universe=in.readDouble();
       
        return r_universe;

  }





}