import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircularQueueTest {

    @Test
    public void EnqueueAndDequeueTest() {
        CircularQueue<Integer> array = new CircularQueue<>(3);

        array.enqueue(1);
        array.enqueue(2);
        array.enqueue(3);
        assertTrue(array.isFull());
        array.dequeue();
        assertEquals(2, array.size());
    }

    @Test
    public void FullTest() {
        CircularQueue<Integer> array = new CircularQueue<>(3);

        array.enqueue(1);
        array.enqueue(2);
        array.enqueue(3);

        assertTrue(array.isFull());
        assertFalse(array.enqueue(4));
    }

    @Test
    public void DelTest() {
        CircularQueue<Integer> array = new CircularQueue<>(3);

        array.enqueue(1);
        array.enqueue(2);
        array.enqueue(3);

        array.dequeue();
        array.enqueue(4);

        assertEquals(2, array.dequeue());
        assertEquals(3, array.dequeue());
        assertEquals(4, array.dequeue());
    }

    @Test
    public void EmptyTest() {
        CircularQueue<Integer> array = new CircularQueue<>(3);

        array.enqueue(1);
        array.enqueue(2);
        array.enqueue(3);

        array.dequeue();
        array.dequeue();
        array.dequeue();

        assertEquals(0, array.size());
    }
}