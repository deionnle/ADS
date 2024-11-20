import java.lang.reflect.Array;

class NativeCache<T>
{
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;

    public NativeCache(int sz, Class<T> clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        hits = new int[size];
    }

    public int hashFun(String key) {
        return Math.abs(key.hashCode() % size);
    }

    public boolean isKey(String key) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            int startIndex = (index + i) % size;
            if (slots[startIndex] == null) break;
            if (slots[startIndex].equals(key)) return true;
        }
        return false;
    }

    public void put(String key, T value) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            int startIndex = (index + i) % size;
            if (slots[startIndex] == null || slots[startIndex].equals(key)) {
                slots[startIndex] = key;
                values[startIndex] = value;
                hits[startIndex] = 0;
                return;
            }
        }
        evict(key, value);
    }

    public T get(String key) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            int startIndex = (index + i) % size;
            if (slots[startIndex] == null) break;
            if (slots[startIndex].equals(key)) {
                hits[startIndex]++;
                return values[startIndex];
            }
        }
        return null;
    }

    private void evict(String key, T value) {
        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (hits[i] < hits[minIndex]) {
                minIndex = i;
            }
        }
        slots[minIndex] = key;
        values[minIndex] = value;
        hits[minIndex] = 0;
    }
}
