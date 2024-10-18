import java.util.*;

class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if (v1 instanceof Number n1 && v2 instanceof Number n2) {
            return Double.compare(n1.doubleValue(), n2.doubleValue());
        } else if (v1 instanceof String n1 && v2 instanceof String n2) {
            n1 = ((String) v1).trim();
            n2 = ((String) v2).trim();
            int cmp = n1.compareTo(n2);
            return Integer.compare(cmp, 0);
        }
        return 0;
    }

    public void add(T value)
    {
        Node<T> addNode = new Node<>(value);
        if (head == null && tail == null) {
            Node<T> node = new Node<>(value);
            this.head = node;
            this.tail = node;
            return;
        }
        if (this.head != null && this.tail != null) {
            Node<T> node = this.head;
            while (node != null) {
                if (!_ascending && compare(addNode.value, node.value) >= 0) {
                    if (node == this.head) {
                        head.next = node.next;
                        addNode.next = node;
                        addNode.prev = null;
                        head = addNode;
                        addNode.next.prev = head;
                        return;
                    }
                    addNode.prev = node.prev;
                    node.prev.next = addNode;
                    addNode.next = node;
                    node.prev = addNode;
                    return;
                }
                if (_ascending && compare(addNode.value, node.value) <= 0) {
                    if (node == this.head) {
                        addNode.next = node;
                        node.prev = addNode.next;
                        this.head = addNode;
                        addNode.next.prev = addNode;
                        return;
                    }
                    node.prev.next = addNode;
                    addNode.prev = node.prev;
                    addNode.next = node;
                    addNode.next.prev = addNode;
                    return;
                }
                node = node.next;
            }
        }
        tail.next = addNode;
        addNode.prev = tail;
        tail = addNode;
    }

    public Node<T> find(T val)
    {
        Node<T> node = this.head;
        while (node != null) {
            if (_ascending && compare(val, this.head.value) < 0 || !_ascending && compare(val, this.head.value) > 0) {
                return null;
            }
            if (node.value == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void delete(T val)
    {
        Node<T> temp = find(val);
        Node<T> node = this.head;
        while (node != null) {
            if (this.head == temp && temp == this.tail) {
                tail = null;
                head = null;
                return;
            }
            if (temp == this.head) {
                this.head = temp.next;
                this.head.prev = null;
                return;
            }
            if (temp == this.tail) {
                this.tail = temp.prev;
                this.tail.next = null;
                return;
            }
            if (temp == node) {
                node = node.prev;
                node.next = temp.next;
                node.next.prev = node;
                return;
            }
            node = node.next;
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        Node<T> node = this.head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}



