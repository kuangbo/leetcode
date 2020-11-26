package offer_jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/26
 * Time: 上午11:24
 */
public class _offer_57 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        for (int num : nums) {
            int temp = target - num;
            if (map.containsKey(temp)) {
                if (temp != num || map.get(temp) > 1) {
                    res[0] = num;
                    res[1] = temp;
                }
            }
        }
        return res;
    }
}
