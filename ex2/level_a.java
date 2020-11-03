
public class level_a{


  public static void main(String[] args) {
  	
                

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





  }


}



class IntList{


     int first;
     IntList next;

     public IntList(int x, IntList y){

     			first=x;
     			next=y;

     }



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


}