import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DynArrayBankingTest {

    @Test
    public void myTest() {
        DynArrayBanking<Integer> arr = new DynArrayBanking<>(Integer.class);
        for(int i = 0; i < 20; i ++) {
            arr.appendBanking(i * 2);
        }
        assertEquals(18, arr.getItemBanking(9));
        assertEquals(32, arr.capacity);
    }

    @Test
    public void myTest2() {
        DynArrayBanking<Integer> arr = new DynArrayBanking<>(Integer.class);
        for(int i = 0; i < 10; i ++) {
            arr.appendBanking(i * 2);
        }
        assertEquals(10, arr.getItemBanking(5));
        assertEquals(16,arr.capacity);
    }

    @Test
    public void badIndexTest() {
        DynArrayBanking<Integer> arr = new DynArrayBanking<>(Integer.class);
        for(int i = 0; i < 20; i ++) {
            arr.appendBanking(i);
        }
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> arr.insertBanking(30,50));
        assertEquals("Invalid index", exception.getMessage());
    }

    @Test
    public void delNoChangeTest() {
        DynArrayBanking<Integer> arr = new DynArrayBanking<>(Integer.class);
        for(int i = 0; i < 10; i ++) {
            arr.appendBanking(i * 2);
        }
        arr.removeBanking(3);
        assertEquals(8, arr.getItemBanking(3));
        assertEquals(16,arr.capacity);
    }

    @Test
    public void delNoChange2Test() {
        DynArrayBanking<Integer> arr = new DynArrayBanking<>(Integer.class);
        for(int i = 0; i < 10; i ++) {
            arr.appendBanking(i * 2);
        }
        arr.removeBanking(3);
        arr.removeBanking(3);
        assertEquals(10, arr.getItemBanking(3));
        assertEquals(16,arr.capacity);
    }

    @Test
    public void delChangeBufferTest() {
        DynArrayBanking<Integer> arr = new DynArrayBanking<>(Integer.class);
        for(int i = 0; i < 33; i ++) {
            arr.appendBanking(i * 2);
        }
        arr.removeBanking(3);
        arr.removeBanking(3);
        assertEquals(10, arr.getItemBanking(3));
        assertEquals(32,arr.capacity);
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