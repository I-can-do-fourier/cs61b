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




			public static void main(String[] arg){


      					SLList s=new SLList(10);

                        s.addFirst(5);

                        System.out.println(s.getFirst());

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