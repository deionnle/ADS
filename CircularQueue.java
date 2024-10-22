public class CircularQueue<T> {
    private T[] array;
    private int begin;
    private int end;
    private int capacity;
    private int size;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        begin = 0;
        end = 0;
        size = 0;
    }

    public boolean enqueue(T item) {
        if (isFull()) {
            return false;
        }
        array[end] = item;
        end = (end + 1) % capacity;
        size++;
        return true;
    }

    public T dequeue() {
        if (size == 0) {
            return null;
        }
        T item = array[begin];
        begin = (begin + 1) % capacity;
        size--;
        return item;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }
}