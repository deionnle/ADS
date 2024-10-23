public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        int hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash += value.charAt(i);
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
        int index = seekSlot(value);
        if (index == -1) {
            return -1;
        }
        slots[index] = value;
        return index;
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
}



