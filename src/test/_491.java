package test;

import java.util.ArrayList;
import java.util.List;

public class _491 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        dfs(nums, 0, Integer.MIN_VALUE);

        return res;
    }

    public void dfs(int[] nums, int now, int last) {
        if (now == nums.length) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if (nums[now] >= last) {
            list.add(nums[now]);
            dfs(nums, now + 1, nums[now]);
            list.remove(list.size() - 1);
        }
        if (nums[now] != last) {
            dfs(nums, now + 1, last);
        }
    }
}
