package test;

class _8myAtoi {
    private static int myAtoi(String str) {
        if (str.equals(""))
            return 0;
        char[] c = str.toCharArray();
        int lenc = c.length;
        int foot = 0;
        int sign = 1;
        long res = 0;
        while (foot < lenc && c[foot] == ' ') {
            foot++;
        }
        if(foot < lenc && c[foot] == '+') {
            foot++;
        } else if (foot < lenc && c[foot] == '-') {
            foot ++;
            sign = -1;
        }
        while (foot < lenc && c[foot] >= '0' && c[foot] <= '9') {
            if (res != (int) res) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + c[foot++] - '0';
        }
        if (res != (int) res) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) (sign*res);
    }

    public static void main(String[] args) {
        String str = "  -  41";
        System.out.println(myAtoi(str));
    }
}
