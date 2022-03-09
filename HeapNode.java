/*
   Author: Tyler Norby
   Project: Lab02
   Description: implementation of HeapNode for use in MaxHeap class
    */
public class HeapNode<T> {
    T object;


    //Default Constructor for HeapNode Class
    public HeapNode(int key, T object) {
        this.object = object;
    }

    // Returns Generic Object
    public T getObject() {
        return object;
    }

    // Sets generic object
    public void setObject(T object){
        this.object = object;
    }

}
