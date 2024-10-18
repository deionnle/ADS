import org.junit.jupiter.api.Test;
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
}