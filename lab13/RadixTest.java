import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RadixTest {


    public static void main(String[] args) {

    }



    @Test

    public void radixTest1(){


            String[] test={"hxh","xcj","xsb","lxz","ltl","lby","hjq","ls","zk"

                    ,"a","b","c","a ","a1","@","?","/n","0b"," c","x " };

            String[] sorted=RadixSort.sort(test);

/*
        System.out.println(test);
*/

            System.out.println(Arrays.toString(test));

            System.out.println(Arrays.toString(sorted));



    }



}
