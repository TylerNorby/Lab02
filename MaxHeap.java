public class MaxHeap<T extends Comparable<T>> {

    Comparable<T>[] heap;
    int heapSize;
    int capacity;
    
    public MaxHeap(int capacity){
        this.capacity = capacity;
        heap = new Comparable[capacity];
        heapSize = 0;
    }

    public T extractHeapMax(){
        T popped = (T)heap[1];
        heap[1] = heap[heapSize--];
        maxHeapify(1);
        return popped;
    }

    public void maxHeapInsert(T o, int pos){
        heap[heapSize] = (T)o;
        T temp;

        // Traverse up and fix violated property
        int current = heapSize;
        int parent = ((current - 1)/2);
        while (heap[current].compareTo((T)heap[parent]) < 0) {
            temp = (T) heap[current];
            heap[current] = heap[parent];
            heap[parent] = temp;
        }
        heapSize++;
        maxHeapify(pos);
    }

    public void maxHeapify(int pos){
        int left = 2*pos;
        int right = 2*pos+1;
        int largest;
        T temp;

        if(left <= heapSize && heap[left].compareTo((T)heap[pos]) < 0){
            largest = left;
        }else{
            largest = pos;
        }
        if (right <= heapSize && heap[right].compareTo((T)heap[pos]) < 0){
            largest = right;
        }
        if (largest != pos){
            temp = (T)heap[pos];
            heap[pos] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }

    //TODO: Figure this out lol
    public void increaseKey(int x, int y){

    }

    public Boolean isEmpty(){
        return (heapSize == 0);
    }

    public int getSize(){
        return heapSize;
    }


    //TODO: This
    public void setSize(int x){

    }

    public int getCapacity() {
        return capacity;
    }


    //TODO: This
    public void setCapacity(){

    }
}

