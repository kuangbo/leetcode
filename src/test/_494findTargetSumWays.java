package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/9/1
 * Time: 下午6:45
 */
public class _494findTargetSumWays {
    int result = 0;
    // 备忘录
    Map<String, Integer> memory = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0)
            return 0;
        return backtrack(nums, 0, S);
    }

    public int backtrack(int[] nums, int i, int rest) {
        // base case
        if (i == nums.length) {
            if (rest == 0)  // 说明恰好凑出 target
                return 1;
            return 0;
        }

        // 把它俩转成字符串才能作为哈希表的键
        String key = i + "," + rest;
        // 避免重复计算
        if (memory.containsKey(key))
            return memory.get(key);

        // 还是穷举
        int result = backtrack(nums, i + 1, rest - nums[i]) + backtrack(nums, i + 1, rest + nums[i]);
        // 记入备忘录
        memory.put(key, result);
        return result;
    }
}
