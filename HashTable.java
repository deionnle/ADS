import java.util.HashMap;
import java.util.Random;

public class HashTable {
    public int size;
    public int step;
    private DynamicArrays slots;
    private HashMap<String, Integer> salts;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new DynamicArrays(size, this);
        salts = new HashMap<>();
    }

    public String generateSalt(String value) {
        Random rand = new Random();
        int salt = rand.nextInt(size);
        return salt + "_" + value;
    }

    public String getValue(String saltValue) {
        return saltValue.substring(saltValue.indexOf('_') + 1);
    }

    public int hashFun(String value) {
        int endIndex = value.indexOf('_');
        int hash = Integer.parseInt(value.substring(0, endIndex));
        for (int i = endIndex + 1; i < value.length(); i++) {
            hash = hash * 31 + value.charAt(i);
        }
        return Math.abs(hash % size);
    }

    public int seekSlot(String value) {
        int index = hashFun(value);
        int startIndex = index;

        while (slots.get(index) != null) {
            if (slots.get(index).equals(value)) {
                return index;
            }
            index = (index + step) % size;
            if (index == startIndex) {
                return -1;
            }
        }
        return index;
    }

    public int put(String value) {
        slots.check();
        String saltValue = generateSalt(value);
        int index = seekSlot(saltValue);
        if (index != -1) {
            slots.set(index, saltValue);
            salts.put(value, Integer.parseInt(saltValue.split("_")[0]));
            return index;
        }
        return -1;
    }

    public int find(String value) {
        Integer salt = salts.get(value);
        if (salt == null) {
            return -1;
        }

        String saltValue = salt + "_" + value;
        int index = seekSlot(saltValue);
        if (index == -1) {
            return -1;
        }

        if (getValue(slots.get(index)).equals(value)) {
            return index;
        }

        return -1;
    }
}

class DynamicArrays {
    private String[] array;
    private int size;
    private int count;
    private HashTable table;

    public DynamicArrays(int hashSize, HashTable table) {
        array = new String[hashSize];
        this.size = hashSize;
        count = 0;
        this.table = table;
    }

    public int getSize() {
        return size;
    }

    public String get(int index) {
        return array[index];
    }

    public void set(int index, String value) {
        if (array[index] == null && value != null) {
            count++;
        } else if (array[index] != null && value == null) {
            count--;
        }
        array[index] = value;
    }

    public void check() {
        if (count >= size * 0.8) {
            resize(size * 2);
        }
    }

    private void resize(int newSize) {
        String[] oldArray = array;
        size = newSize;
        array = new String[size];
        count = 0;

        table.size = newSize;

        for (String value : oldArray) {
            if (value != null) {
                int newIndex = table.seekSlot(value);
                array[newIndex] = value;
                count++;
            }
        }
    }
}
