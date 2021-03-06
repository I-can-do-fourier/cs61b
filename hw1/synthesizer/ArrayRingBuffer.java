// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.


               this.capacity=capacity;
               rb=(T[]) new Object[this.capacity];
               first=capacity/2;
               last=capacity/2;


    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.


          if(capacity()==fillCount()){

              throw new RuntimeException("Ring Buffer Overflow");
          }



            rb[last] = x;

            if(last==0){

                last=capacity-1;


            }else{last--;}


        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update


        if(fillCount==0){

            throw new RuntimeException("Ring Buffer Underflow");

        }

        T temp=rb[first];

        if(first==0){

            first=capacity-1;


        }else{first--;}


        fillCount--;

        return temp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {


        if(fillCount==0){

                throw new RuntimeException();

        }



        return rb[first];

        // TODO: Return the first item. None of your instance variables should change.
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.


    public static void main(String[] args) {

        BoundedQueue<Integer> a=new ArrayRingBuffer<>(8);

        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        a.enqueue(6);
        a.enqueue(7);
        a.enqueue(8);

        for(int i:a){

            System.out.println(i);

        }


        Object re=a.dequeue();
        re=a.dequeue();
        re=a.dequeue();
        re=a.dequeue();
        re=a.dequeue();
        re=a.dequeue();
        re=a.dequeue();
        re=a.dequeue();
        //Object pe=a.peek();
        a.enqueue(5);
        a.enqueue(6);
        a.enqueue(7);
        a.enqueue(8);
        a.enqueue(5);
        a.enqueue(6);
        a.enqueue(7);
        a.enqueue(8);






    }

    @Override
    public Iterator<T> iterator() {


        return new array_iter<T>();


    }


    public class array_iter<T> implements Iterator<T>{


        int remaining=fillCount;
        int pointer= first;


        @Override
        public boolean hasNext() {

            if(remaining>0){

                return true;

            }
            return false;
        }

        @Override
        public T next() {

            T temp= (T) rb[pointer];

            if(pointer==0){

                pointer=capacity-1;

            }else {pointer--;}

            remaining--;

            return temp;
        }
    }
}
