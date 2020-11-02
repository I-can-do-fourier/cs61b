public class SLList{

   //use to prevent the modification from users;

	//public int a;


   //use private to prevent the modification from users;
   private IntNode first;


   public SLList(int x){



   		first=new IntNode(x,null);



   }


   
   public void addFirst(int x){

       
       first=new IntNode(x,first);



   }


  public int getFirst(){


       return first.value;


  }



 /* public int addLast(int x){

  	IntNode temp=first;

   if(temp.ref==null){

      
		temp.ref=new IntNode(x,null);
        return temp.value;
     

   }

          temp=temp.ref;

          return temp.addLast(x);

  }*/




  //iterate version

  public void addLast(int x){

  	  IntNode temp=first;

  	  while(temp.ref!=null){

         temp=temp.ref;


  	  }

  	  temp.ref=new IntNode(x,temp.ref);

  }


  public int size(){

       int s=0;
       IntNode temp=first;

  	  while(temp.ref!=null){

  	  	      temp=temp.ref;

              s++;


  	  }

  	         s++;
  
 			return s;
  }








			public static void main(String[] arg){


      					SLList s=new SLList(10);

                        s.addFirst(5);

                        System.out.println(s.getFirst());
                        
                        s.addLast(20);

                        System.out.println(s.getFirst());

                        System.out.println(s.size());



			}


}


class IntNode{

    public int value;
    public IntNode ref;


    public IntNode(int a, IntNode b){

         value=a;
         ref=b;



    }




}