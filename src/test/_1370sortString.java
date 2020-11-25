package test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/25
 * Time: 下午7:53
 */
public class _1370sortString {
    public static void main(String[] args) {
        System.out.println(sortString("leetcode"));
    }

    public static String sortString(String s) {
        if (s.length() == 0)
            return "";
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        for (char c : ch) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < ch.length) {
            for (char c : map.keySet()) {
                if (map.get(c) > 0) {
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                }
            }
            StringBuilder temp = new StringBuilder();
            for (char c : map.keySet()) {
                if (map.get(c) > 0) {
                    temp.append(c);
                    map.put(c, map.get(c) - 1);
                }
            }
            sb.append(temp.reverse().toString());
        }
        return sb.toString();
    }
}
