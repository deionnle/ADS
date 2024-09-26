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
}