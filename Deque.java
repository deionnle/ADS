import java.util.*;

public class Deque<T extends Comparable<T>> {
    private int count;
    private ArrayList<T> deque;
    private ArrayList<T> minHead;
    private ArrayList<T> minTail;

    public Deque() {
        deque = new ArrayList<>();
        minHead = new ArrayList<>();
        minTail = new ArrayList<>();
        count = 0;
    }

    public void addFront(T item) {
        deque.add(0, item);
        count++;
        if (minHead.isEmpty() || item.compareTo(getMinHead()) <= 0) {
            minHead.add(item);
        }
    }

    public void addTail(T item) {
        deque.add(item);
        count++;
        if (minTail.isEmpty() || item.compareTo(getMinTail()) <= 0) {
            minTail.add(item);
        }
    }

    public T removeFront() {
        if (count > 0) {
            T removed = deque.remove(0);
            count--;
            if (!minHead.isEmpty() && removed.equals(getMinHead())) {
                minHead.remove(minHead.size() - 1);
            }
            return removed;
        }
        return null;
    }

    public T removeTail() {
        if (count > 0) {
            T removed = deque.remove(deque.size() - 1);
            count--;
            if (!minTail.isEmpty() && removed.equals(getMinTail())) {
                minTail.remove(minTail.size() - 1);
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
        if (minHead.isEmpty() && minTail.isEmpty()) return null;
        if (minHead.isEmpty()) return getMinTail();
        if (minTail.isEmpty()) return getMinHead();
        if (getMinHead().compareTo(getMinTail()) <= 0) {
            return getMinHead();
        } else return getMinTail();
    }

    private T getMinHead() {
        return minHead.get(minHead.size() - 1);
    }

    private T getMinTail() {
        return minTail.get(minTail.size() - 1);
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


