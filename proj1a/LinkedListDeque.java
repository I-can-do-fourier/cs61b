public class LinkedListDeque<T> {




    private int size=0;

    //public T item;

    private IntList  first;

    private IntList sentinel;

    //empty linkedListDeque;


          public static void main(String[] args) {

              LinkedListDeque<String> s=new LinkedListDeque();
              s.addLast("1");
              s.addFirst("4");

              s.removeFirst();

              LinkedListDeque<String> s1=new LinkedListDeque();
              s1.addFirst("1");
              s1.addLast("3");
              s1.addLast("3");
              s1.addLast("3");
              s1.addLast("3");
              s1.addLast("7");
              s1.addLast("7");
              s1.addLast("7");
              s1.addLast("7");
              s1.addLast("7");

              String got11=s1.get(1);
              String got12=s1.get(0);
              String got13=s1.get(2);
              s1.printDeque();
              //LinkedListDeque<String> s1=new LinkedListDeque("1");

              String got14=s1.getRecursive(3);
              String got15=s1.getRecursive(0);
              String got16=s1.getRecursive(1);
              String got17=s1.getRecursive(5);

              LinkedListDeque s2=new LinkedListDeque("1");
              s2.addFirst("2");
              String a= (String) s2.removeLast();

              LinkedListDeque<String> s3=new LinkedListDeque();
              String got31=s3.get(0);
              s3.removeFirst();
              String got32=s3.get(0);


         }

    public LinkedListDeque(){


          sentinel=new IntList(null,null,null);

          //sentinel.next=sentinel.prev;


          //sentinel的prev和next都要指向sentinel本身
          sentinel.prev=sentinel;

          sentinel.next=sentinel.prev;


    }

    public LinkedListDeque(T x){


         size++;

        sentinel=new IntList(7,null,null);



        sentinel.next=new IntList(x,sentinel,sentinel);

        sentinel.prev=sentinel.next;



    }







    public void addFirst(T item){

       sentinel.next=new IntList(item,sentinel.next,sentinel);

       sentinel.next.next.prev=sentinel.next;

       size++;



    }


    public void addLast(T item){

      sentinel.prev=new IntList<T>(item,sentinel,sentinel.prev);

      sentinel.prev.prev.next=sentinel.prev;

      size++;


    }

   public boolean isEmpty(){

        if(size<=0){

            return true;

        }

        return false;


   }


   public int size(){

        return size;

   }

   public void printDeque(){

      int i=1;

      IntList temp=sentinel.next;

      while(i<=size) {

          System.out.print(temp.value+"  ");
          temp=temp.next;

          i++;
      }
   }

   public T removeFirst(){



        T removed= (T) sentinel.next.value;
       sentinel.next.prev=null;

       sentinel.next.next.prev=sentinel;

       sentinel.next=sentinel.next.next;

       //sentinel.next.prev=sentinel;

     /*  if(size>0){

           size--;

       }*/

       if(size>0){

           size--;

       }

       return removed;

   }


   public T removeLast(){


       T removed=(T) sentinel.prev.value;

      sentinel.prev.next=null;

      sentinel.prev.prev.next=sentinel;

      sentinel.prev=sentinel.prev.prev;

      if(size>0){

          size--;

      }


       return removed;


   }

   public T get(int index){



         if(index>size-1||index<0){


             System.out.println("out of the size");

             return null;

         }

        IntList temp=sentinel;



        while (index>=0){


           temp=temp.next;

           index--;

        }


        return (T) temp.value;

   }




   private static Object GetRecursive(int x,IntList t){

                if(x==0){

                    return t.value;


                }

                 x--;

                return GetRecursive(x,t.next);


   }

    public T getRecursive(int x){

           return (T) GetRecursive(x,sentinel.next);

    }


}
