import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HashTable2Test {

    private HashTable2 table;
    private int size = 17;

    @Before
    public void func() {
        Function<String, Integer> hashFun1 = (String value) -> {
            int hash = 0;
            for (int i = 0; i < value.length(); i++) {
                hash += value.charAt(i);
            }
            return Math.abs(hash % size);
        };

        Function<String, Integer> hashFun2 = (String value) -> {
            int hash = 17;
            for (int i = 0; i < value.length(); i++) {
                hash = (hash * 31 + value.charAt(i));
            }
            return Math.abs(hash % size);
        };

        List<Function<String, Integer>> hashFun = Arrays.asList(hashFun1, hashFun2);

        table = new HashTable2(size, 3, hashFun);
    }

    @Test
    public void hashFun1Test() {
        String value1 = "One";
        String value2 = "Two";
        String value3 = "Three";

        int hash1 = table.hashFun(value1);
        int hash2 = table.hashFun(value2);
        int hash3 = table.hashFun(value3);

        assertNotEquals(hash1, hash2);
        assertNotEquals(hash1, hash3);
        assertNotEquals(hash2, hash3);
    }

    @Test
    public void hashFun2Test() {
        String value1 = "One";
        String value2 = "Two";
        String value3 = "Three";

        int hash1 = table.hashFun(value1);
        int hash2 = table.hashFun(value2);
        int hash3 = table.hashFun(value3);

        assertNotEquals(hash1, hash2);
        assertNotEquals(hash1, hash3);
        assertNotEquals(hash2, hash3);
    }

    @Test
    public void hashFunFullTest() {
        String value = "Test";

        int hash1 = table.hashFun(value);
        int hash2 = table.hashFun(value);

        assertNotEquals(hash1, hash2);
    }
}