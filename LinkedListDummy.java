import java.util.ArrayList;

public class LinkedListDummy {

    private Node dummy;

    public LinkedListDummy() {
        dummy = new Dummy();
    }

    public void addInTail(Node _item) {
        _item.prev = dummy.prev;
        _item.next = dummy;
        dummy.prev.next = _item;
        dummy.prev = _item;
    }

    public Node find(int _value) {
        Node current = dummy.next;
        while (!(current instanceof Dummy)) {
            if (current.value == _value)
                return current;
            current = current.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> result = new ArrayList<>();
        Node current = dummy.next;
        while (!(current instanceof Dummy)) {
            if (current.value == _value) {
                result.add(current);
            }
            current = current.next;
        }
        return result;
    }

    public boolean remove(int _value) {
        Node current = dummy.next;
        while (!(current instanceof Dummy)) {
            if (current.value == _value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node current = dummy.next;
        while (!(current instanceof Dummy)) {
            if (current.value == _value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            current = current.next;
        }
    }

    public void clear() {
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public int count() {
        int count = 0;
        Node current = dummy.next;
        while (!(current instanceof Dummy)) {
            count++;
            current = current.next;
        }
        return count;
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

class Dummy extends Node {
    public Dummy() {
        super(0);
        this.next = this;
        this.prev = this;
    }
}


