/*
   Author: Tyler Norby
   Project: Lab02
   Description: implementation of MaxHeap data structure
    */
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

    static int left(int i) {
        return 2 * i + 1;
    }

    static int right(int i) {
        return 2 * i + 2;
    }


    void swap(int i, int p) {
        T temp;
        temp = heap[i];
        heap[i] = heap[p];
        heap[p] = temp;

    }


    public T extractHeapMax() {
        //javac *.java
        //./run_test 0.5
        if (heapSize < 1) {
            return null;
        }
        T popped = heap[0];
        for (int i = 0; i < heapSize; i++) {
            heap[i] = heap[i + 1];
        }
        heapSize--;


        maxHeapify(0);
        return popped;
    }

    public void maxHeapInsert(T o) {

        if (heapSize == capacity) {
            capacity *= 2;
            heap = Arrays.copyOf(heap, capacity);
        }

        heap[heapSize] = o;
        maxHeapify(0);
        heapSize++;
    }

    // Reorganizes heap array so it maintains maxHeap rules
    public void maxHeapify(int pos) {
        int left = left(pos);
        int right = right(pos);
        int largest;
        if (left < heapSize && heap[left].compareTo(heap[pos]) > 0) {
            largest = left;
        } else {
            largest = pos;
        }
        if (right < heapSize && heap[right].compareTo(heap[pos]) > 0) {
            largest = right;
        }
        if (largest != pos) {
            swap(pos, largest);
            maxHeapify(largest);
        }
    }

    // Checks if heap is empty
    public Boolean isEmpty() {
        return (heapSize == 0);
    }

    // Returns heapSize
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


    // Returns element of passed in index
    public T getElement(int i) {
        return heap[i];
    }

}
