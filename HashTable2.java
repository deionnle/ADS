public class HashTable2 {
    public int size;
    public int step;
    private int count;
    public String[] slots;

    public HashTable2(int sz, int stp) {
        size = sz;
        step = stp;
        count = 0;
        slots = new String[size];
        for (int i = 0; i < size; i++) {
            slots[i] = null;
        }
    }

    public int hashFun1(String value) {
        int hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash += value.charAt(i);
        }
        return Math.abs(hash % size);
    }

    public int hashFun2(String value) {
        int hash = 17;
        for (int i = 0; i < value.length(); i++) {
            hash = (hash * 31 + value.charAt(i));
        }
        return Math.abs(hash % size);
    }

    public int hashFun(String value, int num) {
        if (num % 2 == 0) {
            return hashFun1(value);
        } else {
            return hashFun2(value);
        }
    }

    public int seekSlot(String value) {
        int index = hashFun(value, 0);
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
        int index = hashFun(value, 0);
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
