public class Planet {


   double xxPos;
   double yyPos;
   double xxVel;
   double yyVel;
   double mass;
   String imgFileName;

   public static final double G=6.67e-11;



    public Planet(double xP,double yP, double xV,
                  double yV,double m,String img){


                    xxPos=xP;
                    yyPos=yP;
                    xxVel=xV;
                    yyVel=yV;
                    mass=m;
                    imgFileName=img;



    }


    public Planet(Planet P){

            xxPos=P.xxPos;
            yyPos=P.yyPos;
            xxVel=P.xxVel;
            yyVel=P.yyVel;
            mass=P.mass;
            imgFileName=P.imgFileName;



    }


    public double calcDistance(Planet p){

        double dx=p.xxPos-this.xxPos;
        double dy=p.yyPos-this.yyPos;

        return Math.sqrt(dx*dx+dy*dy);


    }

    public double calcForceExertedBy(Planet p){

           double r=calcDistance(p);
           double F;
           F=G*this.mass*p.mass/r/r;


        return F;

    }


    public double calcForceExertedByX(Planet p){


            double F=calcForceExertedBy(p);
            double r=calcDistance(p);

            double dx=p.xxPos-this.xxPos;

            return F*dx/r;

    }

    public double calcForceExertedByY(Planet p){


        double F=calcForceExertedBy(p);
        double r=calcDistance(p);

        double dy=p.yyPos-this.yyPos;

        return F*dy/r;

    }


  public double calcNetForceExertedByX(Planet[] ps){

              double nf=0;

              for(Planet p:ps){

                 if(!this.equals(p)){

                      nf=nf+calcForceExertedByX(p);

                      
       
                 }

                      }
  
             return nf;

  
       }

       public double calcNetForceExertedByY(Planet[] ps){

              double nf=0;

              for(Planet p:ps){

                 if(!this.equals(p)){

                      nf=nf+calcForceExertedByY(p);
       
                 }

                      }
  
             return nf;

  
       }




  public boolean equals(Planet p){


            if(this.imgFileName.equals(p.imgFileName)&&xxPos==p.xxPos&&
                    yyPos==p.yyPos&&
                    xxVel==p.xxVel&&
                    yyVel==p.yyVel&&
                    mass==p.mass){

                    return true;

            }

          
               return false;


  }


   public void update(double second, double x_force,double y_force){

                        double ax;
                        double ay;

                        ax=x_force/this.mass;
                        ay=y_force/this.mass;

                        xxVel=xxVel+ax*second;

                        yyVel=yyVel+ay*second;

                        xxPos=xxPos+xxVel*second;
                        yyPos=yyPos+yyVel*second;



   }

}
