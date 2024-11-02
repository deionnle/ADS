import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class PowerSetTest {

    private Random rand = new Random();

    @Test
    public void myTest() {
        PowerSet set = new PowerSet();
        for (int i = 0; i < 50000; i++) {
            set.put("item" + i);
        }
        assertEquals(50000, set.size());
        assertTrue(set.remove("item12345"));
        assertTrue(set.get("item34567"));
        assertFalse(set.get("item99999"));
        assertTrue(set.remove("item34567"));
        assertFalse(set.get("item34567"));
        assertFalse(set.remove("item12345"));
    }

    @Test
    public void putAndSizeTest() {
        PowerSet set = new PowerSet();
        set.put("uniqueItem");
        set.put("duplicateItem");
        set.put("duplicateItem");
        assertEquals(2, set.size());
        assertTrue(set.get("uniqueItem"));
        assertTrue(set.get("duplicateItem"));
        set.put("uniqueItem");
        assertEquals(2, set.size());
        assertTrue(set.remove("duplicateItem"));
        assertEquals(1, set.size());
    }

    @Test
    public void containsTest() {
        PowerSet set = new PowerSet();
        for (int i = 100; i < 10100; i += 100) {
            set.put("val" + i);
        }
        assertTrue(set.get("val1000"));
        assertFalse(set.get("val9999"));
        assertTrue(set.remove("val500"));
        assertFalse(set.get("val500"));
    }

    @Test
    public void removeAndCheckTest() {
        PowerSet set = new PowerSet();
        String item = "itemToRemove";
        set.put(item);
        assertTrue(set.remove(item));
        assertFalse(set.remove(item));
        assertFalse(set.get(item));
    }

    @Test
    public void intersectTest() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 0; i < 20; i++) {
            set1.put("value" + i);
        }
        for (int i = 10; i < 30; i++) {
            set2.put("value" + i);
        }
        PowerSet intersection = set1.intersection(set2);
        assertEquals(10, intersection.size());
    }

    @Test
    public void unionTest() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 1; i <= 50; i++) {
            set1.put("num" + i);
        }
        for (int i = 25; i <= 75; i++) {
            set2.put("num" + i);
        }
        PowerSet unionSet = set1.union(set2);
        assertEquals(75, unionSet.size());
    }

    @Test
    public void differenceTest() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 0; i < 5; i++) {
            set1.put("A" + i);
            set2.put("B" + i);
        }
        PowerSet differenceSet = set1.difference(set2);
        assertEquals(5, differenceSet.size());
    }

    @Test
    public void difference2Test() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 1; i <= 10; i++) {
            set1.put("key" + i);
        }
        for (int i = 5; i <= 15; i++) {
            set2.put("key" + i);
        }
        PowerSet differenceSet = set1.difference(set2);
        assertEquals(4, differenceSet.size());
    }

    @Test
    public void ExtraElementsTest() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 0; i < 30; i++) {
            set1.put("item" + i);
        }
        for (int i = 10; i < 20; i++) {
            set2.put("item" + i);
        }
        assertTrue(set1.isSubset(set2));
    }

    @Test
    public void noSubsetTest() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 0; i < 100; i++) {
            set1.put("element" + i);
        }
        for (int i = 50; i < 150; i++) {
            set2.put("element" + i);
        }
        assertFalse(set1.isSubset(set2));
    }

    @Test
    public void SubsetTest() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            set1.put("val" + i);
        }
        for (int i = 10000; i < 15000; i++) {
            set2.put("val" + i);
        }
        assertTrue(set1.isSubset(set2));
    }
}