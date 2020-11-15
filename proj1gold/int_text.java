public class int_text {

    public static void main(String[] args) {


        int a=2;

        Integer b=a;

        sb(2);

        int c=sb(2);

        Integer d=sb(3);

        int e=sb1(2);

        for(int i=0;i<20;i++){


            System.out.print(StdRandom.discrete(new int[]{7,7,1,1})+"  ");
        }

    }




    static int sb(Integer x){


        return x;


    }

    static Integer sb1(Integer x){

        return x;



    }
}
