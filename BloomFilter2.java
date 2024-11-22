public class BloomFilter2 {
    private final int filter_len;
    private final int[] count;

    public BloomFilter2 (int f_len) {
        filter_len = f_len;
        count = new int[f_len];
    }

    public int hash1(String str1) {
        int hash = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            hash = (hash * 17 + code) % filter_len;
        }
        return Math.abs(hash);
    }

    public int hash2(String str1) {
        int hash = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            hash = (hash * 223 + code) % filter_len;
        }
        return Math.abs(hash);
    }

    public void add(String str1) {
        count[hash1(str1)]++;
        count[hash2(str1)]++;
    }

    public void remove(String str1) {
        if (count[hash1(str1)] > 0) {
            count[hash1(str1)]--;
        }
        if (count[hash2(str1)] > 0) {
            count[hash2(str1)]--;
        }
    }

    public boolean isValue(String str1) {
        return count[hash1(str1)] > 0 && count[hash2(str1)] > 0;
    }
}
