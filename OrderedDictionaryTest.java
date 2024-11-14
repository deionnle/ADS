import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderedDictionaryTest {

    private final OrderedDictionary<Integer> dictionary = new OrderedDictionary<>();

    @Test
    public void putTest() {
        dictionary.put("Andrey", 10);
        assertEquals(10, dictionary.get("Andrey"));

        dictionary.put("Andrey", 20);
        assertEquals(20, dictionary.get("Andrey"));
    }

    @Test
    public void isKeyTest() {
        dictionary.put("Olga", 30);
        assertTrue(dictionary.isKey("Olga"));
        assertFalse(dictionary.isKey("Ivan"));
    }

    @Test
    public void getTest() {
        dictionary.put("Alise", 40);
        assertEquals(40, dictionary.get("Alise"));
        assertNull(dictionary.get("Alex"));
    }

    @Test
    public void multipleInsertionsTest() {
        dictionary.put("Anna", 1);
        dictionary.put("Elena", 2);
        dictionary.put("Tanya", 3);

        assertEquals(1, dictionary.get("Anna"));
        assertEquals(2, dictionary.get("Elena"));
        assertEquals(3, dictionary.get("Tanya"));
    }

    @Test
    public void binarySearchTest() {
        dictionary.put("Key1", 1);
        dictionary.put("Key2", 2);
        dictionary.put("Key3", 3);

        assertEquals(0, dictionary.binarySearch("Key1"));
        assertEquals(1, dictionary.binarySearch("Key2"));
        assertEquals(2, dictionary.binarySearch("Key3"));

        assertEquals(-1, dictionary.binarySearch("Key0"));
        assertEquals(-2, dictionary.binarySearch("Key1.5"));
        assertEquals(-4, dictionary.binarySearch("Key4"));
    }
}
