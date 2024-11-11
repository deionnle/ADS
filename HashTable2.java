import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class HashTable2 {
    public int size;
    public int step;
    private int count;
    public String[] slots;
    public List<Function<String, Integer>> hashFuns;
    private final Random rand;

    public HashTable2(int sz, int stp, List<Function<String, Integer>> hashFuns) {
        size = sz;
        step = stp;
        count = 0;
        slots = new String[size];
        rand = new Random();
        this.hashFuns = hashFuns;

        for (int i = 0; i < size; i++) {
            slots[i] = null;
        }
    }

    public int hashFun(String value) {
        int num = rand.nextInt(hashFuns.size());
        return hashFuns.get(num).apply(value);
    }

    public int seekSlot(String value) {
        int index = hashFun(value);
        int startIndex = index;

        while (slots[index] != null) {
            index = (index + step) % size;
            if (index == startIndex) {
                return -1;
            }
        }
        return index;
    }

    public int put(String value) {
        if (count == size) {
            resize();
        }
        int index = seekSlot(value);
        if (index != -1) {
            slots[index] = value;
            count++;
            return index;
        }
        return -1;
    }

    public int find(String value) {
        int index = hashFun(value);
        int startIndex = index;

        while (slots[index] != null) {
            if (slots[index].equals(value)) {
                return index;
            }
            index = (index + step) % size;
            if (index == startIndex) {
                return -1;
            }
        }
        return -1;
    }

    private void resize() {
        String[] oldSlots = slots;
        size *= 2;
        slots = new String[size];
        count = 0;

        for (String slot : oldSlots) {
            if (slot != null) {
                put(slot);
            }
        }
    }
}
