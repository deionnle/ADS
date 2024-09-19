import java.lang.reflect.Array;

public class DynArrayBanking<T> {
    public T [] array;
    public int count;
    public int capacity;
    public int credits;
    public boolean flag;
    Class clazz;

    public DynArrayBanking(Class clz) {
        clazz = clz;
        count = 0;
        credits = 0;
        flag = false;
        makeArrayBanking(16);
    }

    public void makeArrayBanking(int new_capacity) {
        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
        if (array != null) {
            System.arraycopy(array,0,newArray,0,count);
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
            int newCredits = capacity * 3;

            if (credits >= newCredits) {
                makeArrayBanking(capacity * 2);
                credits -= newCredits;
                flag = false;
            } else {
                flag = true;
            }
        }
        if (!flag) {
            array[count++] = itm;
        }
        credits += 3;
    }

    public void insertBanking(T itm, int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (count == capacity) {
            int newCredits = capacity * 3;

            if (credits >= newCredits) {
                makeArrayBanking(capacity * 2);
                credits -= newCredits;
                flag = false;
            } else {
                flag = true;
            }
        }
        if (!flag) {
            System.arraycopy(array, index, array, index + 1, count - index);
            array[index] = itm;
            count++;
        }
        credits += 3;
    }

    public void removeBanking(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array,index + 1, array, index, count - index - 1);
        count--;
        array[count] = null;
        //
        credits += 3;
        if (count <= capacity / 2 && capacity > 16) {
            int new_capacity = (int) (capacity / 1.5);
            new_capacity = Math.max(new_capacity, 16);
            int newCredits = count * 3;

            if (credits >= newCredits) {
                makeArrayBanking(new_capacity);
                credits -= newCredits;
            }
        }
    }
}


