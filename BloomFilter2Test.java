import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloomFilter2Test {

    @Test
    public void AddTest() {
        BloomFilter2 filter = new BloomFilter2(32);

        filter.add("string1");
        filter.add("string2");

        assertTrue(filter.isValue("string1"));
        assertTrue(filter.isValue("string2"));

        assertFalse(filter.isValue("string3"));
    }

    @Test
    public void RemoveTest() {
        BloomFilter2 filter = new BloomFilter2(32);

        filter.add("string1");
        assertTrue(filter.isValue("string1"));

        filter.remove("string1");
        assertFalse(filter.isValue("string1"));

        filter.remove("string2");
        assertFalse(filter.isValue("string2"));
    }

    @Test
    public void AddAndRemoveTest() {
        BloomFilter2 filter = new BloomFilter2(32);

        filter.add("string1");
        filter.add("string1");
        filter.add("string1");

        assertTrue(filter.isValue("string1"));
        filter.remove("string1");
        assertTrue(filter.isValue("string1"));
        filter.remove("string1");
        assertTrue(filter.isValue("string1"));
        filter.remove("string1");
        assertFalse(filter.isValue("string1"));
    }
}