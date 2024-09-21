import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class QueueTest {

    @Test
    public void referenceTest() {
        Queue queue = new Queue<>();
        for (int i = 0; i < 16; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        queue.dequeue();
        assertEquals(14,queue.size());
    }

    @Test
    public void turnTest() {
        Queue queue = new Queue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.turn(9);
    }
}