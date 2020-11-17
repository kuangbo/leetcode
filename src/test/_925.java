package test;

public class _925 {
    public boolean isLongPressedName(String name, String typed) {
        char[] chn = name.toCharArray();
        char[] cht = typed.toCharArray();
        if (name.length() > typed.length()) // 当typed字符串长度小于name的长度，直接返回false
            return false;
        int ni = 0;
        int ti = 0;
        while (ti < typed.length()) {   // 当typed字符串有剩余
            if (chn[ni] == cht[ti]) {   // 判断相等，两个索引++
                ni++;
                ti++;
                // 直接置name索引为name的最大长度
                if (ni == name.length())    // 避免name字符串已经遍历完毕，但是typed字符串还有剩余，导致数组越界的情况
                    ni = name.length() - 1;
            } else if (ti > 0 && cht[ti] == cht[ti - 1]) {
                ti++;
            } else {
                return false;
            }
        }
        // 避免typed字符串已经遍历完毕，但是name还没有遍历完的情况，这种情况应该返回false
        // 因此，在最后直接判断两个字符串的最后一位是否相等即可解决问题！
        return chn[name.length() - 1] == cht[typed.length() - 1];
    }
}
