

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



        StdDraw.setCanvasSize(1000,1000);
        StdDraw.picture(0.5,0.5,"./images/starfield.jpg");


        

         
	}

	


  public static double readRadius(String s){

        In in=new In(s);


        int number=in.readInt();

        Double r_universe=in.readDouble();
       
        return r_universe;

  }





}