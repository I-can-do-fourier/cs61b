import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

public class gold_test {





    public static String auto_message(int x,int value,int if_return){


        //if(if_return>=10){return "";}


        switch (x){

            case 0:

                return "addFirst("+String.valueOf(value)+")\n";

            case 1:
                return "addLast("+String.valueOf(value)+")\n";

            case 2:

                return "removeFirst()\n";

            case 3:

                return "removeLast()\n";


            default:return "";

        }



    }


    @Test
    public void deque_test() {


        LinkedList<Integer> test1_correct = new ArrayDequeSolution<>();

        StudentArrayDeque<Integer> test1_student = new StudentArrayDeque<>();



        for (int i = 1; i <= 1; i++) {

            //System.out.println("test: " + i);

            int length=StdRandom.uniform(20);


            String message="";


            for (int j = 1; j <= length; j++) {

                System.out.print(j);

                int random_add=StdRandom.uniform(500);

                int random_choice=StdRandom.discrete(new int[]{7,7,1,1});

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

                        assertEquals(test1_correct.removeFirst(), test1_student.removeFirst());
                        message=message+auto_message(random_choice,random_add,length-j);
                        break;

                    case 3:

                        assertEquals(test1_correct.removeLast(), test1_student.removeLast());
                        message=message+auto_message(random_choice,random_add,length-j);
                        break;

                }







            }


           System.out.print(message);
            System.out.print(length);


        }




    }


}



