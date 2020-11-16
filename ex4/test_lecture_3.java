
public class test_lecture_3{





 public static void main(String[] args) {


            Mutant m=new Mutant();

            m.bark();

 	
 }




}



 class Tree{
   public int bark(){System.out.println("tree");return 0;}
 }

interface Dog{
   default int bark(){System.out.println("Dog");return 0;}
 }



class Mutant extends Tree implements Dog{


     


 }
