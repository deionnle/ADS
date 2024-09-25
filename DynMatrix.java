public class DynMatrix<T> {
    private DynArray<Object> rootArray;

    public DynMatrix() {
        rootArray = new DynArray<>(Object.class);
    }

    public void set(T itm, int... numbers) {
        DynArray<Object> currentArray = rootArray;

        for (int i = 0; i < numbers.length - 1; i ++) {
            int index = numbers[i];
            if (index < currentArray.count) {
                currentArray = (DynArray<Object>) currentArray.getItem(index);
                continue;
            }
            for (int j = currentArray.count; j <= index; j ++) {
                currentArray.append(new DynArray<>(Object.class));
            }
            currentArray = (DynArray<Object>) currentArray.getItem(index);
        }
        int lastIndex = numbers[numbers.length - 1];
        for (int j = currentArray.count; j <= lastIndex; j ++) {
            currentArray.append(null);
        }
        currentArray.array[lastIndex] = itm;
    }

    public T get(int... numbers) {
        DynArray<Object> currentArray = rootArray;

        for (int i = 0; i < numbers.length - 1; i++) {
            int index = numbers[i];

            if (index >= currentArray.count) {
            throw new IndexOutOfBoundsException("Invalid index");
            }
            currentArray = (DynArray<Object>) currentArray.getItem(index);
        }

        int lastIndex = numbers[numbers.length - 1];
        if (lastIndex >= currentArray.count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        return (T) currentArray.getItem(lastIndex);
    }

    public void remove(int... numbers) {
        if (numbers.length == 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        DynArray<Object> currentArray = rootArray;

        for (int i = 0; i < numbers.length - 1; i++) {
            int index = numbers[i];

            if (index >= currentArray.count) {
                throw new IndexOutOfBoundsException("Invalid index");
            }

             currentArray = (DynArray<Object>) currentArray.getItem(index);
        }

        int lastIndex = numbers[numbers.length - 1];
        if (lastIndex >= currentArray.count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        currentArray.remove(lastIndex);
    }
}


