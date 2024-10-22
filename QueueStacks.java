import java.util.Stack;

public class QueueStacks<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T item) {
        stack1.push(item);
    }

    public T dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return null;
        }
        return stack2.pop();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}