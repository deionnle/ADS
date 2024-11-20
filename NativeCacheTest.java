import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NativeCacheTest {

    @Test
    public void testEvictionAndHits() {
        NativeCache<Integer> cache = new NativeCache<>(3, Integer.class);

        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        cache.get("A");
        cache.get("A");
        cache.get("B");

        cache.put("D", 4);

        assertNull(cache.get("C"));

        assertEquals(4, cache.get("D"));
    }

}