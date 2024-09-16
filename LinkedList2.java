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
            else {
                head.prev = null;
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

    public void reverse() {
        Node current = head;
        Node temp = null;
        tail = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    public boolean cycle() {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        boolean bool = true;
        while (bool) {
            bool = false;
            Node current = head;

            while (current != null && current.next != null) {
                if (current.value > current.next.value) {
                    int temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;

                    bool = true;
                }
                current = current.next;
            }
        }
    }

    public static LinkedList2 mergeList(LinkedList2 list1, LinkedList2 list2) {
        list1.sort();
        list2.sort();
        LinkedList2 resultList = new LinkedList2();
        Node node1 = list1.head;
        Node node2 = list2.head;

        while (node1 != null && node2 != null) {
            if (node1.value <= node2.value) {
                resultList.addInTail(new Node(node1.value));
                node1 = node1.next;
            } else {
                resultList.addInTail(new Node(node2.value));
                node2 = node2.next;
            }
        }

        while (node1 != null || node2 != null) {
            if (node2 == null) {
                resultList.addInTail(new Node(node1.value));
                node1 = node1.next;
            } else {
                resultList.addInTail(new Node(node2.value));
                node2 = node2.next;
            }
        }
        return resultList;
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


