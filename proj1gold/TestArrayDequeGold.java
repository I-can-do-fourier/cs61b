import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

public class TestArrayDequeGold {





    public static String auto_message(int x,int value,int if_return){


         if(if_return>=10){return "";}


          switch (x){

              case 0:

                  return "addFirst("+String.valueOf(value)+")";

              case 1:
                  return "addLast("+String.valueOf(value)+")";

              case 2:

                  return "removeFirst()";

              case 3:

                  return "removeLast()";


              default:return "";

          }



    }


    @Test
    public void deque_test() {


        LinkedList<Integer> test1_correct = new ArrayDequeSolution<>();

        StudentArrayDeque<Integer> test1_student = new StudentArrayDeque<>();

        //test1  random addfirst and removefirst

       /* for (int i = 1; i <= 500; i++) {

            System.out.println("test: " + i);


            for (int j = 1; j <= i; j++) {

                Integer random = StdRandom.uniform(300);
                test1_correct.addFirst(random);
                test1_student.addFirst(random);


            }

            for (int j = 1; j <= i; j++) {

                assertEquals(test1_correct.removeFirst(), test1_student.removeFirst());


            }


        }


        //test2 addfirst removelast

        for(int i=1;i<=500;i++) {

            System.out.println("test: "+i);


            for (int j = 1; j <= i; j++) {

                Integer random = StdRandom.uniform(300);
                test1_correct.addFirst(random);
                test1_student.addFirst(random);


            }

            for (int j = 1; j <= i; j++) {

                assertEquals(test1_correct.removeLast(), test1_student.removeLast());


            }





        }


        //test3 addlast removefirst

        for (int i = 1; i <= 500; i++) {

            System.out.println("test: " + i);


            for (int j = 1; j <= i; j++) {

                Integer random = StdRandom.uniform(300);
                test1_correct.addLast(random);
                test1_student.addLast(random);


            }

            for (int j = 1; j <= i; j++) {

                assertEquals(test1_correct.removeFirst(), test1_student.removeFirst());


            }


        }*/



        //test4 addlast removelast

        for (int i = 1; i <= 10000; i++) {

            //System.out.println("test: " + i);

            int length=StdRandom.uniform(300);


            String message="";


            for (int j = 1; j <= length; j++) {



                int random_add=StdRandom.uniform(500);

                int random_choice=StdRandom.discrete(new int[]{7,7,1,4});

                switch(random_choice){
                    case 0 :

                        test1_correct.addFirst(random_add);
                        test1_student.addFirst(random_add);

                        message=message+auto_message(random_choice,random_add,length-j);
                        break;

                    case 1 :

                        test1_correct.addLast(random_add);
                        test1_student.addLast(random_add);
                        message=message+auto_message(random_choice,random_add,length-j);
                        break;

                    case 2:


                        message=message+auto_message(random_choice,random_add,length-j);
                        assertEquals(message,test1_correct.removeFirst(), test1_student.removeFirst());
                        break;

                    case 3:


                        message=message+auto_message(random_choice,random_add,length-j);
                        assertEquals(message,test1_correct.removeLast(), test1_student.removeLast());
                        break;

                }







            }


            //System.out.print(message);

        }




    }


}



