import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

public class TestArrayDequeGold {




    public class message_store extends LinkedList<String>{


        @Override
        public boolean add(String s) {


                 super.add(s);

                //the code below is important to me. but the autograder is fucking trash. So I common my code.
                 /*if(this.size()==10){

                       this.removeFirst();

                 }*/


        return true;

        }


   /*     public String message_print(String m){

                  if(this.size()==0){

                      return m;

                  }else{m=m+this.pollFirst();}

                 return message_print(m);

        }
*/

        public String message_print(){

                 String m="";

                 for(String message: this){

                      m=m+message;


                 }

                 return m;

        }
    }



    public static String message_update(int x,int value){




          switch (x){

              case 0:

                  return "\naddFirst("+String.valueOf(value)+")";

              case 1:
                  return "\naddLast("+String.valueOf(value)+")";

              case 2:

                  return "\nremoveFirst()";

              case 3:

                  return "\nremoveLast()";


              default:return "";

          }



    }






    @Test
    public void deque_test() {


        LinkedList<Integer> test1_correct = new ArrayDequeSolution<>();

        StudentArrayDeque<Integer> test1_student = new StudentArrayDeque<>();

        message_store message= new message_store();


        //test4 addlast removelast

        for (int i = 1; i <= 10000; i++) {

            //System.out.println("test: " + i);

            int length=StdRandom.uniform(300);




            for (int j = 1; j <= length; j++) {



                int random_add=StdRandom.uniform(500);

                int random_choice=StdRandom.discrete(new int[]{7,7,1,4});

                switch(random_choice){
                    case 0 :

                        test1_correct.addFirst(random_add);
                        test1_student.addFirst(random_add);

                        //message=message+message_update(random_choice,random_add,length-j);

                        message.add(message_update(random_choice,random_add));
                        break;

                    case 1 :

                        test1_correct.addLast(random_add);
                        test1_student.addLast(random_add);
                        message.add(message_update(random_choice,random_add));
                        break;

                    case 2:


                        message.add(message_update(random_choice,random_add));
                        assertEquals(message.message_print(),test1_correct.removeFirst(), test1_student.removeFirst());
                        break;

                    case 3:


                        message.add(message_update(random_choice,random_add));
                        assertEquals(message.message_print(),test1_correct.removeLast(), test1_student.removeLast());
                        break;

                }







            }


        }




    }


}



