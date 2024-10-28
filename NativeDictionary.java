import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
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
                return;
            }
        }
    }

    public T get(String key) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            int startIndex = (index + i) % size;
            if (slots[startIndex] == null) break;
            if (slots[startIndex].equals(key)) return values[startIndex];
        }
        return null;
    }
}