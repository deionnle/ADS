import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynMatrixTest {

    @Test
    public void myTest() {
        DynMatrix<Integer> matrix = new DynMatrix<>();

        matrix.set(0, 10);
        matrix.set(0, 20);
        matrix.set(1, 30);
        matrix.set(2, 40);

        assertEquals(10, matrix.get(0, 0));
        assertEquals(20, matrix.get(0, 1));
    }

    @Test
    public void newArray() {
        DynMatrix<Integer> matrix = new DynMatrix<>();
        matrix.set(2, 30);
        assertEquals(30, matrix.get(2, 0));
    }

    @Test
    public void testRemoveElement() {
        DynMatrix<Integer> matrix = new DynMatrix<>();

        matrix.set(0, 10);
        matrix.set(0, 20);
        matrix.set(0, 30);

        matrix.remove(0, 1);

        assertEquals(10, matrix.get(0, 0));
        assertEquals(30, matrix.get(0, 1));
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> matrix.get(0, 2));
        assertEquals("Invalid index", exception.getMessage());
    }
}