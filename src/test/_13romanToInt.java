package test;

import java.util.Arrays;

class _13romanToInt {
    public static void main(String[] args) {
        String s = "DCXXI";
        System.out.println(new _13romanToInt().tomanToInt(s));
    }

    private int tomanToInt(String s) {
        int [] romans = new int[26];
        romans['I' - 'A'] = 1;
        romans['V' - 'A'] = 5;
        romans['X' - 'A'] = 10;
        romans['L' - 'A'] = 50;
        romans['C' - 'A'] = 100;
        romans['D' - 'A'] = 500;
        romans['M' - 'A'] = 1000;
        int res = 0;
        int pre = romans[s.charAt(0) - 'A'];
        for(int i = 1; i < s.length(); i++) {
            int cur = romans[s.charAt(i) - 'A'];
            if(pre < cur)
                res -= pre;
            else
                res += pre;
            pre = cur;
        }
        res += pre;
        return res;
    }
}
