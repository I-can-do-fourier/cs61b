import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.

    static Palindrome palindrome = new Palindrome();
    Deque d = palindrome.wordToDeque("persiflage");
    static CharacterComparator offByOne = new OffByOne();

    @Test

    public void isPalindrome_offbyone(CharacterComparator compare){


        assertTrue("you are beach", palindrome.isPalindrome("flake",offByOne));

        assertTrue("you are beach", palindrome.isPalindrome("",offByOne));

        assertTrue("you are beach", palindrome.isPalindrome("1",offByOne));

        assertTrue("you are a beach",palindrome.isPalindrome("122",offByOne));

        assertFalse("space fail", palindrome.isPalindrome("..1..",offByOne));

        assertTrue("you are beach", palindrome.isPalindrome("%&",offByOne));

        //assertTrue("punctuation fail", palindrome.isPalindrome("i.i",new OffByOne()));

        //assertTrue("sentence fail", palindrome.isPalindrome("i 00 i",new OffByOne()));*/


    }

    // Your tests go here.

}
