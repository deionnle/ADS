import java.util.Random;

public class HashTable
{
    public int size;
    public int step;
    private int count;
    public String [] slots;
    private int salt;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        count = 0;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;

        Random rand = new Random();
        salt = rand.nextInt(size);
    }

    public int hashFun(String value)
    {
        int hash = salt;
        for (int i = 0; i < value.length(); i++) {
            hash = hash * 31 + value.charAt(i);
        }
        return Math.abs(hash % size);
    }

    public int seekSlot(String value)
    {
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

    public int put(String value)
    {
        if (count == size) {
            resize();
        }
        int index = seekSlot(value);
        if (index != -1) {
            slots[index] = value;
            count ++;
            return index;
        }
        return -1;
    }

    public int find(String value)
    {
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



