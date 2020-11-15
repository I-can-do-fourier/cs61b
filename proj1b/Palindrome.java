//import java.util.LinkedList;

public class  Palindrome{

    public Deque<Character> wordToDeque(String word){

            Deque<Character> deque=new LinkedListDeque();

        for(int i = 0, n = word.length() ; i < n ; i++) {
            char c = word.charAt(i);

            deque.addLast(c);

        }

        return deque;

    }




    //help method for ispalindrome


    private static boolean compare_char2(Deque d,int index){

                 if(d.get(index)!=d.get(d.size()-1-index)){


                     return false;


                 }

          return true;

    }

    public boolean isPalindrome2(String word){


        Deque temp=wordToDeque(word);

        //int length= temp.size();

        for(int i=0;i<=temp.size()/2;i++){

               if(!compare_char2(temp, i)){

                   return false;


               }

        }

         return true;


    }


     private static boolean compare_char(Deque d){


                if(d.size()==0||d.size()==1){


                    return true;


                } else if(d.removeFirst()!=d.removeLast()){


                      return false;

                }


        return compare_char(d);

    }


    public boolean isPalindrome(String word){


               return compare_char(wordToDeque(word));



    }




}