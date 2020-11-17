package test;

import java.util.Arrays;

public class _844 {
    public boolean backspaceCompare(String S, String T) {
        char[] chs = S.toCharArray();
        char[] cht = T.toCharArray();
        int sj = 0; // 第一个字符串的索引
        int sl = 0; // 第一个字符串处理'#'后剩余字符串
        int tj = 0;
        int tl = 0;

        while (sj < S.length()) {
            if (chs[sj] != '#') {   // 当前字符不是'#'，向后移动并存储
                chs[sl++] = chs[sj++];
            } else {    // 当前字符是'#'，字符串长度减1，删除当前的最后一个字符
                sl--;
                sj++;
                if(sl < 0)  // 避免'#'个数大于字符的个数
                    sl = 0;
            }
        }

        while (tj < T.length()) {
            if (cht[tj] != '#') {
                cht[tl++] = cht[tj++];
            } else {
                tl--;
                tj++;
                if(tl < 0)
                    tl = 0;
            }
        }
        return new String(chs).substring(0, sl).equals(new String(cht).substring(0, tl));
    }
}
