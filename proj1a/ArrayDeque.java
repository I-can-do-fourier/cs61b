


//circular version


public class ArrayDeque<T> {






      public static void main(String[] args) {

          /*ArrayDeque<String> s=new ArrayDeque<>();
          s.addLast("1");
          s.addFirst("4");

          s.removeFirst();

          ArrayDeque<String> s1=new ArrayDeque();
          s1.addFirst("1");
          s1.addLast("7");
          s1.addLast("3");
          s1.addLast("7");
          s1.addLast("9");
          s1.addFirst("5");
          s1.addLast("0");
          s1.addLast("6");
          s1.addLast("5");
          s1.addLast("4");
          s1.addFirst("8");
          s1.addLast("47");
          s1.addLast("356");
          s1.addLast("537");
          s1.addLast("358");
          s1.removeFirst();
          s1.removeLast();
          s1.removeFirst();
          s1.removeLast();
          s1.removeFirst();
          s1.removeLast();
          String got11=s1.get(1);
          String got12=s1.get(0);
          String got13=s1.get(2);
          String got14=s1.get(8);
          s1.removeFirst();
          s1.removeLast();
          s1.removeFirst();
          s1.removeLast();
          s1.removeFirst();
          s1.removeLast();
          s1.printDeque();
          s1.removeFirst();
          s1.removeLast();
          s1.removeFirst();
          s1.removeLast();
          s1.removeFirst();
          s1.removeLast();
          s1.addFirst("1");
          s1.addLast("7");
          s1.addLast("3");
          s1.addLast("7");
          s1.addLast("9");
          s1.addFirst("5");
          s1.addLast("0");
          s1.addLast("6");
          s1.addLast("5");
          s1.addLast("4");
          s1.addFirst("8");
          s1.addLast("47");
          s1.addLast("356");
          s1.addLast("537");
          s1.addLast("358");
          //LinkedListDeque<String> s1=new LinkedListDeque("1");

          ArrayDeque s2=new ArrayDeque(1);
          s2.addFirst(2);
          int a= (int) s2.removeLast();

          ArrayDeque<String> s3=new ArrayDeque();
          String got31=s3.get(0);
          s3.removeFirst();
          String got32=s3.get(0);
*/






          // test: add to the front and remove

          ArrayDeque<String> s1=new ArrayDeque();
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.addFirst("5");
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();
          s1.removeFirst();


          //test removelast


          /*ArrayDeque<Integer> s1=new ArrayDeque();

          s1.addFirst(0);
          s1.addLast(1);
          s1.addLast(2);
          s1.addFirst(3);
          s1.addFirst(4);
          s1.addLast(5);

          s1.addFirst(9);
          s1.addLast(10);
          s1.removeLast();
          s1.addLast(12);
          s1.addFirst(13);
          s1.removeLast();*/

      }


        private int exfactor=2;//扩大倍数

        private int shfactor=2;//缩小倍数

        private  T[] items;

        private int last_index;

        private int first_index;

        private int size=0;

        public ArrayDeque(){

            items= (T[]) new Object[8];

            last_index=4;
            first_index=3;


        }

        public ArrayDeque(T t){

            items= (T[]) new Object[8];

            items[4]=t;
            first_index=3;
            last_index=5;

            size++;
        }





    public void addFirst(T item){



         if(size==items.length){resize_expand();}

         items[first_index]=item;

         if(first_index==0){

             //items[first_index]=item;

             first_index=items.length-1;



         }

          else{first_index--;}

          size++;

    }


    public void addLast(T item){

        if(size==items.length){
            resize_expand();
        }


             items[last_index]=item;

           if(last_index==items.length-1){

                    last_index=0;


           }


           else{last_index++;}


           size++;


    }


    public boolean isEmpty(){

        if(size<=0){

            return true;

        }

        return false;


    }


    public int size(){return size;}


    public void printDeque(){}


    public T removeFirst(){



        if(items.length>=16&&(Double.valueOf(items.length)/size>4)){


            resize_shrink();

        }



        //if(size>0){size--;}else{return null;}

        if(size==0){return null;}

        T removed;

        //to remove the item and refresh the first_index, but this one is too complicated.

        /*if(first_index==items.length-1){

            removed=items[0];

            items[0]=null;

            first_index=0;

        }

        else{

            removed=items[first_index+1];

            items[first_index+1]=null;

            first_index++;



        }*/


            int removed_index=(first_index+1)%items.length;

            removed=items[removed_index];
             //items[removed_index]=null;
            first_index=removed_index;



             size--;

        return removed;

    }


    public T removeLast(){


        if(items.length>=16&&(Double.valueOf(items.length)/size>4)){


            resize_shrink();



        }


        //if(size>0){size--;}else{return null;}
        //else{return (T) this;}


        if(size==0){return null;}

        T removed;

/*        if(last_index==0){

            removed=items[items.length-1];

            items[items.length-1]=null;

            last_index=items.length-1;

        }

        else{

            removed=items[last_index-1];

            items[first_index-1]=null;

            last_index--;



        }*/


            int removed_index=(last_index-1)%items.length;

            if(removed_index<0){

                removed_index=removed_index+items.length;
            }


            removed=items[removed_index];
            //items[removed_index]=null;
            last_index=removed_index;


            size--;



        return removed;

    }

    public T get(int index){


    /*    if(first_index+1+index>items.length-1){


            return items[first_index+1+index-8];


        }
*/
         return items[(first_index+1+index)%items.length];

    }


    private void resize_expand(){

        T[] temp= (T[]) new Object[items.length * exfactor];

        int length_last=items.length-1-first_index;//计算从first_index到items队尾的长度



            System.arraycopy(items, (first_index + 1)%size, temp, (temp.length - length_last)%temp.length, length_last);

            System.arraycopy(items, 0, temp, 0, size-(size-last_index)%size);

            //items=temp;


            first_index = temp.length - length_last - 1; //新的first_index的位置

            last_index = size-(size-last_index)%size;


            items=temp;
    }

    private void resize_shrink(){

        T[] temp= (T[]) new Object[items.length/shfactor];

        int length_last=items.length-1-first_index;//计算从first_index到items队尾的长度

       if(first_index>last_index) {
           System.arraycopy(items, (first_index + 1)%size, temp, (temp.length - length_last)%temp.length, length_last);

           System.arraycopy(items, 0, temp, 0, last_index);




           first_index = temp.length - length_last - 1;//新的dirst_index的位置

       }


           else{



               System.arraycopy(items,first_index+1,temp,temp.length/4,size);

               first_index=temp.length/4-1;
               last_index=temp.length/4+size;


           };

                    items = temp;

    }


}
