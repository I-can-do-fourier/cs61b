

//cast是对编译环节1起作用的

public class level_b{


   public static void main(String[] args) {
   	
          Monkey orangutan = new Monkey();
 		  Animal t=(Animal) orangutan;

 		  //Dog m=orangutan;

 		 // Dog fuck=new Animal();


   }



}


 class Animal{


 }



 class Dog extends Animal{
     int weight;
     public Dog(int weight_in_pounds) {
       weight = weight_in_pounds;
     }

     public Dog(){}
   }



  class Monkey extends Animal{}




 class Poodle extends Dog{
   public Poodle(int x) {

   	//super(x);

   }
 }