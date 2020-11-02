public class SLList{

   //use to prevent the modification from users;

	//public int a;

   private IntNode first;


   public SLList(int x){



   		first=new IntNode(x,null);



   }






public static void main(String[] arg){


      SLList s=new SLList(10);

      

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