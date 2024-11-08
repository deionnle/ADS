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
}