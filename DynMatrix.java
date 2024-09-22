public class DynMatrix<T> {
    private DynArray<DynArray<T>> rootArray;

    public DynMatrix() {
        rootArray = new DynArray<>(DynArray.class);
    }

    public void set(int subArrayIndex, T itm) {
        if (subArrayIndex >= rootArray.count) {
            for (int i = rootArray.count; i <= subArrayIndex; i++) {
                rootArray.append(new DynArray<>(Object.class));
            }
        }

        DynArray<T> subArray = rootArray.getItem(subArrayIndex);
        subArray.append(itm);
    }

    public T get(int subArrayIndex, int valueIndex) {
        if (subArrayIndex >= rootArray.count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        DynArray<T> subArray = rootArray.getItem(subArrayIndex);
        if (valueIndex >= subArray.count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        return subArray.getItem(valueIndex);
    }

    public void remove(int subArrayIndex, int valueIndex) {
        if (subArrayIndex >= rootArray.count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        DynArray<T> subArray = rootArray.getItem(subArrayIndex);
        if (valueIndex >= subArray.count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        subArray.remove(valueIndex);
    }
}


