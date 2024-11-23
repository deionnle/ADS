import java.util.HashSet;

public class BloomFilter
{
    public int filter_len;
    public int bitArray;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        bitArray = 0;
    }

    public int hash1(String str1)
    {
        int hash = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = str1.charAt(i);
            hash = (hash * 17 + code) % filter_len;
        }
        return Math.abs(hash);
    }
    public int hash2(String str1)
    {
        int hash = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            hash = (hash * 223 + code) % filter_len;
        }
        return Math.abs(hash);
    }

    public void add(String str1)
    {
        setBit(hash1(str1));
        setBit(hash2(str1));
    }

    public boolean isValue(String str1) {
        return bitSet(hash1(str1)) && bitSet(hash2(str1));
    }

    public void setBit(int i) {
        bitArray |= (1 << i);
    }

    public boolean bitSet(int i) {
        return (bitArray & (1 << i)) != 0;
    }

    public  BloomFilter merge(BloomFilter[] filters) {
        int filterLen = filters[0].filter_len;
        BloomFilter mergedFilter = new BloomFilter(filterLen);

        for (BloomFilter filter : filters) {
            mergedFilter.bitArray |= filter.bitArray;
        }
        return mergedFilter;
    }

    public static HashSet<String> recoverSet(BloomFilter filter, int maxLen, String abc) {
        HashSet<String> recoveredSet = new HashSet<>();

        HashSet<String> strings = generateStrings(maxLen, abc);
        for (String element : strings) {
            if (filter.isValue(element)) {
                recoveredSet.add(element);
            }
        }
//        System.out.println("Восстановленное множество: " + recoveredSet);
//        System.out.println(recoveredSet.size() + " Элементов");
        return recoveredSet;
    }

    public static HashSet<String> generateStrings(int maxLen, String abc) {
        HashSet<String> result = new HashSet<>();
        for (int len = 1; len <= maxLen; len++) {
            getCombinations("", len, abc, result);
        }
        return result;
    }

    private static void getCombinations(String prefix, int length, String abc, HashSet<String> result) {
        if (length == 0) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < abc.length(); i++) {
            getCombinations(prefix + abc.charAt(i), length - 1, abc, result);
        }
    }
}