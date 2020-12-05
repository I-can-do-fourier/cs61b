package lab9tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.In;
import org.junit.Test;
import lab9.BSTMap;

/**
 * Tests by Brendan Hu, Spring 2015, revised for 2018 by Josh Hug
 */
public class TestBSTMap {

    @Test
    public void sanityGenericsTest() {
        try {
            BSTMap<String, String> a = new BSTMap<String, String>();
            BSTMap<String, Integer> b = new BSTMap<String, Integer>();
            BSTMap<Integer, String> c = new BSTMap<Integer, String>();
            BSTMap<Boolean, Integer> e = new BSTMap<Boolean, Integer>();
        } catch (Exception e) {
            fail();
        }
    }

    //assumes put/size/containsKey/get work
    @Test
    public void sanityClearTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1 + i);
            //make sure put is working via containsKey and get
            assertTrue(null != b.get("hi" + i));
            assertTrue(b.get("hi" + i).equals(1 + i));
            assertTrue(b.containsKey("hi" + i));
        }
        assertEquals(455, b.size());
        b.clear();
        assertEquals(0, b.size());
        for (int i = 0; i < 455; i++) {
            assertTrue(null == b.get("hi" + i) && !b.containsKey("hi" + i));
        }
    }

    // assumes put works
    @Test
    public void sanityContainsKeyTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertFalse(b.containsKey("waterYouDoingHere"));
        b.put("waterYouDoingHere", 0);
        //b.put("waterYouDoingHere1", 1);
        assertTrue(b.containsKey("waterYouDoingHere"));
    }

    // assumes put works
    @Test
    public void sanityGetTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertEquals(null, b.get("starChild"));
        assertEquals(0, b.size());
        b.put("starChild", 5);
        assertTrue(((Integer) b.get("starChild")).equals(5));
        b.put("KISS", 5);
        assertTrue(((Integer) b.get("KISS")).equals(5));
        assertNotEquals(null, b.get("starChild"));
        assertEquals(2, b.size());
    }

    // assumes put works
    @Test
    public void sanitySizeTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertEquals(0, b.size());
        b.put("hi", 1);
        assertEquals(1, b.size());
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
        }
        assertEquals(456, b.size());
    }

    //assumes get/containskey work
    @Test
    public void sanityPutTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("hi", 1);
        assertTrue(b.containsKey("hi"));
        assertTrue(b.get("hi") != null);
    }


    @Test
    public void keySetTest(){

        BSTMap<String, Integer> b = new BSTMap<>();

        b.put("my", 1);
        b.put("name", 1);
        b.put("is", 1);
        b.put("hxh", 1);
        b.put("superman",1);

        System.out.println(b.keySet().toString());

    }



    @Test
    public void removeTest(){

        BSTMap<String, Integer> b = new BSTMap<>();

        b.put("my", 1);
        b.put("name", 2);
        b.put("is", 3);
        b.put("hxh", 4);
        b.put("but",5);
        b.put("i",6);
        b.put("can not",7);
        b.put("save",8);
        b.put("the world",9);
        b.put("superman",10);

        int x=b.remove("is");

        System.out.println(x);
        System.out.println(b.keySet().toString());

        b.remove("34");
        //System.out.println(x);
        System.out.println(b.keySet().toString());
        System.out.println(b.remove("my"));
        System.out.println(b.keySet().toString());



    }

    @Test
    public void BSTtest(){

        BST<String, Integer>b = new BST<>();
        b.put("fuck",0);
        b.put("you",1);
        b.put("deep night",3);
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestBSTMap.class);
    }
}
