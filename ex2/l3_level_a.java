
import java.io.*; 
import java.util.*; 

public class l3_level_a{



     public static void main(String[] args) {
     	

                //int[] a={1,2,3};

                //System.out.println(a[2]);


     					Piece p1=new Piece(20,0);
     				    Piece p2=new Piece(10,10);
     				    Piece p3=new Piece(0,20);
     				    Piece p4=new Piece(10,20);
     				    Piece p5=new Piece(20,20);
     				    Piece p6=new Piece(20,10);
     				    Piece p7=new Piece(0,10);
     				    Piece p8=new Piece(0,0);
     				    Piece p9=new Piece(10,0);


     				    Piece[] p={p1,p2,p3,p5,p4,p9,p6,p8,p7};

     				    //Collections.shuffle(p);
           						
                         int i=0;

                         //show the prospective array of map.
           						            
                       for(Piece pp:p){
                             
                            i++;
                            System.out.print(pp.lat+" "+pp.lon+"    ");

                            if(i%3==0){

                               System.out.print("\n");


                            }
        
                       }





					Piece[][] p_groupbylat=new Piece[3][];
                    p_groupbylat=Piece.groupByLat(p);

                    Piece.sortbylat(p_groupbylat);

                    for(Piece[] t:p_groupbylat){


                         for(Piece s:t){

                              System.out.print(s.lat+" "+s.lon+"    ");




                         }

                         System.out.println("\n");



                    }





     }



}


//step a;


class Piece{

	public int lat;  //latitude

	public int lon;  //longtitude


	public Piece(int x, int y){

           lat=x;
           lon=y;


	}



//step b  make sure that in each colnumn the latitudes of the piece are different. 



public static Piece[][] groupByLat(Piece[] p){


    int w=(int) p.length/3;
    
    System.out.println(w);

    Piece[][] latGroup=new Piece[3][w];


  //copy the elements in p into the 3*3 latgroup.

   for(int i=0;i<w;i++){
         
         System.out.println(1);
         System.arraycopy(p,i*3,latGroup[i],0,3);

   }



   for (int j=0;j<3;j++){



      for (int i=0;i<w-1;i++){

      	 int n=i+1;

      	 System.out.println(2);

          while(latGroup[i+1][j].lat==latGroup[0][j].lat){

                   Piece temp=null;
                
                   System.out.println(3);

                   temp=latGroup[i+1][j];
                   latGroup[i+1][j]=latGroup[i+1][n];
				   latGroup[i+1][n]=temp;

				   n++;
                   
          }


             

   	
       }




   }



    return latGroup;

	
}


//make sure that in each row the latitudes of the piece are same 
//and the piece with the lower latitude will rank higer in the array 

public static void sortbylat(Piece[][] p){



    int w=p.length;

      for(int j=0;j<3;j++){

           
           for(int i=0;i<w-1;i++){


           	  for(int t=i+1;t<w;t++){


                 if(p[t][j].lat<p[i][j].lat){

                        
                    Piece temp=null;

                    temp=p[i][j];
                    p[i][j]=p[t][j];
                    p[t][j]=temp;


               }
                    




           	  }


               /*if(p[i][j]>p[i+1][j]){

                        
                    Piece temp=null;

                    temp=p[i][j];
                    p[i][j]=p[i+1][j];
                    p[i+1]=temp;


               }*/



           }


      }






    //return sortbylat;


}



}





/*



for(i){
	


	while(j)




}





*/




/*

    System.out.printin("this keyboard is extremely excellent");


*/