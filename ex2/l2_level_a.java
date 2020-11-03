
public class l2_level_a{


  public static void main(String[] args) {
  	
               

             //text the method of addadjacent.   
/*
               System.out.println("haha");

        IntList L = new IntList(32, null);
                L = new IntList(16, L);
                L = new IntList(8, L);
                L = new IntList(4, L);
                L = new IntList(2, L);
                L = new IntList(1, L);
                L = new IntList(1, L);

                L.addAdjacent();

                for(int i=0;i<L.size();i++){

 						 
                         System.out.println(L.get(i));



                }
*/

                //test the method  of square


              System.out.println("\n\n");


               IntList Q=new IntList(2,null);

               Q=new IntList(1, Q);

                System.out.println(Q.size());

               //Q=new IntList(5, Q,true);

                for(int i=0;i<Q.size();i++){

                         
                         System.out.println(Q.get(i));



                }

                System.out.println("\n\n");

                Q.addLast(5);

                Q.addLast(7);

               System.out.println(Q.size());


               System.out.println("\n\n");

               for(int i=0;i<Q.size();i++){

                         
                         System.out.println(Q.get(i));



                }

                System.out.println("\n\n");

                //Q.square();
                
         /*       System.out.println(Q.size());
                int a=Q.size();

                System.out.println("\n\n");

              for(int i=0;i<Q.size();i++){

                         
                         System.out.println(Q.get(i));

                         

                }*/


  }


}



class IntList{


     int first;
     IntList next;

     int sign_of_addlast=0;

     public IntList(int x, IntList y){
                
                
     			first=x;
     			next=y;


     }

/*    public IntList(int x, IntList y,boolean t){

                
                if(this.size()>1){

                   square();


                }

                first=x;
                next=y;



    }
*/


     public void addAdjacent(){

           
            
            IntList temp=this;

       while(temp.next!=null)
            if(temp.first==temp.next.first){

                    temp.first=temp.first*2;
                    temp.next=temp.next.next;
            }

            
            else{  

            			temp=temp.next;
            }
   
     }


     //the  second question in level a.


     public void square(){

       
       IntList temp=this;

       while(temp.next!=null){
           
             temp.next=new IntList(temp.first*temp.first,temp.next);

             temp=temp.next.next;
       }

             


     }
        
       


     public int size(){

       if(this.next==null){

              return 1;

       }
        
       return 1+this.next.size();


    }


        public int get(int i) {
            

            int m;
    	    
        
            if(i==0){

            	return this.first;
            }
                
             i=i-1;

            return this.next.get(i);

    }


    public void addLast(int x){

         

         AddLast(x);
         this.square();

    }


    public int AddLast(int x){

        

          

         if(this.next==null){


            
             this.next=new IntList(x,this.next);

             //square();

             return 0;

         }

       return this.next.AddLast(x);

        

    }


}