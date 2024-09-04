import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LinkedListTest {
    @Test
    public void removeOneValueTest() {
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(5));
        assertEquals(true,s_list.remove(3));
    }

    @Test
    public void removeAllValuesTest() {
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(3));
        s_list.removeAll(3);
        ArrayList<Node> nodes = new ArrayList<>();
        assertEquals(nodes,s_list.findAll(3));
    }

    @Test
    public void clearListTest() {
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(3));
        s_list.clear();
        assertEquals(0, s_list.count());
    }

    @Test
    public void findAllValuesTest() {
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(2));
        ArrayList<Node> res = new ArrayList<>();
        res.add(s_list.head.next);
        res.add(s_list.tail);
        assertEquals(res, s_list.findAll(2));
    }

    @Test
    public void listLengthTest() {
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(2));
        assertEquals(5, s_list.count());
    }

    @Test
    public void insertNodeTest() {
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(5));
        s_list.insertAfter(s_list.head.next, new Node(3));
    }

    @Test
    public void sumListTest() {
        LinkedList s_list1 = new LinkedList();
        LinkedList s_list2 = new LinkedList();
        s_list1.addInTail(new Node(1));
        s_list1.addInTail(new Node(2));
        s_list1.addInTail(new Node(3));
        s_list1.addInTail(new Node(4));
        s_list2.addInTail(new Node(1));
        s_list2.addInTail(new Node(2));
        s_list2.addInTail(new Node(3));
        s_list2.addInTail(new Node(4));
        List<Integer> res = new ArrayList<>();
        res.add(2); res.add(4); res.add(6); res.add(8);
        assertEquals(res, LinkedList.sumList(s_list1,s_list2));
    }
}