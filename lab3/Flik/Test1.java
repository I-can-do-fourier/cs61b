import static org.junit.Assert.*;

import org.junit.Test;


public class Test1 {



    @Test
    public void testFlik(){


        //assertTrue(true);

        //assertTrue("the world is dead", Flik.isSameNumber(1,1));

        boolean b =Flik.isSameNumber(128,128);
        assertFalse("the world is dead", Flik.isSameNumber(128,128));



    }




}
