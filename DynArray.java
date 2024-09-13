import java.lang.reflect.Array;

public class DynArray<T> {
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
        if (array != null) {
            System.arraycopy(array,0,newArray,0,count);
        }
        array = newArray;
        capacity = new_capacity;
    }

    public T getItem(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void append(T itm) {
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        array[count++] = itm;
    }

    public void insert(T itm, int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        System.arraycopy(array,index, array,index + 1, count - index);
        array[index] = itm;
        count++;
    }

    public void remove(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array,index + 1, array, index, count - index - 1);
        count--;
        array[count] = null;
        if (count >= capacity / 2 || capacity <= 16) return;
        int new_capacity = (int) (capacity / 1.5);
        if (new_capacity < 16) {
            new_capacity = 16;
        }
        makeArray(new_capacity);
    }
}


