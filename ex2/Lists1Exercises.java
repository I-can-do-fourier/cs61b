public class Lists1Exercises {
    public int first;
    public IntList rest;


//该做法有问题
    /*public static IntList incrList(IntList L, int x) {
        int i = 0;
        IntList Q = new IntList(L.first, L.rest);
        IntList temp = Q;
        while(temp != null) {
            temp.first += x;
            temp = temp.rest;
        }
        return Q;
    }*/




    //这么做有点麻烦,是正确的

public static IntList incrList(IntList L, int x) {

        IntList Q;
        int i=0;

        //not to use get();
        Q = new IntList(L.get1(i)+x, null);
        while(i<=L.size()-1){

            Q = new IntList(L.get1(i)+x, Q);
            //L.rest = new IntList(7, null);
            //L.rest.rest = new IntList(9, null);

        i++;

        }
    


        return Q;
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */

        //IntList Q=L;
        
        IntList q=L;
        while(q!=null){

           q.first=q.first+x;
           q=q.rest;


        }

        return L;
    }



    public static void main(String[] args) {


        /*int[] data={5,7,9};
        IntList L=new IntList(data[0],null);;


        IntList t=L.rest;
        for(int i=1;i<=2;i++){

            t=new IntList(data[i],null);
            t=t.rest;


        }*/


        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        //System.out.println(L.size());
        //System.out.println(L.iterativeSize());
        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        //System.out.println(L.get(1));
        System.out.println(incrList(L,3).get(0));
        //System.out.println(dincrList(L, 3));
        System.out.println(L.get(0));
        System.out.println(dincrList(L, 3).get(0));
        System.out.println(L.get(0));

        //System.out.println(dincrList(L, 3).get(1));
        //System.out.println(L.get(1));



    }
} 