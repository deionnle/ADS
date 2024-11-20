import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class BagSetTest {

    @Test
    public void testAdd() {
        BagSet bag = new BagSet();

        bag.add("apple");
        bag.add("banana");
        bag.add("apple");

        ArrayList<String> elements = bag.getElements();

        assertEquals(2, elements.size());
        assertTrue(elements.contains("apple: 2"));
        assertTrue(elements.contains("banana: 1"));
    }

    @Test
    public void testRemove() {
        BagSet bag = new BagSet();

        bag.add("apple");
        bag.add("banana");
        bag.add("apple");

        boolean removed = bag.remove("apple");
        assertTrue(removed);

        ArrayList<String> elements = bag.getElements();
        assertTrue(elements.contains("apple: 1"));
        assertTrue(elements.contains("banana: 1"));

        removed = bag.remove("apple");
        assertTrue(removed);

        elements = bag.getElements();
        assertFalse(elements.contains("apple: 1"));
    }
}