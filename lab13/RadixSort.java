/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */


    private static String[] padded;

    public static String[] sort(String[] asciis) {

        padded=new String[asciis.length];

        int length_max=0;

        for(String i:asciis){

            if(i.length()>length_max){

                length_max=i.length();

            }

        }

        //pad the Strings

        for(int i=0;i<padded.length;i++){

            int pad_num=length_max-asciis[i].length();

            padded[i]=asciis[i]+" ".repeat(pad_num);


        }


        String[] sorted=new String[asciis.length];

        for(int i=0;i<asciis.length;i++){

            sorted[i]=asciis[i];

        }

        int index=length_max-1;

        while(index>=0){

            sortHelperLSD(sorted,index);

            index--;

        }


        // TODO: Implement LSD Sort
        return sorted;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort

        if(index<0){

            return;

        }

        int[] counting=new int[256];

        int[] pos=new int[256];

        String[] pad_temp=new String[padded.length];
        String[] sorted=new String[asciis.length];

        for(int i=0;i<asciis.length;i++){

            sorted[i]=asciis[i];

        }

        for(String s:padded){

            int value=s.charAt(index);
            counting[value]++;

        }

        int position=0;

        for(int i=0;i<pos.length;i++){

            pos[i]=position;

            position=position+counting[i];


        }

        for(int i=0;i<padded.length;i++){

             int item=padded[i].charAt(index);

             int put=pos[item];

             asciis[put]=sorted[i];
             pad_temp[put]=padded[i];

             pos[item]++;


        }

        //asciis=sorted;
        padded=pad_temp;


        return;
    }

    private String[] counting_sort(String[] as,int index){

        return null;

    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
}
