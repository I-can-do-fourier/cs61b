import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

public class TestArrayDequeGold {


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

        for (int i = 1; i <= 500; i++) {

            System.out.println("test: " + i);


            for (int j = 1; j <= i; j++) {

                Integer random = StdRandom.uniform(300);
                test1_correct.addLast(random);
                test1_student.addLast(random);


            }

            for (int j = 1; j <= i; j++) {

                assertEquals(test1_correct.removeLast(), test1_student.removeLast());


            }


        }




    }


}



