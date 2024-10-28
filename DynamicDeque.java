public class DynamicDeque<T> {
    private DynamicArray<T> dynamicArray;
    private int head;
    private int tail;
    private int size;

    public DynamicDeque() {
        dynamicArray = new DynamicArray<>();
        head = 0;
        tail = 0;
        size = 0;
    }

    private void resizeArray() {
        if (size == dynamicArray.size()) {
            dynamicArray.resize(size * 2, head, tail);
            head = 0;
            tail = size;
        }
    }

    public void addFront(T item) {
        resizeArray();
        head = (head - 1 + dynamicArray.size()) % dynamicArray.size();
        dynamicArray.set(head, item);
        size++;
    }

    public void addTail(T item) {
        resizeArray();
        dynamicArray.set(tail, item);
        tail = (tail + 1) % dynamicArray.size();
        size++;
    }

    public T removeFront() {
        if (isEmpty()) return null;
        T item = dynamicArray.get(head);
        dynamicArray.set(head, null);
        head = (head + 1) % dynamicArray.size();
        size--;
        return item;
    }

    public T removeTail() {
        if (isEmpty()) return null;
        tail = (tail - 1 + dynamicArray.size()) % dynamicArray.size();
        T item = dynamicArray.get(tail);
        dynamicArray.set(tail, null);
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

class DynamicArray<T> {
    private T[] array;

    public DynamicArray() {
        array = (T[]) new Object[8];
    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T item) {
        array[index] = item;
    }

    public void resize(int newCapacity, int head, int tail) {
        T[] newArray = (T[]) new Object[newCapacity];
        if (head < tail) {
            System.arraycopy(array, head, newArray, 0, tail - head);
        } else {
            System.arraycopy(array, head, newArray, 0, array.length - head);
            System.arraycopy(array, 0, newArray, array.length - head, tail);
        }
        array = newArray;
    }

    public int size() {
        return array.length;
    }
}



