import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

        private HashTable table = new HashTable(17, 3);

//    @Test
//    public void HashFunTest() {
//        table.put("One");
//        table.put("Two");
//        table.put("Three");
//        table.put("Four");
//        table.put("Five");
//        table.put("Six");
//
//        assertEquals(table.hashFun("5_Five"), table.find("Five"));
//    }

    @Test
    public void SeekSlotTest() {
        table.put("hello");
        table.put("world");
        table.put("hash");
        table.put("map");

        String saltedTest = table.generateSalt("test");
        int newSlot = table.seekSlot(saltedTest);
        assertTrue(newSlot >= 0 && newSlot < table.size);
    }

    @Test
    public void PutTest() {
        int slot = table.put("hello");
        assertNotEquals(-1, slot);
        assertEquals(slot, table.find("hello"));

        int slot2 = table.put("world");
        assertNotEquals(-1, slot2);
        assertEquals(slot2, table.find("world"));

        int slot3 = table.put("hello");
        assertNotEquals(-1, slot3);
    }

    @Test
    public void FindTest() {
        table.put("hello");
        table.put("world");

        int foundSlot = table.find("hello");
        assertNotEquals(-1, foundSlot);
        assertEquals(foundSlot, table.find("hello"));

        int notFound = table.find("five");
        assertEquals(-1, notFound);

        int foundSlot2 = table.put("java");
        assertNotEquals(-1, table.find("java"));
        assertEquals(foundSlot2, table.find("java"));
    }


    @Test
    void Resize1Test() {
        HashTable hashTable = new HashTable(2, 1);

        hashTable.put("A");
        hashTable.put("B");

        assertEquals(2, hashTable.size);

        hashTable.put("C");
        assertEquals(4, hashTable.size);
    }

    @Test
    void Resize2Test() {
        HashTable hashTable = new HashTable(2, 1);

        assertEquals(2, hashTable.size);
        hashTable.put("A");
        hashTable.put("B");

        assertEquals(2, hashTable.size);
        assertNotEquals(-1, hashTable.find("A"));
        assertNotEquals(-1, hashTable.find("B"));
    }

    @Test
    void Resize3Test() {
        HashTable hashTable = new HashTable(4, 1);

        hashTable.put("A");
        hashTable.put("B");
        hashTable.put("C");
        hashTable.put("D");

        assertEquals(4, hashTable.size);

        hashTable.put("E");
        assertEquals(8, hashTable.size);
    }

//    @Test
//    public void Salt1Test() {
//        HashTable table = new HashTable(17, 3);
//
//        int hash1 = table.hashFun("AA");
//        int hash2 = table.hashFun("BB");
//        int hash3 = table.hashFun("CC");
//
//        assertNotEquals(hash1, hash2);
//        assertNotEquals(hash1, hash3);
//        assertNotEquals(hash2, hash3);
//    }

    @Test
    public void CollisionTest() {
        HashTable table = new HashTable(7, 1);

        int index1 = table.put("Key1");
        int index2 = table.put("Key2");
        int index3 = table.put("Key3");

        assertNotEquals(-1, index1);
        assertNotEquals(-1, index2);
        assertNotEquals(-1, index3);

        assertEquals(index1, table.find("Key1"));
        assertEquals(index2, table.find("Key2"));
        assertEquals(index3, table.find("Key3"));
    }

    @Test
    public void DDoSAttackTest() {
        HashTable table = new HashTable(11, 1);

        String[] Keys = {"AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ", "KK"};

        for (String key : Keys) {
            int index = table.put(key);
            assertNotEquals(-1, index);
            assertEquals(index, table.find(key));
        }
    }
}
