public class IntList<T> {

    public T value;
    public IntList next;
    public IntList prev;

    public IntList(T v, IntList f,IntList b) {


        value=v;
        next=f;
        prev=b;

    }

} 