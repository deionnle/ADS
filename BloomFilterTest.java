import org.junit.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class BloomFilterTest {

    @Test
    public void testBloomFilter() {
        BloomFilter filter = new BloomFilter(32);

        String[] testStrings = {
                "0123456789", "1234567890", "2345678901", "3456789012", "4567890123",
                "5678901234", "6789012345", "7890123456", "8901234567", "9012345678"
        };

        for (String str : testStrings) {
            filter.add(str);
        }

        for (String str : testStrings) {
            assertTrue(filter.isValue(str));
        }

        assertFalse(filter.isValue("0000000000"));
        assertFalse(filter.isValue("9999999999"));
    }

    @Test
    public void MergeTest() {
        BloomFilter filter1 = new BloomFilter(32);
        filter1.add("string1");
        filter1.add("string2");

        BloomFilter filter2 = new BloomFilter(32);
        filter2.add("string3");
        filter2.add("string4");

        BloomFilter filter3 = new BloomFilter(32);
        filter2.add("string5");
        filter2.add("string6");

        BloomFilter[] filters = {filter1, filter2, filter3};

        BloomFilter mergedFilter = new BloomFilter(32);
        mergedFilter = mergedFilter.merge(filters);

        assertTrue(mergedFilter.isValue("string1"));
        assertTrue(mergedFilter.isValue("string2"));
        assertTrue(mergedFilter.isValue("string3"));
        assertTrue(mergedFilter.isValue("string4"));
        assertTrue(mergedFilter.isValue("string5"));
        assertTrue(mergedFilter.isValue("string6"));

        assertFalse(mergedFilter.isValue("string7"));
    }

    @Test
    public void RecoverSetTest() {
        BloomFilter filter = new BloomFilter(32);
        filter.add("string1");
        filter.add("string2");
        filter.add("string3");

        HashSet<String> original = new HashSet<>();
        original.add("string1");
        original.add("string2");
        original.add("string3");
        original.add("string4");
        original.add("string5");
        original.add("string6");

        HashSet<String> recovered = BloomFilter.recoverSet(filter, original);

        assertTrue(recovered.contains("string1"));
        assertTrue(recovered.contains("string2"));
        assertTrue(recovered.contains("string3"));

        assertFalse(recovered.contains("string4"));
        assertFalse(recovered.contains("string5"));
        assertFalse(recovered.contains("string6"));

        assertEquals(3, recovered.size());
    }
}