
import org.junit.Test;
import static org.junit.Assert.*;





public class TestOffByN {


    static Palindrome palindrome = new Palindrome();
    Deque d = palindrome.wordToDeque("persiflage");



    @Test
    public void isPalindrome_offbyone(){


        assertTrue("you are beach", palindrome.isPalindrome("abdc",new OffByN(2)));

        assertTrue("you are beach", palindrome.isPalindrome("",new OffByN(123)));

        assertTrue("you are beach", palindrome.isPalindrome("1",new OffByN(23)));

        assertTrue("you are a beach",palindrome.isPalindrome("1.6",new OffByN(5)));

        assertTrue("space fail", palindrome.isPalindrome("..1..",new OffByN(0)));

        assertTrue("you are beach", palindrome.isPalindrome("%&",new OffByN(1)));


    }


}
