

//single linked list


public class SLList{

   //use to prevent the modification from users;

	//public int a;


   //use private to prevent the modification from users;
   private IntNode first;


   private int size=1;

   public SLList(int x){



   		first=new IntNode(x,null);



   }



  //the constructor that can create an empty IntNode.
  public SLList(){

     first=null;
     size=0;


  }

   
   public void addFirst(int x){

       
       first=new IntNode(x,first);
       
       size++;


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

  	  //when use the second constructor(create the empty list),it will have a bug when use this 

  	  //ethod just after the assignment.

  	 /* while(temp.ref!=null){

         temp=temp.ref;


  	  }

  	  temp.ref=new IntNode(x,temp.ref);
*/
  	  	while(temp!=null){

            temp=temp.ref;

  	  	}

  	  	temp=new IntNode(x,temp);

  	  size++;

  }


//we can not use recursion to create a non-static size method,but we can use static method to help us.



  public static int size(IntNode m){

      
          if(m.ref==null){


          		return 1;

          }

        
        return 1+size(m.ref);


  }

  public int size(){

    return size(first);




  }


  
//the size method that i created with iterate 
  /*public int size(){

       int s=0;
       IntNode temp=first;

  	  while(temp.ref!=null){

  	  	      temp=temp.ref;

              s++;


  	  }

  	         s++;
  
 			return s;
  }
*/



  	public int getSize(){

 				return size;


  	}



			public static void main(String[] arg){


      					SLList s=new SLList(10);

                        s.addFirst(5);

                        System.out.println(s.getFirst());
                        
                        s.addLast(20);

                        System.out.println(s.getFirst());

                        System.out.println(s.size());

						System.out.println(s.getSize());

						System.out.println("\n\n");


						SLList b=new SLList();
                        

                        b.addLast(1);
                        b.addLast(20);
                        b.addFirst(5);

                        //System.out.println(b.getFirst());
                        
                       
                        System.out.println(b.getSize());





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