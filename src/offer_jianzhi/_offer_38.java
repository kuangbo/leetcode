package offer_jianzhi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/14
 * Time: 下午3:02
 */
public class _offer_38 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.permutation("abc")));
    }
}

class Solution {
    List<String> res = new LinkedList<>();
    char[] ch;

    public String[] permutation(String s) {
        if (s.length() == 1)
            return new String[]{s};
        ch = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }

    public void dfs(int index) {
        if (index == ch.length - 1) {
            res.add(String.valueOf(ch));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < ch.length; i++) {
            if (set.contains(ch[i]))
                continue;
            set.add(ch[i]);
            swap(i, index);
            dfs(index + 1);
            swap(i, index);
        }
    }

    public void swap(int a, int b) {
        char tmp = ch[a];
        ch[a] = ch[b];
        ch[b] = tmp;
    }
}
