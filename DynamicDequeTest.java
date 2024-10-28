import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicDequeTest {

    @Test
    public void AddFrontTest() {
        DynamicDeque<Integer> array = new DynamicDeque<>();
        array.addFront(10);
        assertEquals(1, array.size());
        assertFalse(array.isEmpty());
    }

    @Test
    public void AddTailTest() {
        DynamicDeque<Integer> array = new DynamicDeque<>();
        array.addTail(20);
        assertEquals(1,array.size());
        assertFalse(array.isEmpty());
    }

    @Test
    public void RemoveFrontTest() {
        DynamicDeque<Integer> array = new DynamicDeque<>();
        array.addTail(30);
        int removed = array.removeFront();
        assertEquals(30, removed);
        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
    }

    @Test
    public void RemoveTailTest() {
        DynamicDeque<Integer> array = new DynamicDeque<>();
        array.addFront(40);
        int removed = array.removeTail();
        assertEquals(40, removed);
        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
    }

    @Test
    public void SizeTest() {
        DynamicDeque<Integer> array = new DynamicDeque<>();
        array.addTail(50);
        array.addTail(60);
        assertEquals(2, array.size());
    }

    @Test
    public void IsEmptyTest() {
        DynamicDeque<Integer> array = new DynamicDeque<>();
        assertTrue(array.isEmpty());
        array.addFront(70);
        assertFalse(array.isEmpty());
    }

    @Test
    public void ResizeTest() {
        DynamicDeque<Integer> array = new DynamicDeque<>();
        for (int i = 0; i < 16; i++) {
            array.addTail(i);
        }
        assertEquals(16, array.size());
    }
}