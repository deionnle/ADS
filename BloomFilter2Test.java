import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloomFilter2Test {

    private BloomFilter2 filter;
    private final int filter_len = 32;

    @BeforeEach
    public void func() {
        List<Function<String, Integer>> hashFunctions = new ArrayList<>();

        hashFunctions.add(str -> {
            int hash = 0;
            for (int i = 0; i < str.length(); i++) {
                int code = str.charAt(i);
                hash = (hash * 17 + code) % filter_len;
            }
            return Math.abs(hash);
        });

        hashFunctions.add(str -> {
            int hash = 0;
            for (int i = 0; i < str.length(); i++) {
                int code = str.charAt(i);
                hash = (hash * 223 + code) % filter_len;
            }
            return Math.abs(hash);
        });

        filter = new BloomFilter2(filter_len, hashFunctions);
    }

    @Test
    public void AddTest() {
        filter.add("string1");
        filter.add("string2");

        assertTrue(filter.isValue("string1"));
        assertTrue(filter.isValue("string2"));

        assertFalse(filter.isValue("string3"));
    }

    @Test
    public void RemoveTest() {
        filter.add("string1");
        assertTrue(filter.isValue("string1"));

        filter.remove("string1");
        assertFalse(filter.isValue("string1"));

        filter.remove("string2");
        assertFalse(filter.isValue("string2"));
    }

    @Test
    public void AddAndRemoveTest() {
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