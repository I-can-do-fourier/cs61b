package byog.Core;

import java.util.ArrayList;
import java.util.List;

public class test_listremove {

    public static void main(String[] args) {

        List<int[]> temp=new ArrayList<>();
        List<int[]> temp1=null;

        List<int[]> temp2=new ArrayList<>();




        temp.add(new int[]{1,2});
        temp.add(new int[]{1,2});
        temp.add(new int[]{1,2});
        temp.add(new int[]{1,2});


        temp.addAll(temp2);
        temp.addAll(temp1);
        temp.add(new int[]{1,2});


        /*for(int[] i:temp){

            int t=0;

            while(t<10){


                temp.remove(0);

                temp.add(new int[]{t,t});

                t++;

            }

            break;


        }
*/

    }



}
