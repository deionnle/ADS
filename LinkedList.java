import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        if (head == null) return false;
        if (head.value == _value) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value == _value) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        while (head != null && head.value == _value) {
            head = head.next;
        }
        if (head == null) {
            tail = null;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value == _value) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
            } else {
                current = current.next;
            }
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public int count() {
        Node node = this.head;
        int length = 0;
        while (node != null) {
            length += 1;
            node = node.next;
        }
        return length;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            _nodeToInsert.next = head;
            head = _nodeToInsert;

            if (tail == null) {
                tail = _nodeToInsert;
            }
            return;
        }

        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        if (_nodeAfter == tail) {
            tail = _nodeToInsert;
        }
    }

    public static List<Integer> sumList(LinkedList list1, LinkedList list2) {
        List<Integer> sumList = new ArrayList<>();
        if (list1.count() != list2.count()) return sumList;
        Node node1 = list1.head;
        Node node2 = list2.head;
        while (node1 != null) {
            sumList.add(node1.value + node2.value);
            node1 = node1.next;
            node2 = node2.next;
        }
        return sumList;
    }
}

class Node {
    public int value;
    public Node next;
    public Node(int _value) {
        value = _value;
        next = null;
    }
}


