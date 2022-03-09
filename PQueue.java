/*
   Author: Tyler Norby
   Project: Lab02
   Description: implementation of Process Queue data structure
    */
public class PQueue {
    MaxHeap<Process> pqueue;


    // Default constructor
    public PQueue() {
        this.pqueue = new MaxHeap<Process>(100);
    }

    // removes top element from queue
    public Process dePQueue() {
        return pqueue.extractHeapMax();
    }

    // Adds on to queue
    public void enPQueue(Process T) {
        pqueue.maxHeapInsert(T);
    }


    public boolean isEmpty() {
        return pqueue.isEmpty();
    }

    // Updates queue data evey tick
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
                    pqueue.maxHeapify(1);
                }
            }


        }
    }


}
