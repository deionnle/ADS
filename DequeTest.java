import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {

    @Test
    public void addFrontTest() {
        Deque<String> deque = new Deque<>();
        deque.addFront("hello");
        assertEquals(1, deque.size());
        assertEquals("[hello]", deque.checkDeque());
    }

    @Test
    public void addTailTest() {
        Deque<String> deque = new Deque<>();
        deque.addTail("bye");
        assertEquals(1, deque.size());
        assertEquals("[bye]", deque.checkDeque());
    }

    @Test
    public void removeFrontTest() {
        Deque<String> deque = new Deque<>();
        deque.addFront("hello");
        deque.addFront("bye");
        assertEquals("bye", deque.removeFront());
        assertEquals(1, deque.size());
        assertEquals("[hello]", deque.checkDeque());
    }

    @Test
    public void removeTailTest() {
        Deque<String> deque = new Deque<>();
        deque.addTail("hello");
        deque.addTail("bye");
        assertEquals("bye", deque.removeTail());
        assertEquals(1, deque.size());
        assertEquals("[hello]", deque.checkDeque());
    }

    @Test
    public void palindromeTest() {
        Deque<String> deque = new Deque<>();
        assertTrue(deque.palindrome("шалаш"));
        assertTrue(deque.palindrome("аааоааа"));
        assertTrue(deque.palindrome("а"));
        assertFalse(deque.palindrome("привет"));
    }

    @Test
    public void AddFrontMinTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(3);
        assertEquals(1, deque.size());
        assertEquals(3, deque.getMin());

        deque.addFront(5);
        assertEquals(2, deque.size());
        assertEquals(3, deque.getMin());

        deque.addFront(1);
        assertEquals(3, deque.size());
        assertEquals(1, deque.getMin());
    }

    @Test
    public void AddTailMinTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(4);
        assertEquals(1, deque.size());
        assertEquals(4, deque.getMin());

        deque.addTail(2);
        assertEquals(2, deque.size());
        assertEquals(2, deque.getMin());

        deque.addTail(6);
        assertEquals(3, deque.size());
        assertEquals(2, deque.getMin());
    }

    @Test
    public void RemoveFrontMinTest() {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(3);
        deque.addFront(1);
        deque.addFront(5);
        assertEquals(1, deque.getMin());

        deque.removeFront();
        assertEquals(2, deque.size());
        assertEquals(1, deque.getMin());

        deque.removeFront();
        assertEquals(1, deque.size());
        assertEquals(3, deque.getMin());
    }

    @Test
    public void testRemoveTail() {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(3);
        deque.addTail(1);
        deque.addTail(5);
        assertEquals(1, deque.getMin());

        deque.removeTail();
        assertEquals(2, deque.size());
        assertEquals(1, deque.getMin());

        deque.removeTail();
        assertEquals(1, deque.size());
        assertEquals(3, deque.getMin());
    }

    @Test
    public void balanceTest() {
        assertTrue(Deque.balance("{[()]}"));
        assertTrue(Deque.balance("[{}()]"));
        assertFalse(Deque.balance("{[(])}"));
        assertFalse(Deque.balance("((()"));
        assertTrue(Deque.balance(""));
    }
}