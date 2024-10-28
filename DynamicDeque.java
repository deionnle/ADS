public class DynamicDeque<T> {
    private T[] array;
    private int head;
    private int tail;
    private int size;

    public DynamicDeque() {
        array = (T[]) new Object[8];
        head = 0;
        tail = 0;
        size = 0;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[array.length * 2];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[(head + i) % array.length];
        }
        array = newArray;
        head = 0;
        tail = size;
    }

    public void addFront(T item) {
        if (size == array.length) resize();
        head = (head - 1 + array.length) % array.length;
        array[head] = item;
        size++;
    }

    public void addTail(T item) {
        if (size == array.length) resize();
        array[tail] = item;
        tail = (tail + 1) % array.length;
        size++;
    }

    public T removeFront() {
        if (isEmpty()) return null;
        T item = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        return item;
    }

    public T removeTail() {
        if (isEmpty()) return null;
        tail = (tail - 1 + array.length) % array.length;
        T item = array[tail];
        array[tail] = null;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}



