public class IntList {
    public int first;
    public IntList rest;
    public int size;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
        size=this.size();
    }

    /** Return the size of the list using... recursion! */
    /*public int size() {
        IntList s=this;
        int ss=0;

        while(true){

            ss=ss+1;
            if(s.rest!=null){

                s=s.rest;

            }
            else{
                break;}

        }
        return ss;
    }




*/


    public int size(){

       if(this.rest==null){

              return 1;

       }
        
       return 1+this.rest.size();


    }



    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList s=this;
        int ss=0;

        while(true){

            ss=ss+1;
            if(s.rest!=null){

                s=s.rest;

            }
            else{
                break;}

        }
        return ss;
    }

    /** Returns the ith value in this list.*/
    public int get(int i) {
            

            int m;
    	    
        
            if(i==0){

            	return this.first;
            }
                
             i=i-1;

            return this.rest.get(i);

    }

    public int get1(int i){

         IntList p=this;
         int m;
         m=this.size();

         while(m-1-i>0){

             p=p.rest;
             i=i+1;

         }

         
         return p.first;



    	
    }


   //尝试添加add方法,不能赋值给this

    /*public void add(int x){

     IntList temp=this;
     temp = new IntList(x, temp);
     
     this=temp;
    
    }*/

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.size());

        System.out.println(L.get(2));
        System.out.println(L.get1(2));


        IntList Q = new IntList(15, null);
        //Q.add(5);
        System.out.println(Q.get(0));
        //System.out.println(Q.get(1));

    }
} 