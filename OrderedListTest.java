import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class OrderedListTest {

    private Random rand = new Random();

    @Test
    public void ascTest() {
        OrderedList orderedList = new OrderedList(true);
        for (int i = 0; i < 10; i++) {
            orderedList.add(rand.nextInt(50) + 1);
        }
        assertEquals(10,orderedList.count());
    }

    @Test
    public void descTest() {
        OrderedList orderedList = new OrderedList(false);
        for (int i = 0; i < 10; i++) {
            orderedList.add(rand.nextInt(50) + 1);
        }
        assertEquals(orderedList.find(1),orderedList.find(1));
    }

    @Test
    public void clearTest() {
        OrderedList orderedList = new OrderedList<>(true);
        for (int i = 0; i < 10; i++) {
            orderedList.add(rand.nextInt(50) + 1);
        }
        orderedList.clear(true);
        assertEquals(0,orderedList.count());
    }

    @Test
    public void delete1Test() {
        OrderedList orderedList = new OrderedList<>(true);
        for (int i = 10; i > 0; i--) {
            orderedList.add(i);
        }
        orderedList.delete(2);
        orderedList.delete(4);
        orderedList.delete(8);
        assertEquals(null,orderedList.find(2));
        assertEquals(null,orderedList.find(4));
        assertEquals(null,orderedList.find(8));
    }

    @Test
    public void delete2Test() {
        OrderedList orderedList = new OrderedList<>(false);
        for (int i = 0; i < 10; i++) {
            orderedList.add(i);
        }
        orderedList.delete(4);
        orderedList.delete(8);
        assertEquals(null,orderedList.find(4));
        assertEquals(null,orderedList.find(8));
    }

    @Test
    public void deleteOneTest() {
        OrderedList orderedList = new OrderedList<>(false);
        for (int i = 10; i > 0; i--) {
            orderedList.add(i);
        }
        orderedList.add(5);
        orderedList.add(5);
        orderedList.delete(5);
    }

    @Test
    public void find1Test() {
        OrderedList orderedList = new OrderedList<>(false);
        for (int i = 0; i < 10; i++) {
            orderedList.add(i);
        }
        assertEquals(null,(orderedList.find(12)));
    }
    @Test
    public void find2Test() {
        OrderedList orderedList = new OrderedList<>(true);
        for (int i = 0; i < 10; i++) {
            orderedList.add(i);
        }
        assertEquals(null,(orderedList.find(10)));
    }

    @Test
    public void RemoveDuplicatesTest() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(1); list.add(2); list.add(2); list.add(3);
        list.add(3); list.add(3); list.add(3);
        list.add(4);

        list.removeDuplicates();

        assertEquals(4, list.count());
        assertEquals(1, list.head.value);
        assertEquals(4, list.tail.value);

        assertEquals(1, list.head.value);
        assertEquals(2, list.head.next.value);
        assertEquals(3, list.head.next.next.value);
        assertEquals(4, list.head.next.next.next.value);
    }

    @Test
    public void MergeAscendingTest() {
        OrderedList<Integer> list1 = new OrderedList<>(true);
        OrderedList<Integer> list2 = new OrderedList<>(true);

        list1.add(1);list1.add(3);list1.add(5);
        list2.add(2);list2.add(4);list2.add(6);

        OrderedList<Integer> mergedList = OrderedList.merge(list1, list2, true);
        Integer[] expected = {1, 2, 3, 4, 5, 6};

        Node<Integer> mergedNode = mergedList.head;
        for (int i = 0; i < expected.length; i++) {
            assertNotNull(mergedNode);
            assertEquals(expected[i], mergedNode.value);
            mergedNode = mergedNode.next;
        }
        assertNull(mergedNode);
    }

    @Test
    public void MergeDescendingTest() {
        OrderedList<Integer> list1 = new OrderedList<>(false);
        OrderedList<Integer> list2 = new OrderedList<>(false);

        list1.add(5);list1.add(3);list1.add(1);
        list2.add(6);list2.add(4);list2.add(2);

        OrderedList<Integer> mergedList = OrderedList.merge(list1, list2, false);
        Integer[] expected = {6, 5, 4, 3, 2, 1};

        ArrayList<Node<Integer>> mergedNodes = mergedList.getAll();

        assertEquals(expected.length, mergedNodes.size());

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], mergedNodes.get(i).value);
        }
    }

    @Test
    void SubListTest() {
        OrderedList<Integer> List = new OrderedList<>(true);
        OrderedList<Integer> subList = new OrderedList<>(true);

        List.add(1);List.add(2);List.add(3);List.add(4);

        subList.add(1);
        subList.add(2);
        assertTrue(List.SubList(subList));

        subList.clear(true);

        subList.add(3);
        subList.add(4);
        assertTrue(List.SubList(subList));

        subList.clear(true);
        assertTrue(List.SubList(subList));

        subList.add(2);
        subList.add(4);

        assertFalse(List.SubList(subList));

        List.clear(true);
        assertFalse(List.SubList(subList));
    }

    @Test
    public void FrequentTest() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(3);
        assertEquals(3, list.findFrequentValue());
    }

    @Test
    public void FindIndexTest() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(3);
        list.add(2);
        list.add(1);
        assertEquals(1, list.findIndex(2));
        assertEquals(-1, list.findIndex(4));
    }

    @Test
    public void testDeleteFromEmptyList() {
        OrderedList<Integer> list5 = new OrderedList<>(true);
        list5.delete(1);
        assertNull(list5.head);
    }

    @Test
    public void testDeleteOnlyNode() {
        OrderedList<Integer> list5 = new OrderedList<>(true);
        list5.add(1);
        list5.delete(1);
        assertNull(list5.head);
        assertNull(list5.tail);
    }

    @Test
    public void testDeleteHead() {
        OrderedList<Integer> list5 = new OrderedList<>(true);
        list5.add(1);
        list5.add(2);
        list5.add(3);
        list5.add(4);

        list5.delete(1);
        assertEquals(2, (int) list5.head.value);
        assertEquals(3, (int) list5.head.next.value);
        assertEquals(4, (int) list5.tail.value);
    }

    @Test
    public void testDeleteTail() {
        OrderedList<Integer> list5 = new OrderedList<>(true);
        list5.add(1);
        list5.add(2);
        list5.add(3);
        list5.add(4);

        list5.delete(4);
        assertEquals(3, (int) list5.tail.value);
        assertNull(list5.tail.next);
    }

    @Test
    public void delTest() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.delete(3);

        assertEquals(3, list.count());

        assertEquals(2, list.head.next.value);
        assertEquals(4, list.head.next.next.value);
        assertNull(list.head.next.next.next);
    }

    @Test
    public void OneDuplicatesTest() {
        OrderedList<Integer> list = new OrderedList<>(true);

        list.add(5);
        list.add(5);
        list.add(5);

        list.removeDuplicates();
        assertEquals(1, list.count());
    }

    @Test
    public void NoDuplicatesTest() {
        OrderedList<Integer> list = new OrderedList<>(true);

        list.add(1);
        list.add(2);
        list.add(3);

        list.removeDuplicates();

        assertEquals(3, list.count());
    }
}