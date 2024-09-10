import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (this.head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
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

        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current.value == _value) {
                if (prev != null) {
                    prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = prev;
                } else {
                    tail = prev;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        if (head == null) return;

        while (head != null && head.value == _value) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
        if (head == null) {
            tail = null;
            return;
        }

        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.value == _value) {
                prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = prev;
                } else {
                    tail = prev;
                }
            } else {
                prev = current;
            }
            current = current.next;
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
            _nodeToInsert.prev = null;

            if (head != null) {
                head.prev = _nodeToInsert;
            }
            head = _nodeToInsert;

            if (tail == null) {
                tail = _nodeToInsert;
            }
            return;
        }

        _nodeToInsert.next = _nodeAfter.next;
        _nodeToInsert.prev = _nodeAfter;
        if (_nodeAfter.next != null) {
            _nodeAfter.next.prev = _nodeToInsert;
        }

        _nodeAfter.next = _nodeToInsert;
        if (_nodeAfter == tail) {
            tail = _nodeToInsert;
        }
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