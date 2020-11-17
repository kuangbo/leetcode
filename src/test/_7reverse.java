package test;

class _7reverse {
    private static int reverse(int x) {
        long a = 0;
        while (x != 0) {
            a = a * 10 + x % 10;
            x /= 10;
        }
        return (a < Integer.MIN_VALUE || a > Integer.MAX_VALUE) ? 0 : (int) a;
    }

    public static void main(String[] args) {
        int x = -347483648;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(x));
    }
}
