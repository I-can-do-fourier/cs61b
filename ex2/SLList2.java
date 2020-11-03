

//level b


public class SLList2{

   //use to prevent the modification from users;

	//public int a;


   //use private to prevent the modification from users;


//nested class
                              private static class IntNode{

                                  public int value;
                                  public IntNode ref;


                                  public IntNode(int a, IntNode b){

                                       value=a;
                                       ref=b;



                                  }




}


   private IntNode first;

  // avoid the trouble when creating the empty list;
  private IntNode sentinel;


   private int size=1;

   public SLList2(int x){

    
      sentinel=new IntNode(7,null);
      
      sentinel.ref=new IntNode(x,null);

   		//first=new IntNode(x,null);



   }



  //the constructor that can create an empty IntNode.
  public SLList2(){

     
     sentinel=new IntNode(7,null);

     //first=null;
     size=0;


  }



  public SLList2(int[] list){

    
     sentinel=new IntNode(7,null);

     size=0;
     
     for(int i:list){


         this.addFirst(i);


     }

     


  }
   
   public void addFirst(int x){


        
       
       sentinel.ref=new IntNode(x,sentinel.ref);
       
       size++;


   }


  public int getFirst(){

      

       return sentinel.ref.value;


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


      //IntNode temp=sentinel.ref;    

      //......

      //temp=new IntNode(x,null);   

      //do not use the sentences above,it will cause a bug

  	  IntNode temp=sentinel;

  	  //when use the second constructor(create the empty list),it will have a bug when use this 

  	  //ethod just after the assignment.

  	 /* while(temp.ref!=null){

         temp=temp.ref;


  	  }

  	  temp.ref=new IntNode(x,temp.ref);
*/
  	  	while(temp.ref!=null){

            temp=temp.ref;

  	  	}

  	  	temp.ref=new IntNode(x,null);

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


    public void deleteFirst(){


        sentinel.ref=sentinel.ref.ref;

        size--;


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


              						SLList2 b=new SLList2();
                                      

                          b.addLast(1);
                          b.addLast(20);
                          b.addFirst(5);

                          //System.out.println(b.getFirst());
                                      
                                     
                          System.out.println(b.getSize());


                          b.deleteFirst();
                          
                          System.out.println(b.getSize());

                          System.out.println(b.getFirst());




                          System.out.println("\n\n");



                          SLList2 c=new SLList2(new int[]{1,2,3});

                          System.out.println(c.getSize());

                          System.out.println(c.getFirst());


			           }


}


