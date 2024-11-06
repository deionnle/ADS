import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTable2Test {

    private HashTable2 table = new HashTable2(17,3);

    @Test
    public void hashFun1Test() {
        String value1 = "One";
        String value2 = "Two";
        String value3 = "Three";

        int hash1 = table.hashFun1(value1);
        int hash2 = table.hashFun1(value2);
        int hash3 = table.hashFun1(value3);

        assertNotEquals(hash1, hash2);
        assertNotEquals(hash1, hash3);
        assertNotEquals(hash2, hash3);
    }

    @Test
    public void hashFun2Test() {
        String value1 = "One";
        String value2 = "Two";
        String value3 = "Three";

        int hash1 = table.hashFun2(value1);
        int hash2 = table.hashFun2(value2);
        int hash3 = table.hashFun2(value3);

        assertNotEquals(hash1, hash2);
        assertNotEquals(hash1, hash3);
        assertNotEquals(hash2, hash3);
    }

    @Test
    public void hashFunTest() {
        String value1 = "One";
        String value2 = "Two";
        String value3 = "Three";

        int hash1 = table.hashFun(value1, 0);
        int hash2 = table.hashFun(value2, 1);
        int hash3 = table.hashFun(value3, 2);

        assertEquals(hash1, table.hashFun1(value1));
        assertEquals(hash3, table.hashFun1(value3));
        assertEquals(hash2, table.hashFun2(value2));
    }

    @Test
    public void hashFunFullTest() {
        String value = "Test";

        int hash1 = table.hashFun(value, 0);
        int hash2 = table.hashFun(value, 2);
        assertEquals(hash1, hash2);

        int hash3 = table.hashFun(value, 1);
        int hash4 = table.hashFun(value, 3);
        assertEquals(hash3, hash4);
    }
}