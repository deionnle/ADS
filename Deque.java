import java.util.*;

public class Deque<T extends Comparable<T>> {
    private int count;
    private ArrayList<T> deque;
    private ArrayList<T> minValue;

    public Deque() {
        deque = new ArrayList<>();
        minValue = new ArrayList<>();
        count = 0;
    }

    public void addFront(T item) {
        deque.add(0, item);
        count++;
        if (minValue.isEmpty() || item.compareTo(getMin()) <= 0) {
            minValue.add(item);
        }
    }

    public void addTail(T item) {
        deque.add(item);
        count++;
        if (minValue.isEmpty() || item.compareTo(getMin()) <= 0) {
            minValue.add(item);
        }
    }

    public T removeFront() {
        if (count > 0) {
            T removed = deque.remove(0);
            count--;
            if (removed.equals(getMin())) {
                minValue.remove(minValue.size() - 1);
            }
            return removed;
        }
        return null;
    }

    public T removeTail() {
        if (count > 0) {
            T removed = deque.remove(deque.size() - 1);
            count--;
            if (removed.equals(getMin())) {
                minValue.remove(minValue.size() - 1);
            }
            return removed;
        }
        return null;
    }

    public int size() {
        return count;
    }

    public String checkDeque() {
        return deque.toString();
    }

    public boolean palindrome(String s) {
        Deque<Character> palindrom = new Deque<>();

        for (char c : s.toCharArray()) {
            palindrom.addTail(c);
        }

        while (palindrom.size() > 1) {
            if (!palindrom.removeFront().equals(palindrom.removeTail())) {
                return false;
            }
        }
        return true;
    }

    public T getMin() {
        if (minValue.isEmpty()) return null;
        return minValue.get(minValue.size() - 1);
    }

    public static boolean balance(String str) {
        Deque<Character> characterDeque = new Deque<>();
        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char ch : str.toCharArray()) {
            if (map.containsValue(ch)) {
                characterDeque.addTail(ch);
            }
            else if (map.containsKey(ch) && (characterDeque.size() == 0 || characterDeque.removeTail() != map.get(ch))) {
                return false;
            }
        }
        return characterDeque.size() == 0;
    }
}


