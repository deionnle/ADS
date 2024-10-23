import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

        private HashTable table = new HashTable(17, 3);

        @Test
        public void HashFunTest() {
            table.put("One");
            table.put("Two");
            table.put("Three");
            table.put("Four");
            table.put("Five");
            table.put("Six");
            assertEquals(table.hashFun("Five"), table.find("Five"));
        }

        @Test
        public void SeekSlotTest() {
            table.put("hello");
            table.put("world");
            table.put("hash");
            table.put("map");

            int newSlot = table.seekSlot("test");
            assertTrue(newSlot >= 0 && newSlot < table.size);
        }

        @Test
        public void PutTest() {
            int slot = table.put("hello");
            assertEquals("hello", table.slots[slot]);
            assertEquals(slot, table.find("hello"));
            int slot2 = table.put("world");
            assertEquals("world", table.slots[slot2]);

            table.put("hello");
            assertNotEquals(-1, slot);
        }

        @Test
        public void FindTest() {
            table.put("hello");
            table.put("world");

            int foundSlot = table.find("hello");
            assertEquals("hello", table.slots[foundSlot]);

            int notFound = table.find("five");
            assertEquals(-1, notFound);

            table.put("java");
            int foundSlot2 = table.find("java");
            assertEquals("java", table.slots[foundSlot2]);
        }
    }
