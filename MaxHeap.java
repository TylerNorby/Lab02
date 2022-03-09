import java.util.Arrays;

public class MaxHeap<T extends Comparable<T>> {

    private T[] heap;
    private int heapSize;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = (T[]) new Comparable[capacity];
        heapSize = 0;
    }

    static int left(int i){
        return 2 * i + 1;
    }

    static int right(int i){
        return 2 * i + 2;
    }

    static int parent(int i){
        return (i-1)/2;
    }

    void swap(int i, int p){
        T temp;
        temp = heap[i];
        heap[i] = heap[p];
        heap[p] = temp;

    }


    public T extractHeapMax() {
        //javac *.java
        //./run_test 0.5
        if (heapSize < 1 ){
            return null;
        }
     //   T popped = heap[0];
       // for(int i = 0; i < heapSize; i++){
         //   heap[i] = heap[i+1];
       // }
        //heapSize--;

        heapSize--;
        T popped = heap[0];
        heap[0] = heap[heapSize];

        maxHeapify(0);
        return popped;
    }

    //TODO: double heap size
    public void maxHeapInsert(T o) {

        if (heapSize==capacity){
            capacity *= 2;
            heap = Arrays.copyOf(heap, capacity);
        }

        heap[heapSize] = o;
        maxHeapify(0);
        heapSize++;
    }

    public void maxHeapify(int pos) {
       int left = left(pos);
       int right = right(pos);
       int largest;
       if (left < heapSize && heap[left].compareTo(heap[pos]) > 0){
           largest = left;
       }else{
           largest = pos;
       }
       if (right < heapSize && heap[right].compareTo(heap[pos]) > 0){
           largest = right;
       }
       if (largest != pos){
           swap(pos, largest);
           maxHeapify(largest);
       }
    }

    //Use it as a swap function
    public void increaseKey(int pos1, int pos2) {
        T temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;

    }

    public Boolean isEmpty() {
        return (heapSize == 0);
    }

    public int getSize() {
        return heapSize;
    }

    public void setSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getHeap() {
        return heap;
    }

    public T getElement(int i){
        return heap[i];
    }

}
