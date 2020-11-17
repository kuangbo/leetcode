package test;

class _9isPalindrome {
    private boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0))
            return false;
        if(x / 10 == 0)
            return true;
        int reverse = 0;
        while(x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
            System.out.println(x + "--" + reverse);
        }
        return x == reverse || (x == reverse / 10 && x != 0);
    }

    public static void main(String[] args) {
        int x = 1;
        System.out.println(new _9isPalindrome().isPalindrome(x));
//        System.out.println(x % 10);
//        System.out.println(x / (int)Math.pow(10, 4));
    }
}
