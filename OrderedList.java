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

    public void removeDuplicates() {
        if (this.head == null) return;

        Node<T> current = this.head;
        while (current != null && current.next != null) {
            if (compare(current.value, current.next.value) == 0) {
                Node<T> duplicate = current.next;
                current.next = duplicate.next;
                if (duplicate.next != null) {
                    duplicate.next.prev = current;
                } else {
                    this.tail = current;
                }
            } else {
                current = current.next;
            }
        }
    }

    public static <T> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2, boolean ascending) {
        OrderedList<T> orderedList1 = list1._ascending == ascending ? list1 : list1.revers();
        OrderedList<T> orderedList2 = list2._ascending == ascending ? list2 : list2.revers();

        OrderedList<T> reverse = new OrderedList<>(ascending);

        Node<T> node1 = orderedList1.head;
        Node<T> node2 = orderedList2.head;

        while (node1 != null && node2 != null) {
            if ((list1.compare(node1.value, node2.value) <= 0 && ascending) ||
                    (list1.compare(node1.value, node2.value) >= 0 && !ascending)) {
                reverse.add(node1.value);
                node1 = node1.next;
            } else {
                reverse.add(node2.value);
                node2 = node2.next;
            }
        }

        while (node1 != null) {
            reverse.add(node1.value);
            node1 = node1.next;
        }

        while (node2 != null) {
            reverse.add(node2.value);
            node2 = node2.next;
        }
        return reverse;
    }

    public OrderedList<T> revers() {
        OrderedList<T> reversedList = new OrderedList<>(!_ascending);

        Node<T> node = this.tail;
        while (node != null) {
            reversedList.add(node.value);
            node = node.prev;
        }
        return reversedList;
    }

    public boolean SubList(OrderedList<T> subList) {
        if (subList.head == null) return true;
        if (this.head == null) return false;

        Node<T> current = this.head;

        while (current != null) {
            Node<T> Node = current;
            Node<T> subNode = subList.head;

            while (Node != null && subNode != null && compare(Node.value, subNode.value) == 0) {
                Node = Node.next;
                subNode = subNode.next;
            }

            if (subNode == null) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T findFrequentValue() {
        if (head == null) return null;

        HashMap<T, Integer> valuesMap = new HashMap<>();
        T Frequent = null;
        int maxCount = 0;

        for (Node<T> current = head; current != null; current = current.next) {
            Integer count = valuesMap.get(current.value);
            if (count == null) {
                count = 0;
            }
            count++;
            valuesMap.put(current.value, count);

            if (count > maxCount) {
                maxCount = count;
                Frequent = current.value;
            }
        }
        return Frequent;
    }

    public int findIndex(T value) {
        if (this.head == null) return -1;

        ArrayList<Node<T>> nodeList = getAll();
        int left = 0;
        int right = nodeList.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            Node<T> middleNode = nodeList.get(middle);
            int cmp = compare(value, middleNode.value);

            if (cmp == 0) {
                return middle;
            } else if ((_ascending && cmp < 0) || (!_ascending && cmp > 0)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}



