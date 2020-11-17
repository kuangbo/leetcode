package test;

import java.util.ArrayList;
import java.util.List;

public class _46 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return new ArrayList<>();
        backtrack(nums, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            System.out.println(list);
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                backtrack(nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
