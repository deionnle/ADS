import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedList2Test {

    @Test
    public void removeOneValueTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(5));
        assertEquals(true,s_list.remove(5));
    }

    @Test
    public void removeHeadTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        assertEquals(true,s_list.remove(1));
    }

    @Test
    public void removeTailTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        assertEquals(true,s_list.remove(2));
    }


    @Test
    public void removeAllValuesTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(13));
        s_list.addInTail(new Node(5));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(1));
        s_list.removeAll(3);
        ArrayList<Node> nodes = new ArrayList<>();
        assertEquals(nodes,s_list.findAll(3));
    }

        @Test
    public void insertNodeTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(5));
        s_list.insertAfter(s_list.head.next, new Node(3));
    }

    @Test
    public void insertBeginTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.insertAfter(null, new Node(5));
    }

    @Test
    public void insertBackTest() {
        LinkedList2 s_list = new LinkedList2();
        Node nod = new Node(6);
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(5));
        s_list.addInTail(nod);
        s_list.insertAfter(nod,new Node(7));
    }

    @Test
    public void clearListTest() {
        LinkedList2 s_list = new LinkedList2();
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
        LinkedList2 s_list = new LinkedList2();
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
}