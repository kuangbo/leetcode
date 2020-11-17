package offer_jianzhi;

public class _offer_10_1 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(fib(5));
    }
    public static int fib(int n) {
        int f0 = 0;
        int f1 = 1;
        if (n == 0)
            return f0;
        if (n == 1)
            return f1;
        int f2 = f0 + f1;
        while(n > 1) {
            f2 = (f0 + f1) % (1000000007);
            f0 = f1;
            f1 = f2;
            --n;
        }
        return f2;
    }
}
