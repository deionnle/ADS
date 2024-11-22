import java.util.List;
import java.util.function.Function;

public class BloomFilter2 {
    private final int filter_len;
    private final int[] count;
    private final List<Function<String, Integer>> hashFunctions;

    public BloomFilter2 (int f_len, List<Function<String, Integer>> hashFunctions) {
        filter_len = f_len;
        count = new int[f_len];
        this.hashFunctions = hashFunctions;
    }

    public int hashFun(Function<String, Integer> hashFunction, String value) {
        return Math.abs(hashFunction.apply(value)) % filter_len;
    }

    public void add(String str1) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            count[hashFun(hashFunction, str1)]++;
        }
    }

    public void remove(String str1) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int index = hashFun(hashFunction, str1);
            if (count[index] > 0) {
                count[index]--;
            }
        }
    }

    public boolean isValue(String str1) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            if (count[hashFun(hashFunction, str1)] <= 0) {
                return false;
            }
        }
        return true;
    }
}
