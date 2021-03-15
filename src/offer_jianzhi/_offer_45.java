package offer_jianzhi;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/14
 * Time: 下午5:37
 */
public class _offer_45 {
    public static void main(String[] args) {
        Solution_45 solution_45 = new Solution_45();
        System.out.println(solution_45.minNumber(new int[]{3, 3, 34, 5, 9}));
        System.out.println("330".compareTo("303"));
        System.out.println("3".compareTo("30"));
    }
}

class Solution_45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
