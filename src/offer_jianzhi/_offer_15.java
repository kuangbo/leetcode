package offer_jianzhi;

public class _offer_15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        if (n < 0)
            n = n & Integer.MIN_VALUE;
        while ((n = n >>> 1) != 0) {
            if ((n & 1) == 1)
                count++;
        }
        return count;
    }
}
