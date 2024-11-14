import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BitDictionaryTest {
    private BitDictionary<String> dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new BitDictionary<>(10, String.class);
    }

    @Test
    void testPut() {
        dictionary.put(12345, "Value1");
        assertEquals("Value1", dictionary.get(12345));
    }

    @Test
    void testGet() {
        dictionary.put(67890, "Value2");
        assertNull(dictionary.get(11111));
    }

    @Test
    void testIsKey() {
        dictionary.put(54321, "Value3");
        assertTrue(dictionary.isKey(54321));
        assertFalse(dictionary.isKey(99999));
    }

    @Test
    void testRemove() {
        dictionary.put(13579, "Value4");
        dictionary.remove(13579);
        assertNull(dictionary.get(13579));
    }
}
