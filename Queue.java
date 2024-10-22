import java.util.*;
import java.util.Stack;

public class Queue<T> {
    private ArrayList<T> queue;
    private int count;

    public Queue() {
    queue = new ArrayList<T>();
    count = 0;
    }

    public void enqueue(T item) {
        queue.add(count ++,item);
    }

    public T dequeue() {
        if (queue.isEmpty()) return null;
        T que = queue.get(0);
        queue.remove(0);
        count--;
        return que;
    }

    public int size() {
        return queue.size();
    }

    public void turn(int n) {
        for (int i = 0; i < n; i ++) {
            T temp = dequeue();
            enqueue(temp);
        }
    }

    public void reverse() {
        Stack<T> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(dequeue());
        }
        while (!stack.isEmpty()) {
            enqueue(stack.pop());
        }
    }
}


