import org.junit.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListDummyTest {

    @Test
    public void removeOneValueTest(){
        LinkedListDummy s_list = new LinkedListDummy();
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(3));
        assertEquals(true,s_list.remove(3));
    }

    @Test
    public void findTest() {
        LinkedListDummy s_list = new LinkedListDummy();
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(20));
        assertEquals(20, s_list.find(20).value);
    }

    @Test
    public void findAllTest() {
        LinkedListDummy s_list = new LinkedListDummy();
        s_list.addInTail(new Node(15));
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(15));
        ArrayList<Node> res = s_list.findAll(15);
        assertEquals(2, res.size());
    }

    @Test
    public void removeAllTest() {
        LinkedListDummy s_list = new LinkedListDummy();
        s_list.addInTail(new Node(5));
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(5));
        s_list.removeAll(5);
        assertEquals(null, s_list.find(5));
    }

    @Test
    public void clearTest() {
        LinkedListDummy s_list = new LinkedListDummy();
        s_list.addInTail(new Node(5));
        s_list.addInTail(new Node(10));
        s_list.clear();
        assertEquals(0, s_list.count());
    }

    @Test
    public void countTest() {
        LinkedListDummy s_list = new LinkedListDummy();
        s_list.addInTail(new Node(7));
        s_list.addInTail(new Node(8));
        assertEquals(2, s_list.count());
    }
}