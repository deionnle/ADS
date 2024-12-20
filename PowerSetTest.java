import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        String itemToRemove = "itemToRemove";
        String itemToKeep1 = "itemToKeep1";
        String itemToKeep2 = "itemToKeep2";
        set.put(itemToRemove);
        set.put(itemToKeep1);
        set.put(itemToKeep2);

        assertTrue(set.get(itemToRemove));
        assertTrue(set.get(itemToKeep1));
        assertTrue(set.get(itemToKeep2));
        assertEquals(3, set.size());

        assertTrue(set.remove(itemToRemove));
        assertFalse(set.get(itemToRemove));
        assertFalse(set.remove(itemToRemove));
        assertEquals(2, set.size());

        assertTrue(set.get(itemToKeep1));
        assertTrue(set.get(itemToKeep2));
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
        assertFalse(set2.isSubset(set1));
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


    @Test
    public void Subset2Test() {
        PowerSet setA = new PowerSet();
        PowerSet setB = new PowerSet();

        setA.put("set1");
        setA.put("set2");
        setA.put("set3");

        setB.put("set2");
        setB.put("set3");
        setB.put("set4");

        PowerSet differenceSet = setA.difference(setB);
        assertTrue(differenceSet.get("set1"));
        assertFalse(differenceSet.get("set2"));
        assertFalse(differenceSet.get("set3"));
        assertFalse(differenceSet.get("set4"));
        assertEquals(1, differenceSet.size());

        assertFalse(setA.isSubset(setB));
        assertFalse(setB.isSubset(setA));
    }

    @Test
    public void Subset3Test() {
        PowerSet setA = new PowerSet();
        PowerSet setB = new PowerSet();

        setA.put("set1");
        setA.put("set2");
        setA.put("set3");

        setB.put("set2");
        setB.put("set3");

        assertTrue(setA.isSubset(setB));
        assertFalse(setB.isSubset(setA));
    }

    @Test
    void EqualsTest() {
        PowerSet setA = new PowerSet();
        PowerSet setB = new PowerSet();

        setA.put("a");
        setA.put("b");
        setA.put("c");

        setB.put("a");
        setB.put("b");
        setB.put("c");

        assertTrue(setA.equals(setB));
    }

    @Test
    public void CartesianProductTest() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();

        set1.put("A");
        set1.put("B");
        set2.put("1");
        set2.put("2");

        PowerSet expected = new PowerSet();
        expected.put("(A, 1)");
        expected.put("(A, 2)");
        expected.put("(B, 1)");
        expected.put("(B, 2)");

        PowerSet result = set1.cartesianProduct(set2);
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void MultiIntersectionTest() {
        PowerSet set1 = new PowerSet();
        set1.put("a");set1.put("b");set1.put("c");

        PowerSet set2 = new PowerSet();
        set2.put("b");set2.put("c");set2.put("d");

        PowerSet set3 = new PowerSet();
        set3.put("c");set3.put("d");set3.put("e");

        List<PowerSet> sets = Arrays.asList(set1, set2, set3);

        PowerSet result = PowerSet.multiIntersection(sets);

        assertEquals(1, result.size());
        assertTrue(result.get("c"));
        assertFalse(result.get("b"));
        assertFalse(result.get("d"));
        assertFalse(result.get("a"));
    }
}