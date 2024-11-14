import java.util.ArrayList;

public class OrderedDictionary<T> {
    private final ArrayList<String> keys;
    private final ArrayList<T> values;

    public OrderedDictionary() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    public int binarySearch(String key) {
        int left = 0, right = keys.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = keys.get(mid).compareTo(key);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -(left + 1);
    }

    public boolean isKey(String key) {
        int index = binarySearch(key);
        return index >= 0;
    }

    public void put(String key, T value) {
        int index = binarySearch(key);
        if (index >= 0) {
            values.set(index, value);
        } else {
            keys.add(-index - 1, key);
            values.add(-index - 1, value);
        }
    }

    public T get(String key) {
        int index = binarySearch(key);
        if (index >= 0) return values.get(index);
        return null;
    }
}
