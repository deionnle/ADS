public class PowerSet {
    private String[] slots;
    private int count;
    private int length;
    int step;

    public PowerSet() {
        this.length = 20000;
        this.slots = new String[length];
        this.count = 0;
        this.step = 3;
    }

    private int hashFun(String value) {
        return Math.abs(value.hashCode() % length);
    }

    public int size() {
        return count;
    }

    private void resize() {
        String[] oldSlots = slots;
        length *= 2;
        slots = new String[length];
        count = 0;
        for (String slot : oldSlots) {
            if (slot != null) {
                put(slot);
            }
        }
    }

    public void put(String value) {
        if (get(value)) {
            return;
        }
        int index = seekSlot(value);
        if (index != -1) {
            slots[index] = value;
            count++;
        } else {
            resize();
            put(value);
        }
    }

    private int seekSlot(String value) {
        int index = hashFun(value);
        int startIndex = index;

        while (slots[index] != null) {
            index = (index + step) % length;
            if (index == startIndex) {
                return -1;
            }
        }
        return index;
    }

    public boolean get(String value) {
        int index = hashFun(value);
        int startIndex = index;

        if (slots[index] == null) {
            return false;
        }

        while (slots[index] != null) {
            if (slots[index].equals(value)) {
                return true;
            }
            index = (index + step) % length;
            if (index == startIndex) {
                break;
            }
        }
        return false;
    }

    public boolean remove(String value) {
        int index = hashFun(value);
        if (slots[index] != null && slots[index].equals(value)) {
            slots[index] = null;
            count--;
            return true;
        }
        for (int i = 0; i < length; i++) {
            int probeIndex = (index + i) % length;
            if (slots[probeIndex] != null && slots[probeIndex].equals(value)) {
                slots[probeIndex] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet inter = new PowerSet();
        for (String element : slots) {
            if (element != null && set2.get(element)) {
                inter.put(element);
            }
        }
        return inter;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet uni = new PowerSet();
        for (String slot : slots) {
            if (slot != null) {
                uni.put(slot);
            }
        }
        for (String slot : set2.slots) {
            if (slot != null) {
                uni.put(slot);
            }
        }
        return uni;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet diff = new PowerSet();
        for (String slot : this.slots) {
            if (slot != null && !set2.get(slot)) {
                diff.put(slot);
            }
        }
        return diff;
    }

    public boolean isSubset(PowerSet set2) {
        if (this.size() == 0) {
            return true;
        }
        for (String slot : this.slots) {
            if (slot != null && !set2.get(slot)) {
                return false;
            }
        }
        return true;
    }
}



