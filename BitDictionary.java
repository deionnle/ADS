import java.lang.reflect.Array;

public class BitDictionary<T> {
    public int size;
    public int[] keys;
    public T[] values;
    private int emptyKey = -1;

    public BitDictionary(int sz, Class<T> clazz) {
        size = sz;
        keys = new int[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        for (int i = 0; i < size; i++) {
            keys[i] = emptyKey;
        }
    }

    public int hashFun(int key) {
        return (key & 0x7FFFFFFF) % size;
    }

    public boolean isKey(int key) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            int startIndex = (index + i) % size;
            if (keys[startIndex] == emptyKey) break;
            if (keys[startIndex] == key) return true;
        }
        return false;
    }

    public void put(int key, T value) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            int startIndex = (index + i) % size;
            if (keys[startIndex] == emptyKey || keys[startIndex] == key) {
                keys[startIndex] = key;
                values[startIndex] = value;
                return;
            }
        }
    }

    public T get(int key) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            int startIndex = (index + i) % size;
            if (keys[startIndex] == emptyKey) break;
            if (keys[startIndex] == key) return values[startIndex];
        }
        return null;
    }

    public void remove(int key) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            int startIndex = (index + i) % size;
            if (keys[startIndex] == emptyKey) break;
            if (keys[startIndex] == key) {
                keys[startIndex] = emptyKey;
                values[startIndex] = null;
                return;
            }
        }
    }
}
