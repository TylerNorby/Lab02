public class HeapNode<T> {
    T object;
    int key;

    public HeapNode(int key, T object) {
        this.key = key;
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object){
        this.object = object;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key){
        this.key = key;
    }
}
