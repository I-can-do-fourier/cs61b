

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

        int i=1;

        //read all the data of the planets into the code;

         while(i<=n){

           p[i-1]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),
                             in.readDouble(),in.readDouble(),in.readString());
           i++;

         }

         Planet.draw(p);


         StdDraw.enableDoubleBuffering();

         double t=0;
         while (t<=T){


             double[] xForces=new double[5];
             double[] yForces=new double[5];

             for(i=0;i<n;i++){

                 xForces[i]=p[i].calcNetForceExertedByX(p);
                 yForces[i]=p[i].calcNetForceExertedByY(p);

                 p[i].update(dt,xForces[i],yForces[i]);
                 StdDraw.picture(0,0,"./images/starfield.jpg");

                 Planet.draw(p);

                 StdDraw.show();

                 StdDraw.pause(10);

             }
             t=t+dt;
         }

	}


	//create the animation

	


  public static double readRadius(String s){

        In in=new In(s);


        int number=in.readInt();

        Double r_universe=in.readDouble();
       
        return r_universe;

  }





}