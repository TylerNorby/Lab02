public class PQueue {
    MaxHeap<Process> pqueue;


    public PQueue() {
        this.pqueue = new MaxHeap<Process>(100);
    }

    public void maximum() {
        pqueue.extractHeapMax();
    }

    public Process dePQueue() {
        return pqueue.extractHeapMax();
    }

    public void enPQueue(Process T) {
        pqueue.maxHeapInsert(T);
    }

    public void increaseKey(int pos1, int pos2) {
        pqueue.increaseKey(pos1, pos2);
    }

    public boolean isEmpty() {
        return pqueue.isEmpty();
    }

    public void update(int timeToIncrement, int maxPriority) {
        for (int i = 0; i < pqueue.getSize(); i++) {
            Process currentProcess = pqueue.getElement(i);
            if (currentProcess == null) {
                return;
            }
            currentProcess.incrementTimeNotProcessed();
            if (currentProcess.getTimeNotProcessed() >= timeToIncrement) {
                currentProcess.resetTimeNotProcessed();
                if (currentProcess.getPriority() < maxPriority) {
                    currentProcess.setPriority(currentProcess.getPriority() + 1);
                    pqueue.maxHeapify(1); //TODO: this might be 0
                }
            }


        }
    }

    public int size() {
        return pqueue.getSize();
    }

}
