public class MaxHeap<T extends Comparable<T>> {

    private T[] heap;
    private int heapSize;
    private int capacity;
    
    public MaxHeap(int capacity){
        this.capacity = capacity;
        heap = (T[])new Comparable[capacity];
        heapSize = 0;
    }
    //TODO: This might be 0
    public T extractHeapMax(){
        T popped = heap[1];
        heap[1] = heap[heapSize--];
        maxHeapify(1);
        return popped;
    }
    //TODO: This might be 0
    public void maxHeapInsert(T o){
        heap[heapSize] = o;
        T temp;

        // Traverse up and fix violated property
        int current = heapSize;
        int parent = ((current - 1)/2);
        while (heap[current].compareTo(heap[parent]) < 0) {
            temp = heap[current];
            heap[current] = heap[parent];
            heap[parent] = temp;
        }
        heapSize++;
        maxHeapify(1);
    }

    public void maxHeapify(int pos){
        int left = 2*pos;
        int right = 2*pos+1;
        int largest;
        T temp;

        if(left <= heapSize && heap[left].compareTo(heap[pos]) < 0){
            largest = left;
        }else{
            largest = pos;
        }
        if (right <= heapSize && heap[right].compareTo(heap[pos]) < 0){
            largest = right;
        }
        if (largest != pos){
            increaseKey(pos,largest);
            maxHeapify(largest);
        }
    }

    //Use it as a swap function
    public void increaseKey(int pos1, int pos2){
        T temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;

    }

    public Boolean isEmpty(){
        return (heapSize == 0);
    }

    public int getSize(){
        return heapSize;
    }

    public void setSize(int heapSize){
        this.heapSize  = heapSize;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public T[] getHeap(){
        return heap;
    }
}

