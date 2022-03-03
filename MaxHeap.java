public class MaxHeap {
    private Process[] Heap;
    int size;
    int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new Process[this.maxSize];
    }

    // Returns pos of parent node
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    // Returns pos of left child node
    private int leftChild(int pos) {
        return ((2 * pos) + 1);
    }

    // Returns pos of right child node
    private int rightChild(int pos) {
        return ((2 * pos) + 2);
    }

    // Method returns if node is leaf
    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Swapping nodes
    private void swap(int fpos, int spos) {
        Process temp;
        temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    // Inserts a new element to max heap
    public void insert(Process element) {
        Heap[size] = element;

        // Traverse up and sets new element to correct positon
        int current = size;
        while (Heap[current].compareTo(Heap[parent(current)]) > 0) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    private void maxHeapify(int pos) {

        // TODO: remember what this does lol
        // Its a check of some sort
        if (isLeaf(pos)) {
            return;
        }

        // Assigning variables
        Process leftChild = Heap[leftChild(pos)];
        Process rightChild = Heap[rightChild(pos)];


        if (Heap[pos].compareTo(leftChild) < 0 || Heap[pos].compareTo(rightChild) < 0) {

            if (leftChild.compareTo(rightChild) > 0) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }

    }

    // Removes the root
    public Process extractMax() {
        Process root = Heap[0];
        Heap[0] = Heap[size - 1];
        maxHeapify(0);
        size--;
        return root;
    }
}

