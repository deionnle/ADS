import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NativeDictionaryTest {

    private NativeDictionary<Integer> dictionary = new NativeDictionary<>(17, Integer.class);

    @Test
    public void putTest() {
        dictionary.put("Andrey", 10);
        assertEquals(10, dictionary.get("Andrey"));

        dictionary.put("Andrey", 20);
        assertEquals(20, dictionary.get("Andrey"));
    }

    @Test
    public void IsKeyTest() {
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
}