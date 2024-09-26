import java.util.*;

public class Deque<T> {
    private int count;
    private ArrayList<T> deque;

    public Deque() {
        deque = new ArrayList<>();
        count = 0;
    }

    public void addFront(T item) {
        deque.add(0, item);
        count++;
    }

    public void addTail(T item) {
        deque.add(item);
        count++;
    }

    public T removeFront() {
        if (count > 0) {
            count--;
            return deque.remove(0);
        }
        return null;
    }

    public T removeTail() {
        if (count > 0) {
            count--;
            return deque.remove(deque.size() - 1);
        }
        return null;
    }

    public int size() {
        return count;
    }

    public String checkDeque() {
        return deque.toString();
    }
}