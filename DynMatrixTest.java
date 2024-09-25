import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynMatrixTest {

    @Test
    public void myTest() {
        DynMatrix<Integer> matrix = new DynMatrix<>();

        matrix.set(10, 0, 0);
        matrix.set(20, 0, 1);
        matrix.set(30, 1, 0);
        matrix.set(40, 2, 0);

        assertEquals((Integer) 10, matrix.get(0, 0));
        assertEquals((Integer) 20, matrix.get(0, 1));
    }

    @Test
    public void newArray() {
        DynMatrix<Integer> matrix = new DynMatrix<>();
        matrix.set(30, 2, 0);
        assertEquals((Integer) 30, matrix.get(2, 0));
    }

    @Test
    public void testRemoveElement() {
        DynMatrix<Integer> matrix = new DynMatrix<>();

        matrix.set(10, 0, 0);
        matrix.set(20, 0, 1);
        matrix.set(30, 0, 2);

        matrix.remove(0, 1);

        assertEquals((Integer) 10, matrix.get(0, 0));
        assertEquals((Integer) 30, matrix.get(0, 1));

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> matrix.get(0, 2));
        assertEquals("Invalid index", exception.getMessage());
    }

    @Test
    public void referenceTest() {
        DynMatrix<Integer> matrix = new DynMatrix<>();

        matrix.set(100, 3, 4, 5);
        Integer value = matrix.get(3, 4, 5);
        assertEquals(Integer.valueOf(100), value);
    }
}