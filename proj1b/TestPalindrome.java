import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }


    //tests for ispalindorme



    @Test
     public void isp_normal_recursive_non_get_verison() {

        //Deque d = palindrome.wordToDeque("tjujt");

        assertTrue("you are beach", palindrome.isPalindrome("tjujt"));

        assertTrue("you are beach", palindrome.isPalindrome(""));

        assertTrue("you are beach", palindrome.isPalindrome("1"));

        assertFalse("you are a beach",palindrome.isPalindrome("tjusb"));

        assertTrue("space fail", palindrome.isPalindrome(" "));

        assertTrue("punctuation fail", palindrome.isPalindrome("i.i"));

        assertTrue("sentence fail", palindrome.isPalindrome("i 00 i"));

    }

}


