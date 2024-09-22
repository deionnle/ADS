import java.lang.reflect.Array;

public class DynArrayBanking<T> {
    public T[] array;
    public int count;
    public int capacity;
    public int credits;
    Class<T> clazz;

    public DynArrayBanking(Class<T> clz) {
        clazz = clz;
        count = 0;
        credits = 0;
        makeArrayBanking(16);
    }

    public void makeArrayBanking(int new_capacity) {
        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
        if (array != null) {
            System.arraycopy(array,0,newArray,0,count);
            credits -= count;
        }
        array = newArray;
        capacity = new_capacity;
    }

    public T getItemBanking(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void appendBanking(T itm) {
        if (count == capacity) {
            if (credits < count) {
                throw new IllegalStateException();
            }
            makeArrayBanking(capacity * 2);
        }
        array[count++] = itm;
        credits += 2;
    }

    public void insertBanking(T itm, int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (count == capacity) {
            if (credits < count) {
                throw new IllegalStateException();
            }
            makeArrayBanking(capacity * 2);
        }
        System.arraycopy(array, index, array, index + 1, count - index);
        array[index] = itm;
        count++;
        credits += 2;
    }

    public void removeBanking(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array, index + 1, array, index, count - index - 1);
        count--;
        array[count] = null;
        credits += 1;

        if (count >= capacity / 2 || capacity <= 16) return;
        int new_capacity = (int) (capacity / 1.5);
        if (new_capacity < 16) {
            new_capacity = 16;
        }
        makeArrayBanking(new_capacity);
    }
}


