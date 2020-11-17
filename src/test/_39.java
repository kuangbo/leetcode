package test;

import java.util.ArrayList;
import java.util.List;

public class _39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] candidates, int target, int index, List<Integer> list) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
