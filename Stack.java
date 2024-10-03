import java.util.*;
import java.util.function.BiFunction;

public class Stack<T> {
    private LinkedList<T> stack;
    private LinkedList<Number> minStack;
    private double sum;

    public Stack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        sum = 0;
    }

    public int size() {
        return stack.size();
    }

    public T pop() {
        if (!stack.isEmpty()) {
            T val = stack.removeLast();
            if (val instanceof Number) {
                double value = ((Number) val).doubleValue();
                stackSum(value, false);
                minValue((Number) val, false);
            }
            return val;
        }
        return null;
    }

    public T pop2() {
        if (!stack.isEmpty()) {
            return stack.removeFirst();
        }
        return null;
    }

    public void push(T val) {
        stack.addLast(val);
        if (val instanceof Number) {
            double value = ((Number) val).doubleValue();
            stackSum(value, true);
            minValue((Number) val, true);
        }
    }

    public void push2(T val) {
        stack.addFirst(val);
    }

    public T peek() {
        if (!stack.isEmpty()) {
            return stack.getLast();
        }
        return null;
    }

    public T peek2() {
        if (!stack.isEmpty()) {
            return stack.getFirst();
        }
        return null;
    }

    public static boolean balance(String str) {
        Stack<Character> characterStack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char ch : str.toCharArray()) {
            if (map.containsValue(ch)) {
                characterStack.push(ch);
            } else if (map.containsKey(ch) && (characterStack.size() == 0 || characterStack.pop() != map.get(ch))) {
                return false;
            }
        }
        return characterStack.size() == 0;
    }

    private void stackSum(double val, boolean bool) {
        if (bool) {
            sum += val;
        } else {
            sum -= val;
        }
    }

    private void minValue(Number val, boolean bool) {
        if (bool) {
            if (minStack.isEmpty() || val.doubleValue() <= minStack.getLast().doubleValue()) {
                minStack.addLast(val);
            }
        } else {
            if (!minStack.isEmpty() && val.doubleValue() == minStack.getLast().doubleValue()) {
                minStack.removeLast();
            }
        }
    }

    public T getMin() {
        if (!minStack.isEmpty()) {
            return (T) minStack.getLast();
        }
        return null;
    }

    public double getAverage() {
        if (stack.isEmpty()) {
            return 0;
        }
        return sum / stack.size();
    }

    public int postfix(String s) {
        Stack<Integer> stack2 = new Stack<>();
        String[] values = s.split(" ");

        HashMap<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("+", (a, b) -> b + a);
        operations.put("-", (a, b) -> b - a);
        operations.put("*", (a, b) -> b * a);
        operations.put("/", (a, b) -> b / a);

        for (String val : values) {
            if (Character.isDigit(val.charAt(0))) {
                stack2.push(Integer.parseInt(val));
                continue;
            }

            if (val.equals("=")) {
                return stack2.pop();
            }
            if (stack2.size() < 2) {
                return 0;
            }

            int a = stack2.pop();
            int b = stack2.pop();

            if (operations.containsKey(val)) {
                stack2.push(operations.get(val).apply(a, b));
            }
        }
        return stack2.pop();
    }
}


