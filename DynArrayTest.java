import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynArrayTest {

    @Test
    public void myTest() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        for(int i = 0; i < 20; i ++) {
            arr.append(i * 2);
        }
        assertEquals(18, arr.getItem(9));
        assertEquals(32, arr.capacity);
    }

    @Test
    public void myTest2() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        for(int i = 0; i < 10; i ++) {
            arr.append(i * 2);
        }
        assertEquals(10, arr.getItem(5));
        assertEquals(16,arr.capacity);
    }

    @Test
    public void badIndexTest() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        for(int i = 0; i < 20; i ++) {
            arr.append(i);
        }
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> arr.insert(30,50));
        assertEquals("Invalid index", exception.getMessage());
    }

    @Test
    public void delNoChangeTest() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        for(int i = 0; i < 10; i ++) {
            arr.append(i * 2);
        }
        arr.remove(3);
        assertEquals(8, arr.getItem(3));
        assertEquals(16,arr.capacity);
    }

    @Test
    public void delNoChange2Test() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        for(int i = 0; i < 10; i ++) {
            arr.append(i * 2);
        }
        arr.remove(3);
        arr.remove(3);
        assertEquals(10, arr.getItem(3));
        assertEquals(16,arr.capacity);
    }

    @Test
    public void delChangeBufferTest() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        for(int i = 0; i < 33; i ++) {
            arr.append(i * 2);
        }
        arr.remove(3);
        arr.remove(3);
        assertEquals(10, arr.getItem(3));
        assertEquals(42,arr.capacity);
    }

    @Test
    public void delInvalidIndexTest() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        for(int i = 0; i < 15; i ++) {
            arr.append(i * 2);
        }
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> arr.remove(20));
        assertEquals("Invalid index", exception.getMessage());
    }
}